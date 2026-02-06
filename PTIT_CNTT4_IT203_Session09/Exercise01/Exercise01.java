package PTIT_CNTT4_IT203_Session09.Exercise01;

class Person {
    String hoTen;
    int tuoi;

    public Person(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public void hienThiThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
    }
}


class Student extends Person {
    String maSinhVien;
    double diemTrungBinh;

    public Student(String hoTen, int tuoi, String maSinhVien, double diemTrungBinh) {
        super(hoTen, tuoi);
        this.maSinhVien = maSinhVien;
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
    }
}

public class Exercise01 {
    public static void main(String[] args) {
        Student sv = new Student("Nguyễn Văn A", 20, "SV001", 8.5);
        sv.hienThiThongTin();
    }
}


