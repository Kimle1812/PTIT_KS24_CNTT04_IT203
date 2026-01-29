package PTIT_CNTT4_IT203_Session05;

import java.util.*;

public class miniProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Tim cap so co tong bang K");
            System.out.println("2. Don so 0 ve cuoi");
            System.out.println("3. Kiem tra chuoi doi xung");
            System.out.println("4. Dao nguoc tu trong cau");
            System.out.println("5. So hanh phuc");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Nhap so phan tu: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Nhap mang:");
                    for (int i = 0; i < n; i++)
                        arr[i] = sc.nextInt();
                    System.out.print("Nhap target: ");
                    int target = sc.nextInt();

                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] + arr[j] == target) {
                                System.out.println("Tim thay: " + arr[i] + ", " + arr[j]);
                                found = true;
                                break;
                            }
                        }
                        if (found)
                            break;
                    }
                    if (!found) {
                        System.out.println("Khong tim thay.");
                    }

                    break;
                }
                case 2: {
                    System.out.print("Nhap so phan tu: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Nhap mang:");
                    for (int i = 0; i < n; i++)
                        arr[i] = sc.nextInt();

                    int pos = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] != 0) {
                            arr[pos++] = arr[i];
                        }
                    }
                    while (pos < n)
                        arr[pos++] = 0;

                    System.out.println("Mang sau khi xu ly: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();

                    break;
                }
                case 3: {
                    System.out.print("Nhap chuoi: ");
                    String s = sc.nextLine();
                    s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

                    int l = 0, r = s.length() - 1;
                    boolean isPalindrome = true;
                    while (l < r) {
                        if (s.charAt(l) != s.charAt(r)) {
                            isPalindrome = false;
                            break;
                        }
                        l++;
                        r--;
                    }
                    System.out.println("Ket qua: " + isPalindrome);
                    break;
                }
                case 4: {
                    System.out.print("Nhap chuoi: ");
                    String s = sc.nextLine();

                    String[] words = s.trim().split("\\s+");

                    for (int i = 0, j = words.length - 1; i < j; i++, j--) {
                        String temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }

                    String result = "";
                    for (int i = 0; i < words.length; i++) {
                        result += words[i];
                        if (i < words.length - 1) {
                            result += " ";
                        }
                    }

                    System.out.println("Chuoi sau khi xu ly:");
                    System.out.println(result);
                    break;
                }

                case 5: {
                    System.out.print("Nhap so nguyen duong: ");
                    int n = sc.nextInt();

                    int count = 0;
                    boolean isHappy = false;
                    while (count < 100) {
                        int sum = 0;
                        int temp = n;
                        while (temp > 0) {
                            int d = temp % 10;
                            sum += d * d;
                            temp /= 10;
                        }
                        n = sum;
                        if (n == 1) {
                            isHappy = true;
                            break;
                        }
                        count++;
                    }

                    System.out.println("Ket qua: " + (isHappy ? "So hanh phuc" : "Khong phai so hanh phuc"));
                    break;
                }

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);

        sc.close();
    }
}
