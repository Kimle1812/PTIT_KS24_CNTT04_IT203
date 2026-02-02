package PTIT_CNTT4_IT203_Session07.Exercise05;

class Config {
    public static final double MAX_SCORE = 10.0;
    public static final double MIN_SCORE = 0.0;
    public static final String SCHOOL_NAME = "Hoc vien Cong nghe Java-Backend-Fontend";
}

public class Exercise05 {
    public static void main(String[] args) {
        double studentScore = 8.5;

        System.out.println("Chao mung ban den voi: " + Config.SCHOOL_NAME);

        if (studentScore <= Config.MAX_SCORE && studentScore >= Config.MIN_SCORE) {
            System.out.println("Diem so " + studentScore + " la hop le.");
        } else {
            System.out.println("Diem so khong hop le!");
        }
    }
}
