package PTIT_CNTT4_IT203_Session15.Exercise02;

import java.util.LinkedList;
import java.util.Queue;

class Patient {
    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "', age=" + age + "}";
    }
}

class PatientQueue {
    private Queue<Patient> queue = new LinkedList<>();

    public void addPatient(Patient p) {
        queue.add(p);
        System.out.println("Đã thêm bệnh nhân: " + p);
    }

    public Patient callNextPatient() {
        if (!queue.isEmpty()) {
            Patient next = queue.poll();
            System.out.println("Gọi bệnh nhân: " + next);
            return next;
        } else {
            System.out.println("Không có bệnh nhân nào trong hàng chờ.");
            return null;
        }
    }

    public Patient peekNextPatient() {
        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            System.out.println("Không có bệnh nhân nào trong hàng chờ.");
            return null;
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Danh sách bệnh nhân trống.");
        } else {
            System.out.println("Danh sách bệnh nhân đang chờ:");
            for (Patient p : queue) {
                System.out.println(p);
            }
        }
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        PatientQueue pq = new PatientQueue();

        pq.addPatient(new Patient("BN01", "Nguyen Van A", 30));
        pq.addPatient(new Patient("BN02", "Tran Thi B", 25));
        pq.addPatient(new Patient("BN03", "Le Van C", 40));

        pq.displayQueue();

        System.out.println("Bệnh nhân tiếp theo: " + pq.peekNextPatient());

        pq.callNextPatient();

        pq.displayQueue();
    }
}
