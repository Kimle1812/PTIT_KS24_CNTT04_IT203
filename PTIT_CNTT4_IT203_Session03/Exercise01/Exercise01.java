package PTIT_CNTT4_IT203_Session03.Exercise01;

import java.util.Scanner;

public class Exercise01 {
    public static int[] addBookToLibraries(int n) {
        Scanner sc = new Scanner(System.in);
        int[] books = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ma sach thu " + (i + 1) + ": ");
            books[i] = sc.nextInt();
        }
        return books;
    }

    public static void displayLibraries(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Khong co ma sach de hien thi.");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach n: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("So luong phai lon hon 0.");
            return;
        }
        int[] library = addBookToLibraries(n);
        System.out.println("Danh sach ma sach:");
        displayLibraries(library);
    }
}
