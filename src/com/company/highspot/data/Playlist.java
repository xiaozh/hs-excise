package com.company.highspot.data;

import java.util.Set;

public class Playlist {
	private String id;
	private String user_id;
	private Set<String> song_ids;

	public Playlist() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Set<String> getSong_ids() {
		return song_ids;
	}

	public void setSong_ids(Set<String> song_ids) {
		this.song_ids = song_ids;
	}
}
