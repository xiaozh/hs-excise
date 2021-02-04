package com.company.highspot;

import com.company.highspot.data.Addsong;
import com.company.highspot.data.Changes;
import com.company.highspot.data.MixType;
import com.company.highspot.data.Playlist;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ApplyChange {

    public static void main(String[] args)  {
        InputStream mixStream=null,changeStream=null;
        try {
            File mixFile = new File(args[0]);
            mixStream = new FileInputStream(mixFile);
            ObjectMapper mapper = new ObjectMapper();
            MixType mixType = mapper.readValue(mixStream, MixType.class);
            File changeFile =  new File(args[1]);
            changeStream = new FileInputStream(changeFile);
            Changes changes = mapper.readValue(changeStream, Changes.class);

            for(Playlist pl: changes.getAdds()){
                mixType.getPlaylists().add(pl);
            }

            Iterator<Playlist> i = mixType.getPlaylists().iterator();
            while (i.hasNext()) {
                Playlist pl = i.next();
                if(changes.getRemoves().contains(pl.getId()))
                    i.remove();
            }
            for(Playlist pl:mixType.getPlaylists()){
                if(changes.getRemoves().contains(pl.getId()))
                    mixType.getPlaylists().remove(pl);
            }
            for(Playlist pl:mixType.getPlaylists()){
                for(Addsong addsong:changes.getAddsongs()){
                    if(pl.getId().equals(addsong.getPlaylist_id())){
                        pl.getSong_ids().add(addsong.getSong_id());
                    }
                }
            }
            File outFile = new File(args[2]);
            mapper.writeValue(outFile,mixType);
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally {
            try {
                if (mixStream != null)
                    mixStream.close();
                if (changeStream != null)
                    changeStream.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
}
