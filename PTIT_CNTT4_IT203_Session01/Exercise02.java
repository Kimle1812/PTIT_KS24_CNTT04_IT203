import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so ngay cham tre: ");
        int n = sc.nextInt();

        System.out.print("Nhap so luong sach muon: ");
        int m = sc.nextInt();

        double total = n * m * 5000;
        System.out.println("Tien phat goc: " + total + " VND");

        if (n > 7 && m >= 3) {
            total = total * 1.2;
        }

        System.out.println("Tien phat sau dieu chinh: " + total + " VND");

        boolean lockCard = total > 50000;
        System.out.println("Yeu cau khoa the: " + lockCard);
    }
}
