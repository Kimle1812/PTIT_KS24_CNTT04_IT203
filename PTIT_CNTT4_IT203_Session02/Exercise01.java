import java.util.Scanner;
public class Exercise01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tuoi: ");
        int age = sc.nextInt();

        System.out.print("Nhap so sach dang giu: ");
        int books = sc.nextInt();

        if (age >= 18 && books < 3) {
            System.out.println("Cho phep muon sach");
        } else {
            if (age < 18) {
                System.out.println("Ban chua du tuoi");
            }
            if (books >= 3) {
                System.out.println("Ban da muon qua so luong cho phep");
            }
        }

        sc.close();
    }
}
