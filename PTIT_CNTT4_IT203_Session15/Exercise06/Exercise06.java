package PTIT_CNTT4_IT203_Session15.Exercise06;

import java.util.*;

class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;

    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "', age=" + age + ", gender='" + gender + "'}";
    }
}

class PatientWaitingQueue {
    private Queue<Patient> waitingQueue = new LinkedList<>();
    private int totalPatients = 0;

    public void addPatient(Patient p) {
        waitingQueue.add(p);
        totalPatients++;
    }

    public Patient callNextPatient() {
        if (!waitingQueue.isEmpty()) {
            totalPatients--;
            return waitingQueue.poll();
        }
        return null;
    }

    public void displayQueue() {
        System.out.println("Danh sách bệnh nhân chờ khám:");
        for (Patient p : waitingQueue) {
            System.out.println(p);
        }
    }
}

class EditAction {
    private String description;
    private String editedBy;
    private String editTime;

    public EditAction(String description, String editedBy, String editTime) {
        this.description = description;
        this.editedBy = editedBy;
        this.editTime = editTime;
    }

    @Override
    public String toString() {
        return "[" + editTime + "] " + description + " (by " + editedBy + ")";
    }
}

class MedicalRecordHistory {
    private Stack<EditAction> editStack = new Stack<>();
    private String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
    }

    public void addEdit(EditAction action) {
        editStack.push(action);
    }

    public EditAction undoEdit() {
        if (!editStack.isEmpty()) {
            return editStack.pop();
        }
        return null;
    }

    public void displayHistory() {
        System.out.println("Lịch sử chỉnh sửa bệnh án " + recordId + ":");
        for (EditAction e : editStack) {
            System.out.println(e);
        }
    }
}

class Ticket {
    private int ticketNumber;
    private String issuedTime;

    public Ticket(int ticketNumber, String issuedTime) {
        this.ticketNumber = ticketNumber;
        this.issuedTime = issuedTime;
    }

    @Override
    public String toString() {
        return "Ticket{number=" + ticketNumber + ", issuedTime='" + issuedTime + "'}";
    }
}

class TicketSystem {
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private int currentNumber = 0;

    public Ticket issueTicket(String time) {
        currentNumber++;
        Ticket t = new Ticket(currentNumber, time);
        ticketQueue.add(t);
        return t;
    }

    public Ticket callNextTicket() {
        if (!ticketQueue.isEmpty()) {
            return ticketQueue.poll();
        }
        return null;
    }

    public void displayTickets() {
        System.out.println("Danh sách số thứ tự đang chờ:");
        for (Ticket t : ticketQueue) {
            System.out.println(t);
        }
    }
}

class InputAction {
    private String fieldName;
    private String oldValue;
    private String newValue;
    private String actionTime;

    public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return "[" + actionTime + "] " + fieldName + ": '" + oldValue + "' -> '" + newValue + "'";
    }
}

class UndoManager {
    private Stack<InputAction> undoStack = new Stack<>();
    private int maxUndoSteps;

    public UndoManager(int maxUndoSteps) {
        this.maxUndoSteps = maxUndoSteps;
    }

    public void addAction(InputAction action) {
        if (undoStack.size() >= maxUndoSteps) {
            undoStack.remove(0); // bỏ bước cũ nhất
        }
        undoStack.push(action);
    }

    public InputAction undo() {
        if (!undoStack.isEmpty()) {
            return undoStack.pop();
        }
        return null;
    }

    public void displayActions() {
        System.out.println("Các thao tác nhập liệu:");
        for (InputAction a : undoStack) {
            System.out.println(a);
        }
    }
}

public class Exercise06 {
    public static void main(String[] args) {
        PatientWaitingQueue pq = new PatientWaitingQueue();
        pq.addPatient(new Patient("BN01", "Nguyen Van A", 30, "Nam"));
        pq.addPatient(new Patient("BN02", "Tran Thi B", 25, "Nữ"));
        pq.displayQueue();
        System.out.println("Gọi khám: " + pq.callNextPatient());

        MedicalRecordHistory history = new MedicalRecordHistory("HS001");
        history.addEdit(new EditAction("Cập nhật địa chỉ", "Bác sĩ An", "02/03/2026 09:00"));
        history.addEdit(new EditAction("Thêm kết quả xét nghiệm", "Bác sĩ Bình", "02/03/2026 09:15"));
        history.displayHistory();
        System.out.println("Hoàn tác: " + history.undoEdit());

        TicketSystem ts = new TicketSystem();
        ts.issueTicket("02/03/2026 09:30");
        ts.issueTicket("02/03/2026 09:35");
        ts.displayTickets();
        System.out.println("Gọi số: " + ts.callNextTicket());

        UndoManager um = new UndoManager(5);
        um.addAction(new InputAction("Địa chỉ", "Hà Nội", "TP.HCM", "02/03/2026 09:40"));
        um.addAction(new InputAction("Số điện thoại", "0123456789", "0987654321", "02/03/2026 09:45"));
        um.displayActions();
        System.out.println("Hoàn tác: " + um.undo());
    }
}
