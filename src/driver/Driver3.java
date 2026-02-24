import java.util.ArrayList;
import java.util.Scanner;

class Laundry {
    int nomor;
    String nama;
    String statusAsrama;
    int jumlahItem;
    String statusLaundry;

    Laundry(int nomor, String nama, String statusAsrama, int jumlahItem) {
        this.nomor = nomor;
        this.nama = nama;
        this.statusAsrama = statusAsrama;
        this.jumlahItem = jumlahItem;
        this.statusLaundry = "Dikumpulkan";
    }

    void tampilkan() {
        System.out.println("No Antrian     : " + nomor);
        System.out.println("Nama           : " + nama);
        System.out.println("Status Asrama  : " + statusAsrama);
        System.out.println("Jumlah Item    : " + jumlahItem);
        System.out.println("Status Laundry : " + statusLaundry);
        System.out.println("-----------------------------------");
    }
}

public class SistemLaundrySimonLaplace {

    static ArrayList<Laundry> daftarLaundry = new ArrayList<>();
    static int nomorAntrian = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM LAUNDRY ASRAMA SIMON LAPLACE ===");
            System.out.println("1. Tambah Laundry");
            System.out.println("2. Lihat Semua Laundry");
            System.out.println("3. Update Status Laundry");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahLaundry(input);
                    break;
                case 2:
                    lihatLaundry();
                    break;
                case 3:
                    updateStatus(input);
                    break;
                case 4:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 4);

        input.close();
    }

    static void tambahLaundry(Scanner input) {
        System.out.print("Nama Mahasiswa: ");
        String nama = input.nextLine();

        System.out.print("Status (KK Asuh/Adek Asuh): ");
        String status = input.nextLine();

        System.out.print("Jumlah Item Laundry: ");
        int jumlah = input.nextInt();

        Laundry laundryBaru = new Laundry(nomorAntrian++, nama, status, jumlah);
        daftarLaundry.add(laundryBaru);

        System.out.println("Laundry berhasil ditambahkan dengan No Antrian: " + laundryBaru.nomor);
    }

    static void lihatLaundry() {
        if (daftarLaundry.isEmpty()) {
            System.out.println("Belum ada data laundry.");
        } else {
            System.out.println("\n=== DAFTAR LAUNDRY (FIFO) ===");
            for (Laundry l : daftarLaundry) {
                l.tampilkan();
            }
        }
    }

    static void updateStatus(Scanner input) {
        System.out.print("Masukkan Nomor Antrian: ");
        int no = input.nextInt();
        input.nextLine();

        for (Laundry l : daftarLaundry) {
            if (l.nomor == no) {
                System.out.println("Pilih Status Baru:");
                System.out.println("1. Dijemput");
                System.out.println("2. Diproses");
                System.out.println("3. Selesai");
                System.out.println("4. Diantar");
                System.out.print("Pilihan: ");
                int pilihStatus = input.nextInt();

                switch (pilihStatus) {
                    case 1: l.statusLaundry = "Dijemput"; break;
                    case 2: l.statusLaundry = "Diproses"; break;
                    case 3: l.statusLaundry = "Selesai"; break;
                    case 4: l.statusLaundry = "Diantar"; break;
                    default: System.out.println("Pilihan tidak valid.");
                }

                System.out.println("Status berhasil diperbarui.");
                return;
            }
        }

        System.out.println("Nomor antrian tidak ditemukan.");
    }
}
