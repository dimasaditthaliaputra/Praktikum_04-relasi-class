package PlayListMusic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private boolean isPublic;
    private ArrayList<Music> listMusic;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        isPublic = true;
        listMusic = new ArrayList<Music>();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void addMusic(Music music) {
        if (!listMusic.contains(music)) {
            listMusic.add(music);
            System.out.println("Lagu berhasil ditambahkan!");
        } else {
            System.out.println("Lagu sudah ada di playlist!");
        }
    }

    public void deleteMusic(Music music) {
        listMusic.remove(music);
    }

    public ArrayList<Music> getAllSong() {
        return listMusic;
    }
}
