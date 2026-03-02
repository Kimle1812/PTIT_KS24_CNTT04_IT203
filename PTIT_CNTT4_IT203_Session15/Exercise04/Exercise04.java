package PTIT_CNTT4_IT203_Session15.Exercise04;

import java.util.LinkedList;
import java.util.Queue;

class EmergencyPatient {
    private String id;
    private String name;
    private int priority;

    public EmergencyPatient(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    @Override
    public String toString() {
        String type = (priority == 1) ? "Cấp cứu" : "Thường";
        return "Patient{id='" + id + "', name='" + name + "', priority=" + type + "}";
    }
}

class EmergencyQueue {
    private Queue<EmergencyPatient> emergencyQueue = new LinkedList<>();
    private Queue<EmergencyPatient> normalQueue = new LinkedList<>();

    public void addPatient(EmergencyPatient p) {
        if (p.getPriority() == 1) {
            emergencyQueue.add(p);
            System.out.println("Đã thêm bệnh nhân cấp cứu: " + p);
        } else {
            normalQueue.add(p);
            System.out.println("Đã thêm bệnh nhân thường: " + p);
        }
    }

    public EmergencyPatient callNextPatient() {
        if (!emergencyQueue.isEmpty()) {
            EmergencyPatient next = emergencyQueue.poll();
            System.out.println("Gọi bệnh nhân cấp cứu: " + next);
            return next;
        } else if (!normalQueue.isEmpty()) {
            EmergencyPatient next = normalQueue.poll();
            System.out.println("Gọi bệnh nhân thường: " + next);
            return next;
        } else {
            System.out.println("Không có bệnh nhân nào trong hàng chờ.");
            return null;
        }
    }

    public void displayQueue() {
        System.out.println("=== Danh sách bệnh nhân cấp cứu ===");
        if (emergencyQueue.isEmpty()) {
            System.out.println("Không có bệnh nhân cấp cứu.");
        } else {
            for (EmergencyPatient p : emergencyQueue) {
                System.out.println(p);
            }
        }

        System.out.println("=== Danh sách bệnh nhân thường ===");
        if (normalQueue.isEmpty()) {
            System.out.println("Không có bệnh nhân thường.");
        } else {
            for (EmergencyPatient p : normalQueue) {
                System.out.println(p);
            }
        }
    }
}

public class Exercise04 {
    public static void main(String[] args) {
        EmergencyQueue eq = new EmergencyQueue();

        eq.addPatient(new EmergencyPatient("BN01", "Nguyen Van A", 2));
        eq.addPatient(new EmergencyPatient("BN02", "Tran Thi B", 1));
        eq.addPatient(new EmergencyPatient("BN03", "Le Van C", 2));
        eq.addPatient(new EmergencyPatient("BN04", "Pham Thi D", 1));

        eq.displayQueue();

        eq.callNextPatient();
        eq.callNextPatient();

        eq.displayQueue();
    }
}
