package PTIT_CNTT4_IT203_Session15.Exercise05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreatmentStep {
    private String description;
    private String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "[" + time + "] " + description;
    }
}

class Patient {
    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "', age=" + age + "}";
    }
}

class EmergencyCase {
    private Patient patient;
    private Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(Patient patient) {
        this.patient = patient;
    }

    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println("Thêm bước xử lý cho " + patient.getName() + ": " + step);
    }

    public TreatmentStep undoStep() {
        if (!steps.isEmpty()) {
            TreatmentStep undone = steps.pop();
            System.out.println("Hoàn tác bước xử lý: " + undone);
            return undone;
        } else {
            System.out.println("Không có bước xử lý nào để hoàn tác.");
            return null;
        }
    }

    public void displaySteps() {
        System.out.println("Các bước xử lý của bệnh nhân " + patient.getName() + ":");
        if (steps.isEmpty()) {
            System.out.println("Chưa có bước xử lý nào.");
        } else {
            for (TreatmentStep step : steps) {
                System.out.println(step);
            }
        }
    }

    public Patient getPatient() {
        return patient;
    }
}

class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>();

    public void addCase(EmergencyCase c) {
        cases.add(c);
        System.out.println("Đã thêm ca cấp cứu: " + c.getPatient());
    }

    public EmergencyCase getNextCase() {
        if (!cases.isEmpty()) {
            EmergencyCase next = cases.poll();
            System.out.println("Xử lý ca cấp cứu của bệnh nhân: " + next.getPatient());
            return next;
        } else {
            System.out.println("Không có ca cấp cứu nào trong hàng chờ.");
            return null;
        }
    }
}

public class Exercise05 {
    public static void main(String[] args) {
        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        Patient p1 = new Patient("BN01", "Nguyen Van A", 35);
        Patient p2 = new Patient("BN02", "Tran Thi B", 28);

        EmergencyCase case1 = new EmergencyCase(p1);
        EmergencyCase case2 = new EmergencyCase(p2);

        queue.addCase(case1);
        queue.addCase(case2);

        EmergencyCase currentCase = queue.getNextCase();

        currentCase.addStep(new TreatmentStep("Tiếp nhận", "02/03/2026 22:15"));
        currentCase.addStep(new TreatmentStep("Chẩn đoán", "02/03/2026 22:20"));
        currentCase.addStep(new TreatmentStep("Điều trị", "02/03/2026 22:30"));

        currentCase.displaySteps();

        currentCase.undoStep();

        currentCase.displaySteps();
    }
}
