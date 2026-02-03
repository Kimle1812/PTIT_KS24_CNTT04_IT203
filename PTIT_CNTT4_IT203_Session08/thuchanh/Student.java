package PTIT_CNTT4_IT203_Session08.thuchanh;

public class Student {
    private String id;
    private String name; 
    private double score; 

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.startsWith("SV") && id.length() == 5) {
            this.id = id;
        } else {
            System.out.println("ID không hợp lệ! Phải có dạng SVxxx");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score >= 8.0) {
            return "Gioi";
        } else if (score >= 6.5) {
            return "Kha";
        } else {
            return "Trung Binh";
        }
    }

    public String toString() {
        return String.format("ID: %s | Tên: %s | Điểm: %.2f | Học lực: %s",
                id, name, score, getRank());
    }
}

