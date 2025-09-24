package PlayListMusic;

public class Music {
    private int idMusic;
    private String title;
    private String artist;
    private int duration;

    private static int counter = 0;

    public Music(String title, String artist, int duration) {
        this.idMusic = ++counter;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void playLagu() {
        System.out.println("| Sedang memutar lagu: " + title + " | " + artist + " | Durasi: " + duration + " detik |");
    }

    public String getInfoMusic() {
        String info = "";
        info += "\tID Music     : " + idMusic;
        info += ", Title        : " + title;
        info += ", Artist       : " + artist;
        info += ", Duration     : " + duration + " detik";
        info += "\n";

        return info;
    }
}
