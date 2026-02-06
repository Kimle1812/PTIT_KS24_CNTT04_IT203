package PTIT_CNTT4_IT203_Session09.Exercise06;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double calculateArea();
    public abstract void displayInfo();
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("Hình tròn (r=" + radius + ") - Diện tích: " 
            + String.format("%.2f", calculateArea()));
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void displayInfo() {
        if (width == height) {
            System.out.println("Hình vuông (cạnh " + width + ") - Diện tích: " 
                + String.format("%.1f", calculateArea()));
        } else {
            System.out.println("Hình chữ nhật (" + width + " x " + height + ") - Diện tích: " 
                + String.format("%.1f", calculateArea()));
        }
    }
}


public class Exercise06 {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Rectangle(6));

        System.out.println("Kết quả tính toán hình học:");
        double totalArea = 0;
        int i = 1;
        for (Shape s : shapes) {
            System.out.print(i + ". ");
            s.displayInfo();
            totalArea += s.calculateArea();
            i++;
        }
        System.out.println("\n=> Tổng diện tích các hình: " + String.format("%.2f", totalArea));
    }
}

