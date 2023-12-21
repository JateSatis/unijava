package pract17.Album;

import java.util.ArrayList;

public class AlbumView {
    public String showAlbumInformation(String name, String author, ArrayList<String> songs) {
        StringBuilder result = new StringBuilder();
        result.append("Album name: ").append(name).append("\n");
        result.append("Album author: ").append(author).append("\n");
        result.append("Songs: ").append("\n");
        for (String song : songs) {
            result.append(song).append("\n");
        }
        return result.toString();
    }
}
