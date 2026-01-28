package PTIT_CNTT4_IT203_Session03.Exercise03;

public class Exercise03 {
    public static void maxQuantityOfBooks(String[] names, int[] quantities) {
        if (names == null || quantities == null || names.length == 0 || names.length != quantities.length) {
            System.out.println("Du lieu khong hop le.");
            return;
        }

        int max = quantities[0];
        for (int i = 0; i < quantities.length; i++) {
            int q = quantities[i];
            if (q > max) {
                max = q;
            }
        }

        System.out.println("Sach co so luong nhieu nhat (" + max + "):");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println("- " + names[i] + " : " + quantities[i]);
            }
        }
    }

    public static void minQuantityOfBooks(String[] names, int[] quantities) {
        if (names == null || quantities == null || names.length == 0 || names.length != quantities.length) {
            System.out.println("Du lieu khong hop le.");
            return;
        }

        int min = quantities[0];
        for (int i = 0; i < quantities.length; i++) {
            int q = quantities[i];
            if (q < min) {
                min = q;
            }
        }

        System.out.println("Sach co so luong it nhat (" + min + "):");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println("- " + names[i] + " : " + quantities[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {
                "Lap trinh Java",
                "Lap trinh C++",
                "Lap trinh Python",
                "Lap trinh Web",
                "Lap trinh Mobile"
        };
        int[] quantities = { 12, 5, 16, 3, 7 };

        maxQuantityOfBooks(names, quantities);
        System.out.println();
        minQuantityOfBooks(names, quantities);
    }
}
