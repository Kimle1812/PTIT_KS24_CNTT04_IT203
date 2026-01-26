import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so thu tu cua sach trong he thong: ");

        if (sc.hasNextInt()) {
            int stt = sc.nextInt();

            if (stt <= 0) {
                System.out.println("Vui long nhap so thu tu lon hon 0!");
            } else {
                int ke = (stt - 1) / 25 + 1;
                int viTri = (stt - 1) % 25 + 1;

                String khuVuc = (ke <= 10) ? "Khu Can (Gan cua)" : "Khu Vien (Xa cua)";

                System.out.println("\n--- THONG TIN DINH VI ---");
                System.out.println("Sach so: " + stt);
                System.out.println("Dia chi: Ke " + ke + " - Vi tri " + viTri);
                System.out.println("Phan khu: " + khuVuc);
            }
        } else {
            System.out.println("Loi: Vui long nhap mot so nguyen!");
        }

        sc.close();
    }
}
