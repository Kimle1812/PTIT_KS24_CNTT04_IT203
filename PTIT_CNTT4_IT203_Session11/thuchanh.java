package PTIT_CNTT4_IT203_Session11;

interface IMixable {
    void mix();
}

abstract class Drink {
    protected String id;
    protected String name;
    protected double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.println("Mã: " + id + " | Tên: " + name + " | Giá gốc: " + price);
    }
}

class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        return hasMilk ? price + 5000 : price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Loại: " + (hasMilk ? "Có sữa" : "Đen đá"));
    }
}

class FruitJuice extends Drink implements IMixable {
    private int discountPercent;

    public FruitJuice(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price - (price * discountPercent / 100.0);
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi...");
    }
}

public class thuchanh {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("C01", "Bạc sỉu", 30000, true);
        drinks[1] = new FruitJuice("F01", "Nước cam", 40000, 10);
        drinks[2] = null;

        System.out.println("=== HÓA ĐƠN COFFEE SHOP ===");

        for (Drink d : drinks) {
            if (d != null) {
                d.displayInfo();
                System.out.println("Thành tiền: " + d.calculatePrice());

                if (d instanceof IMixable) {
                    ((IMixable) d).mix();
                }

                System.out.println("--------------------------");
            }
        }
    }
}
