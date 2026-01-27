import java.util.Scanner;
public class Exercise06 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.print("Nhap so luot muon sach ngay thu " + i + ": ");
            int luotMuon = sc.nextInt();

            if (luotMuon > max) {
                max = luotMuon;
            }
            if (luotMuon < min) {
                min = luotMuon;
            }

            if (luotMuon == 0) {
                continue;
            }

            sum += luotMuon;
            count++;
        }

        double avg = (count > 0) ? (double) sum / count : 0;

        System.out.println("\n--- KET QUA THONG KE ---");
        System.out.println("Luot muon cao nhat: " + max);
        System.out.println("Luot muon thap nhat: " + min);
        System.out.println("Trung binh (chi tinh ngay mo cua): " + avg);

        sc.close();
    } 
}
