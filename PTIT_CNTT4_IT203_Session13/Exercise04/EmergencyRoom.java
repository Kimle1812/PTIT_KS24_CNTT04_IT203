package PTIT_CNTT4_IT203_Session13.Exercise04;

import java.util.LinkedList;

public class EmergencyRoom {
    private LinkedList<String> patients;

    public EmergencyRoom() {
        patients = new LinkedList<>();
    }

    public void patientCheckIn(String name) {
        patients.addLast(name);
        System.out.println(name + " đã được thêm vào cuối hàng đợi.");
    }

    public void emergencyCheckIn(String name) {
        patients.addFirst(name);
        System.out.println(name + " (ca cấp cứu) đã được thêm vào đầu hàng đợi.");
    }

    public void treatPatient() {
        if (!patients.isEmpty()) {
            String treated = patients.removeFirst();
            System.out.println("Bác sĩ đang chữa trị cho: " + treated);
        } else {
            System.out.println("Không còn bệnh nhân trong danh sách.");
        }
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        er.patientCheckIn("Bệnh nhân A");
        er.patientCheckIn("Bệnh nhân B");
        er.emergencyCheckIn("Bệnh nhân C (nguy kịch)");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}
