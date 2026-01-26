public class Exercise03 {
    public static void main(String[] args) {

        String book1 = "Java Basic";
        String book2 = "Python Intro";

        System.out.println("Truoc khi hoan doi:");
        System.out.println("Book1 = " + book1 + ", Book2 = " + book2);

        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("Sau khi hoan doi:");
        System.out.println("Book1 = " + book1 + ", Book2 = " + book2);
    }
}
