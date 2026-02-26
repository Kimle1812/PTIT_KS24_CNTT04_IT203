package PTIT_CNTT4_IT203_Session13.Exercise01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(36.5);
        list.add(40.2);
        list.add(37.0);
        list.add(12.5);
        list.add(39.8);
        list.add(99.9);
        list.add(36.8);
        double sum = 0;
        Iterator<Double> iterator = list.iterator();
        while (iterator.hasNext()) {
            double element = iterator.next();
            if (element <= 34.0 || element >= 42.0) {
                iterator.remove();
            }
        }
        System.out.print("Danh sách sau khi lọc: ");
        for (double element : list) {
            sum += element;
        }
        System.out.println(list);
        double avg = sum / list.size();
        System.out.println("\nNhiệt độ trung bình: "+ avg);
    }
}