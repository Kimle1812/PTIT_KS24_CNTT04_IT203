package PTIT_CNTT4_IT203_Session03.Exercise06;

import java.util.Arrays;

public class Exercise06 {
    public static int[] mergeBooks(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            merged[index++] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            merged[index++] = b[i];
        }

        Arrays.sort(merged);

        int[] temp = new int[merged.length];
        int count = 0;

        temp[count++] = merged[0];

        for (int i = 1; i < merged.length; i++) {
            if (merged[i] != merged[i - 1]) {
                temp[count++] = merged[i];
            }
        }

        int[] arrayMerge = new int[count];
        for (int i = 0; i < count; i++) {
            arrayMerge[i] = temp[i];
        }

        return arrayMerge;
    }

    public static void displayBooks(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Mảng rỗng");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrayFirst = {1, 3, 5, 7, 9};
        int[] arraySecond = {2, 3, 5, 6, 8, 9, 10};

        int[] result = mergeBooks(arrayFirst, arraySecond);
        System.out.print("Kho cũ: ");
        displayBooks(arrayFirst);
        System.out.print("Lô mới: ");
        displayBooks(arraySecond);
        System.out.print("Kho tổng: ");
        displayBooks(result);
    }
}
