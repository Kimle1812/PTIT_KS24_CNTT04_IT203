import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sach 4 chu so: ");
        int code = sc.nextInt();

        int thousands = code / 1000;
        int hundreds  = (code / 100) % 10;
        int dozens    = (code / 10) % 10;
        int units     = code % 10;

        int sumOfFirstThreeNumber = thousands + hundreds + dozens;

        boolean isValid = (sumOfFirstThreeNumber % 10 == units);

        System.out.println(isValid);

        sc.close();
    }
}
