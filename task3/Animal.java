package task3;

public class Animal {
    String name;
    double age;
    static int quantity;


    public Animal(String name, double age) {
        this.name = name;
        this.age = age;
        ++quantity;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public void voice(){
        System.out.println("зверушка подает голос");
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        voice();
        return age + " " + name;
    }
}
