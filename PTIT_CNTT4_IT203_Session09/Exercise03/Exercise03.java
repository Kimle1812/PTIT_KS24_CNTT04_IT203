package PTIT_CNTT4_IT203_Session09.Exercise03;

class Employee {
    String ten;
    double luongCoBan;

    public Employee(String ten, double luongCoBan) {
        this.ten = ten;
        this.luongCoBan = luongCoBan;
    }

    public void hienThiThongTin() {
        System.out.println("Tên: " + ten);
        System.out.println("Lương cơ bản: " + luongCoBan);
    }
}

class Manager extends Employee {
    String phongBan;

    public Manager(String ten, double luongCoBan, String phongBan) {
        super(ten, luongCoBan);
        this.phongBan = phongBan;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Phòng ban: " + phongBan);
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        Manager m = new Manager("Nguyễn Văn B", 1500.0, "Phòng Kinh Doanh");
        m.hienThiThongTin();
    }
}
