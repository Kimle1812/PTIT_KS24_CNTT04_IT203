package PTIT_CNTT4_IT203_Session16;

import java.util.*;

interface IRepository<T> {
    boolean add(T item);
    boolean removeById(String id);
    T findById(String id);
    List<T> findAll();
}

abstract class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateFinalPrice();

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }

    public String getId() { return id; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}

class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        if (warrantyMonths > 12) {
            return price + 1_000_000;
        }
        return price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}

class FoodProduct extends Product {
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateFinalPrice() {
        return price - (price * discountPercent / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Discount: " + discountPercent + "%");
    }
}

class ProductRepository implements IRepository<Product> {
    private List<Product> products = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || productMap.containsKey(item.getId())) return false;
        products.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        Product p = productMap.remove(id);
        if (p != null) {
            products.remove(p);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
}

public class thuchanh {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        // Thêm sản phẩm
        repo.add(new ElectronicProduct("E01", "Laptop", 15_000_000, 24));
        repo.add(new ElectronicProduct("E02", "Smartphone", 10_000_000, 12));
        repo.add(new FoodProduct("F01", "Bánh quy", 50_000, 10));
        repo.add(new FoodProduct("F02", "Sữa tươi", 30_000, 5));

        // 1. Hiển thị toàn bộ danh sách
        System.out.println("=== Danh sách sản phẩm ===");
        for (Product p : repo.findAll()) {
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice());
            System.out.println("-------------------------");
        }

        // 2. Tìm sản phẩm theo id
        System.out.println("=== Tìm sản phẩm theo ID ===");
        Product found = repo.findById("E01");
        if (found != null) {
            found.displayInfo();
            System.out.println("Thành tiền: " + found.calculateFinalPrice());
        }

        // 3. Sắp xếp theo giá tăng dần
        System.out.println("=== Sắp xếp theo giá tăng dần ===");
        List<Product> sorted = repo.findAll();
        sorted.sort(Comparator.comparingDouble(Product::getPrice));
        for (Product p : sorted) {
            System.out.println(p.getId() + " - " + p.getName() + " - Giá gốc: " + p.getPrice());
        }

        // 4. Thống kê số lượng sản phẩm theo loại
        System.out.println("=== Thống kê số lượng theo loại ===");
        Map<String, Integer> stats = new HashMap<>();
        for (Product p : repo.findAll()) {
            String type = (p instanceof ElectronicProduct) ? "Electronic" : "Food";
            stats.put(type, stats.getOrDefault(type, 0) + 1);
        }
        System.out.println(stats);
    }
}
