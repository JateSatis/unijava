package pract17.Album;

import java.util.ArrayList;

public class Album {
    private String author;
    private String name;
    private ArrayList<String> songs;

    public Album(String author, String name, ArrayList<String> songs) {
        this.author = author;
        this.name = name;
        this.songs = songs;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }
}
