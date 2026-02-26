package PTIT_CNTT4_IT203_Session13.Exercise05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercise05 {
    private static final List<Patient> patients = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            System.out.print("Chọn chức năng (1-6): ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    admitPatient();
                    break;
                case "2":
                    updateDiagnosis();
                    break;
                case "3":
                    dischargePatient();
                    break;
                case "4":
                    sortPatients();
                    break;
                case "5":
                    showAllPatients();
                    break;
                case "6":
                    running = false;
                    System.out.println("Thoát chương trình. Tạm biệt.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("===== QUẢN LÝ BỆNH NHÂN =====");
        System.out.println("1. Tiếp nhận bệnh nhân");
        System.out.println("2. Cập nhật chẩn đoán (theo ID)");
        System.out.println("3. Xuất viện (xóa theo ID)");
        System.out.println("4. Sắp xếp danh sách (Tuổi giảm dần, nếu bằng -> Tên A-Z)");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("6. Thoát");
    }

    private static void admitPatient() {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine().trim();
        if (findById(id) != null) {
            System.out.println("ID đã tồn tại. Không thể tiếp nhận bệnh nhân có ID trùng.");
            return;
        }

        System.out.print("Nhập họ và tên: ");
        String name = scanner.nextLine().trim();

        int age;
        while (true) {
            System.out.print("Nhập tuổi: ");
            String ageStr = scanner.nextLine().trim();
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0) {
                    System.out.println("Tuổi không hợp lệ. Nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuổi phải là số nguyên. Nhập lại.");
            }
        }

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = scanner.nextLine().trim();

        Patient p = new Patient(id, name, age, diagnosis);
        patients.add(p);
        System.out.println("Tiếp nhận thành công: " + p);
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân cần cập nhật chẩn đoán: ");
        String id = scanner.nextLine().trim();
        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân với ID: " + id);
            return;
        }
        System.out.println("Bệnh nhân hiện tại: " + p);
        System.out.print("Nhập chẩn đoán mới: ");
        String newDiag = scanner.nextLine().trim();
        p.setDiagnosis(newDiag);
        System.out.println("Cập nhật thành công: " + p);
    }

    private static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân xuất viện: ");
        String id = scanner.nextLine().trim();
        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân với ID: " + id);
            return;
        }
        patients.remove(p);
        System.out.println("Đã xuất viện và xóa khỏi danh sách: " + p);
    }

    private static void sortPatients() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                int ageCompare = Integer.compare(p2.getAge(), p1.getAge());
                if (ageCompare != 0) {
                    return ageCompare;
                }
                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });
        System.out.println("Đã sắp xếp danh sách theo Tuổi giảm dần, nếu bằng theo Tên A-Z.");
        showAllPatients();
    }

    private static void showAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách bệnh nhân đang trống.");
            return;
        }
        System.out.println("Danh sách bệnh nhân:");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private static Patient findById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | Tuổi: %d | Chẩn đoán: %s",
                id, fullName, age, diagnosis);
    }
}
