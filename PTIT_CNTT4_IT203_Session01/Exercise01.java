import java.util.Scanner;

public class Exercise01{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma sach: ");
        String bookID = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        String bookName = scanner.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int publishYear = scanner.nextInt();

        System.out.print("Nhap gia sach: ");
        double price = scanner.nextDouble();

        System.out.print("Sach can hay da muon (true/false): ");
        boolean isAvailable = scanner.nextBoolean();

        int ageBook = 2026 - publishYear;

        System.out.println("\n===== THONG TIN SACH =====");
        System.out.println("Ma sach: " + bookID);
        System.out.println("Ten sach: " + bookName.toUpperCase());
        System.out.printf("Gia sach: %.2f\n", price);
        System.out.println("Nam xuat ban: " + publishYear);
        System.out.println("Tuoi tho sach: " + ageBook + " nam");
        System.out.println("Tinh trang: " + (isAvailable ? "Con sach" : "Đa muon"));
    }
}
