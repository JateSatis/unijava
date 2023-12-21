package pract17.Album;

import java.util.ArrayList;
import java.util.Objects;

public class AlbumController {
    private ArrayList<Album> models;
    private AlbumView view;
    private Album selectedAlbum;

    public AlbumController(ArrayList<Album> models, AlbumView view) {
        this.models = models;
        this.view = view;
    }

    public Album getAlbumByName(String name) {
        for (Album album : models) {
            if (Objects.equals(album.getName(), name)) return album;
        }
        return models.get(0);
    }

    public void setSelectedAlbum(Album selectedAlbum) {
        this.selectedAlbum = selectedAlbum;
    }

    public String updateView() {
        return view.showAlbumInformation(selectedAlbum.getName(), selectedAlbum.getAuthor(), selectedAlbum.getSongs());
    }
}
