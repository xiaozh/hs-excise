package com.company.highspot.data;

import java.util.List;

public class Changes {
	private List<Playlist> adds;
	private List<String> removes;
	private List<Addsong> addsongs;

	public Changes() {
	}
	public List<Playlist> getAdds() {
		return adds;
	}

	public void setAdds(List<Playlist> adds) {
		this.adds = adds;
	}

	public List<String> getRemoves() {
		return removes;
	}

	public void setRemoves(List<String> removes) {
		this.removes = removes;
	}

	public List<Addsong> getAddsongs() {
		return addsongs;
	}

	public void setAddsongs(List<Addsong> addsongs) {
		this.addsongs = addsongs;
	}
}
