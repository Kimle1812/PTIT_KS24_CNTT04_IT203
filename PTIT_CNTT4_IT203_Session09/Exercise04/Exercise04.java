package PTIT_CNTT4_IT203_Session09.Exercise04;

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

    public void fetchBone() {
        System.out.println("Dog is fetching a bone!");
    }
}



public class Exercise04 {
    public static void main(String[] args) {
        Animal animal = new Dog();

        animal.sound();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.fetchBone();
        }
    }
}
