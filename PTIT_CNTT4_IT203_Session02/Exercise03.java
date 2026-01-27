import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach tra muon: ");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhap so ngay tre cua sach thu " + i + ": ");
            int daysLate = sc.nextInt();
            total += daysLate * 5000;
        }

        System.out.println("Tong so tien phat: " + total + " VND");

        sc.close();
    }
}


