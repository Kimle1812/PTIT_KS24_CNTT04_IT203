package PTIT_CNTT4_IT203_Session09.Exercise02;

class Animal {
    public void sound() {
        System.out.println("Some sound...");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Gâu gâu");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meo meo");
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}
