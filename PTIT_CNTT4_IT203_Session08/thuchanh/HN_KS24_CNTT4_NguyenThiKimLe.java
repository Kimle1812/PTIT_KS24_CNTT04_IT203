package PTIT_CNTT4_IT203_Session08.thuchanh;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

import PTIT_CNTT4_IT203_Session08.thuchanh.Student;

public class HN_KS24_CNTT4_NguyenThiKimLe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n=====QUẢN LÝ ĐIỂM SINH VIÊN=====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo Học lực");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:{ //Nhập danh sách sinh viên
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt(); sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        while (!(id.startsWith("SV") && id.length() == 5)) {
                            System.out.print("ID không hợp lệ! Nhập lại (SVxxx): ");
                            id = sc.nextLine();
                        }
                        System.out.print("Tên: ");
                        String name = sc.nextLine();
                        System.out.print("Điểm: ");
                        double score = sc.nextDouble();
                        sc.nextLine();
                        students.add(new Student(id, name, score));
                    }
                }
                    break;
                case 2: //Hiển thị danh sách sinh viên
                System.out.println("===== DANH SÁCH SINH VIÊN =====");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3://Tìm kiếm sinh viên theo Học lực
                    System.out.print("Nhập học lực cần tìm (Gioi/Kha/Trung Binh): ");
                    String rank = sc.nextLine();
                    int count=0;
                    System.out.println("===== KẾT QUẢ TÌM KIẾM =====");
                    for (Student s : students) {
                        if (s.getRank().equalsIgnoreCase(rank)) {
                            System.out.println(s);
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("Không có học sinh có học lực này");
                    }
                    break;
                case 4://Sắp xếp theo học lực giảm dần
                    students.sort((s1, s2) -> {
                        return Double.compare(s2.getScore(), s1.getScore());
                    });
                    System.out.println("===== DANH SÁCH SAU KHI SẮP XẾP =====");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while(choice != 5);
    }

}