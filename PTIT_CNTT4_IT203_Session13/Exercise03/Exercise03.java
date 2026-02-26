package PTIT_CNTT4_IT203_Session13.Exercise03;

import java.util.ArrayList;
import java.util.List;

public class Exercise03 {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();
        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Trường hợp 1: Integer
        List<Integer> listIntA = new ArrayList<>();
        List<Integer> listIntB = new ArrayList<>();
        listIntA.add(101);
        listIntA.add(102);
        listIntA.add(105);
        listIntB.add(102);
        listIntB.add(105);
        listIntB.add(108);

        List<Integer> commonInt = findCommonPatients(listIntA, listIntB);
        System.out.println("Test Case 1 Output: " + commonInt);

        // Trường hợp 2: String
        List<String> listStrA = new ArrayList<>();
        List<String> listStrB = new ArrayList<>();
        listStrA.add("DN01");
        listStrA.add("DN02");
        listStrA.add("DN03");
        listStrB.add("DN02");
        listStrB.add("DN04");

        List<String> commonStr = findCommonPatients(listStrA, listStrB);
        System.out.println("Test Case 2 Output: " + commonStr);
    }
}