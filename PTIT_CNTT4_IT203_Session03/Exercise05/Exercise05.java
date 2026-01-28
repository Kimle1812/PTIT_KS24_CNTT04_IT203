package PTIT_CNTT4_IT203_Session03.Exercise05;

import java.util.Scanner;

public class Exercise05 {
    public static int deleteBook(int[] arr, int n, int bookId) {
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return n;

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = 0;
        return n - 1;
    }

    public static void display(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] books = {101, 102, 103, 104, 105};
        int n = books.length;

        while (n > 0) {
            System.out.print("Kho sach hien tai ("+ n +" cuon): ");
            display(books, n);

            System.out.print("Nhap ma sach can xoa (0 de thoat): ");
            int id = sc.nextInt();
            if (id == 0) break;

            int newN = deleteBook(books, n, id);
            if (newN == n) {
                System.out.println("Khong tim thay ma sach " + id);
            } else {
                System.out.println("Da xoa sach ma " + id);
                n = newN;
            }
        }
    }
}
