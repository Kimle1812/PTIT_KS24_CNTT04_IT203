package PTIT_CNTT4_IT203_Session09.Exercise05;

import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();
    public abstract void displayInfo();
}

class OfficeEmployee extends Employee {
    double baseSalary;

    public OfficeEmployee(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " (Office) - Lương: " + String.format("%,.0f", calculateSalary()));
    }
}

class ProductionEmployee extends Employee {
    int numOfProducts;
    double price;

    public ProductionEmployee(String name, int numOfProducts, double price) {
        super(name);
        this.numOfProducts = numOfProducts;
        this.price = price;
    }

    @Override
    public double calculateSalary() {
        return numOfProducts * price;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " (Production) - Lương: "
            + String.format("%,.0f", calculateSalary())
            + " (" + numOfProducts + " sản phẩm * " + String.format("%,.0f", price) + ")");
    }
}



public class Exercise05 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new OfficeEmployee("Nguyen Van A", 10_000_000));
        employees.add(new ProductionEmployee("Tran Thi B", 300, 20_000));
        employees.add(new ProductionEmployee("Le Van C", 150, 30_000));

        System.out.println("Danh sách lương nhân viên:");
        double totalSalary = 0;
        int i = 1;
        for (Employee e : employees) {
            System.out.print(i + ". ");
            e.displayInfo();
            totalSalary += e.calculateSalary();
            i++;
        }
        System.out.println("\n=> TỔNG LƯƠNG CÔNG TY: " + String.format("%,.0f", totalSalary));
    }
}
