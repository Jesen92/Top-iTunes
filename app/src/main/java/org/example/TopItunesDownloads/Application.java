package org.example.TopItunesDownloads;

public class Application {
	
	private String name, artist, releaseDate;
	private int rank;

	public int getRank() { return rank;	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String toString(){
		return rank+". \n"+"Name: " +this.name + "\n" + "Artist: "+this.artist+"\n"+"Release Date: "+this.releaseDate+"\n";
		
	}
}
