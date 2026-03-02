package PTIT_CNTT4_IT203_Session15.Exercise01;

import java.util.Stack;

class EditAction {
    private String description;
    private String time;
    public EditAction(String description, String time) {
        this.description = description;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "[" + time + "] " + description;
    }
}

class MedicalRecordHistory {
    private Stack<EditAction> history = new Stack<>();

    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Đã thêm chỉnh sửa: " + action);
    }

    public EditAction undoEdit() {
        if (!history.isEmpty()) {
            EditAction undone = history.pop();
            System.out.println("Hoàn tác chỉnh sửa: " + undone);
            return undone;
        } else {
            System.out.println("Không có chỉnh sửa nào để hoàn tác.");
            return null;
        }
    }

    public EditAction getLatestEdit() {
        if (!history.isEmpty()) {
            return history.peek();
        } else {
            System.out.println("Không có chỉnh sửa nào.");
            return null;
        }
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Lịch sử chỉnh sửa trống.");
        } else {
            System.out.println("Danh sách chỉnh sửa:");
            for (EditAction action : history) {
                System.out.println(action);
            }
        }
    }
}

public class Exercise01 {
    public static void main(String[] args) {
        MedicalRecordHistory recordHistory = new MedicalRecordHistory();

        // Thêm chỉnh sửa
        recordHistory.addEdit(new EditAction("Cập nhật thông tin bệnh nhân", "02/03/2026 21:00"));
        recordHistory.addEdit(new EditAction("Thêm kết quả xét nghiệm máu", "02/03/2026 21:05"));
        recordHistory.addEdit(new EditAction("Sửa đơn thuốc", "02/03/2026 21:10"));

        // Hiển thị lịch sử
        recordHistory.displayHistory();

        // Xem chỉnh sửa gần nhất
        System.out.println("Chỉnh sửa gần nhất: " + recordHistory.getLatestEdit());

        // Hoàn tác
        recordHistory.undoEdit();

        // Hiển thị lại lịch sử sau khi hoàn tác
        recordHistory.displayHistory();
    }
}
