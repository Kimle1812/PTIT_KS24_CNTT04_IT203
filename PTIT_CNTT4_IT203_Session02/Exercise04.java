import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id;

        do {
            System.out.print("Nhap ID sach moi: ");
            id = sc.nextInt();

            if (id <= 0) {
                System.out.println("Ma khong hop le, hay nhap lai");
            }
        } while (id <= 0);

        System.out.println("Luu ma sach thanh cong");

        sc.close();
    }
}
