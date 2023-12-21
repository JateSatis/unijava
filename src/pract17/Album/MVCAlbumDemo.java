package pract17.Album;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MVCAlbumDemo {
    public static void main(String[] args) {
        Album model = retrieveAlbumFromDatabase();
        AlbumView view = new AlbumView();

        ArrayList<Album> models = new ArrayList<>();
        models.add(model);

        AlbumController controller = new AlbumController(models, view);

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setBackground(new Color(255, 255, 255));

        JTextField searchBar = new JTextField();
        JButton searchBtn = new JButton("Поиск");

        searchBar.setBounds(30, 30, 200, 50);
        searchBtn.setBounds(260, 30, 100, 50);

        JTextPane albumData = new JTextPane();

        Font albumNameFont = new Font("Courier New", Font.BOLD, 20);
        albumData.setFont(albumNameFont);
        albumData.setBounds(30, 110, 200, 260);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String albumName = searchBar.getText();
                Album searchedAlbum = controller.getAlbumByName(albumName);
                controller.setSelectedAlbum(searchedAlbum);
                String outputData = controller.updateView();
                albumData.setText(outputData);
            }
        });

        frame.add(searchBar);
        frame.add(searchBtn);
        frame.add(albumData);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.validate();
        frame.repaint();
    }

    public static Album retrieveAlbumFromDatabase() {
        ArrayList<String> songs = new ArrayList<>();
        songs.add("Sicko Mode");
        songs.add("Sicko Mode");
        songs.add("Sicko Mode");
        songs.add("Sicko Mode");
        return new Album("Travis Scott", "ASTROWORLD", songs);
    }
}
