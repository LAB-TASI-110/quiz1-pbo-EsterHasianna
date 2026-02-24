import java.util.Scanner;

public class Diver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String kode;
        String namaMenu = "";
        int harga = 0;
        int porsiButet;
        int totalPorsi;
        int subtotal;
        int totalBayar = 0;

        System.out.printf("%-25s %-10s %-10s %-10s\n",
                "Menu", "Porsi", "Harga", "Total");
        System.out.println("====================================================");

        while (true) {

            kode = input.nextLine();

            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            switch (kode) {
                case "NGS":
                    namaMenu = "Nasi Goreng Spesial";
                    harga = 15000;
                    break;
                case "AP":
                    namaMenu = "Ayam Penyet";
                    harga = 20000;
                    break;
                case "SA":
                    namaMenu = "Sate Ayam";
                    harga = 25000;
                    break;
                case "BU":
                    namaMenu = "Bakso Urat";
                    harga = 18000;
                    break;
                case "MAP":
                    namaMenu = "Mie Ayam Pangsit";
                    harga = 15000;
                    break;
                case "GG":
                    namaMenu = "Gado-Gado";
                    harga = 15000;
                    break;
                case "SAM":
                    namaMenu = "Soto Ayam";
                    harga = 17000;
                    break;
                case "RD":
                    namaMenu = "Rendang Daging";
                    harga = 25000;
                    break;
                default:
                    continue;
            }

            // Input porsi Butet
            porsiButet = Integer.parseInt(input.nextLine());

            // Rasio berat 2 : 1
            totalPorsi = porsiButet + (2 * porsiButet);

            subtotal = totalPorsi * harga;
            totalBayar += subtotal;

            System.out.printf("%-25s %-10d %-10d %-10d\n",
                    namaMenu, totalPorsi, harga, subtotal);
        }

        System.out.println("====================================================");
        System.out.printf("%-25s %25d\n", "Total Pembayaran", totalBayar);

        input.close();
    }
}
