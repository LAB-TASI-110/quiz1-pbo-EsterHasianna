import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input jumlah data
        int N = input.nextInt();

        // Input nilai
        int[] nilai = new int[N];
        for (int i = 0; i < N; i++) {
            nilai[i] = input.nextInt();
        }

        // Input kode kelompok
        int kelompok = input.nextInt();

        int index = 0;
        int currentKelompok = 1;
        int total = 0;

        while (index < N) {
            if (currentKelompok == kelompok) {
                for (int i = 0; i < currentKelompok && index < N; i++) {
                    total += nilai[index];
                    index++;
                }
                break;
            } else {
                index += currentKelompok;
            }
            currentKelompok++;
        }

        System.out.println(total);
    }
}

