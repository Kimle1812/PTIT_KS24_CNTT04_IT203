
import java.util.Scanner;

public class Exercise01 {
    public static String capitalizeWords(String str) {
        str = str.trim().replaceAll("\\s+", " ");
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bookName = "Lap trinh Java co ban";
        String authorName = "Kim Le";

        bookName = bookName.trim().replaceAll("\\s+", " ").toUpperCase();
        authorName = capitalizeWords(authorName);

        String output = "[" +bookName+ "]" + " - Tac gia: " + authorName;
        System.out.println(output);
    }
}