package PlayListMusic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    private String uuid;
    private String username;
    private String password;
    private ArrayList<Playlist> listPlaylist = new ArrayList<Playlist>();

    public User(String username, String password) {
        this.uuid = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean signin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void createPlaylist(String playlistName) {
        Playlist newPlaylist = new Playlist(playlistName);
        listPlaylist.add(newPlaylist);
        System.out.println("Playlist '" + playlistName + "' berhasil dibuat!");
    }

    public ArrayList<Playlist> getListPlaylist() {
        return listPlaylist;
    }

    public void getAllPlaylist() {
        if (listPlaylist.isEmpty()) {
            System.out.println("Belum ada playlist.");
            return;
        }

        System.out.printf("%-5s %-20s %-10s%n", "No", "Nama Playlist", "Jumlah Lagu");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < listPlaylist.size(); i++) {
            Playlist p = listPlaylist.get(i);
            System.out.printf("%-5d %-20s %-10d%n", i + 1, p.getPlaylistName(), p.getAllSong().size());
        }
    }
}
