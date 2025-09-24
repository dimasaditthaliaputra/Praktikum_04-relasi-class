package PlayListMusic;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User("dimasadit", "12345");

        System.out.println("=== Selamat datang di PlayListMusic ===");

        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            if (user.signin(username, password)) {
                loginSuccess = true;
                System.out.println("Login berhasil!\n");
            } else {
                System.out.println("Username atau password salah, coba lagi.\n");
            }
        }

        Music[] musicList = {
                new Music("Blinding Lights", "The Weeknd", 200),
                new Music("Shape of You", "Ed Sheeran", 240),
                new Music("Levitating", "Dua Lipa", 220),
                new Music("Believer", "Imagine Dragons", 210)
        };

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Buat Playlist");
            System.out.println("2. Lihat Semua Playlist");
            System.out.println("3. Tambah Lagu ke Playlist");
            System.out.println("4. Putar Lagu dari Playlist");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama playlist: ");
                    String playlistName = sc.nextLine();
                    user.createPlaylist(playlistName);
                    break;

                case 2:
                    user.getAllPlaylist();
                    break;

                case 3:
                    user.getAllPlaylist();
                    System.out.print("Pilih nomor playlist: ");
                    int playlistIdx = sc.nextInt() - 1;
                    sc.nextLine();

                    if (playlistIdx >= 0 && playlistIdx < user.getListPlaylist().size()) {
                        Playlist selected = user.getListPlaylist().get(playlistIdx);

                        System.out.println("Daftar lagu:");
                        for (int i = 0; i < musicList.length; i++) {
                            System.out.println((i + 1) + ". " + musicList[i].getInfoMusic());
                        }

                        System.out.print("Pilih nomor lagu untuk ditambahkan: ");
                        int songIdx = sc.nextInt() - 1;
                        sc.nextLine();

                        if (songIdx >= 0 && songIdx < musicList.length) {
                            selected.addMusic(musicList[songIdx]);
                        } else {
                            System.out.println("Pilihan lagu tidak valid.");
                        }
                    } else {
                        System.out.println("Pilihan playlist tidak valid.");
                    }
                    break;

                case 4:
                    user.getAllPlaylist();
                    System.out.print("Pilih nomor playlist: ");
                    int playIdx = sc.nextInt() - 1;
                    sc.nextLine();

                    if (playIdx >= 0 && playIdx < user.getListPlaylist().size()) {
                        Playlist p = user.getListPlaylist().get(playIdx);
                        if (p.getAllSong().isEmpty()) {
                            System.out.println("Playlist kosong.");
                        } else {
                            for (Music m : p.getAllSong()) {
                                m.playLagu();
                            }
                        }
                    } else {
                        System.out.println("Pilihan playlist tidak valid.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan PlayListMusic!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }
}