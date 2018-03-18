package task3;

public class Cat extends Animal {
//    String name;
//    double age;
    static int quantity;

    public Cat(String name, double age) {
        super.name = name;
        super.age = age;
        ++quantity;
    }

    public String getName() {
        return name;
    }


    public double getAge() {
        return age;
    }

    @Override
    public void voice() {
        System.out.println("Мяу ");
    }

    @Override
    public String toString() {
        voice();
        return age + " " + name;
    }

    public static int getQuantity() {
        return quantity;
    }
}
