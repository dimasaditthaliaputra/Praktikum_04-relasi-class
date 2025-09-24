package RumahSakit;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pasien {
    private String noRekamDisini;
    private String nama;
    private ArrayList<Konsultasi> riwayatKonsultasi;

    public Pasien(String noRekamDisini, String nama) {
        this.noRekamDisini = noRekamDisini;
        this.nama = nama;
        this.riwayatKonsultasi = new ArrayList<Konsultasi>();
    }

    public String getNoRekamDisini() {
        return noRekamDisini;
    }

    public void setNoRekamDisini(String noRekamDisini) {
        this.noRekamDisini = noRekamDisini;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInfo() {
        String info = "";
        info += "No Rekam Disini    : " + this.noRekamDisini + "\n";
        info += "Nama               : " + this.nama + "\n";

        if (!riwayatKonsultasi.isEmpty()) {
            info += "Riwayat Konsultasi : \n";

            for (Konsultasi konsultasi : this.riwayatKonsultasi) {
                info += konsultasi.getInfo();
            }
        } else {
            info += "Belum ada riwayat konsultasi";
        }

        info += "\n";

        return info;
    }

    public void tambahKonsultasi(LocalDate tanggal, Pegawai dokter, Pegawai perawat) {
        Konsultasi konsultasi = new Konsultasi();
        konsultasi.setTanggal(tanggal);
        konsultasi.setDokter(dokter);
        konsultasi.setPerawat(perawat);
        this.riwayatKonsultasi.add(konsultasi);
    }
}
