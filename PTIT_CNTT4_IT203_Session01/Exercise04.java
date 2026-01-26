import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap gia sach (USD): ");
        double giaSachUSD = sc.nextDouble();
        System.out.print("Nhap ty gia (so thuc): ");
        float tyGia = sc.nextFloat();

        double tongTienVND = giaSachUSD * tyGia;

        long tienLamTron = (long) tongTienVND;

        System.out.println("Gia lam tron de thanh toan: " + tienLamTron + " VND");

        sc.close();
    }
}
