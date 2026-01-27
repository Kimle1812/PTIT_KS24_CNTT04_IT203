import java.util.Scanner;
public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int diemUyTin = 100;
        int soNgayTre;

        while (true) {
            System.out.print("Nhap so ngay tre (nhap 999 de thoat): ");
            soNgayTre = sc.nextInt();

            if (soNgayTre == 999) {
                break; 
            }

            if (soNgayTre <= 0) {
                diemUyTin += 5;
            } else {
                diemUyTin -= soNgayTre * 2;
            }
        }

        System.out.println("Tong diem uy tin: " + diemUyTin);

        if (diemUyTin > 120) {
            System.out.println("Xep loai: Doc gia Than thiet");
        } else if (diemUyTin >= 80) {
            System.out.println("Xep loai: Doc gia Tieu chuan");
        } else {
            System.out.println("Xep loai: Doc gia Can luu y");
        }

        sc.close();
    }
}
