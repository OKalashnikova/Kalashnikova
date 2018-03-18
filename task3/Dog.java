package task3;

public class Dog extends Animal {
    String name;
    double age;
    static int quantity;

    public Dog (String name, double age) {
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

    @Override
    public void voice() {
        System.out.println("Гав ");
    }

    @Override
    public String toString() {
        voice();
        return age + " " + name + " ";
    }

    public static  int getQuantity(){
        return quantity;
    }
}
