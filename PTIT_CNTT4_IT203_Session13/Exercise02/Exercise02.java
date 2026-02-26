package PTIT_CNTT4_IT203_Session13.Exercise02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Paracetamol");
        list.add("Ibuprofen");
        list.add("Panadol");
        list.add("Paracetamol");
        list.add("Aspirin");
        list.add("Ibuprofen");

        List<String> uniqueList = new ArrayList<>();
        for (String med : list) {
            if (!uniqueList.contains(list)) {
                uniqueList.add(med);
            }
        }
        Collections.sort(uniqueList);
        System.out.println(uniqueList);
    }
}