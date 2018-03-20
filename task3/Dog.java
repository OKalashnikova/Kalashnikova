package task3;

public class Dog extends Animal {

    public Dog(String name, double age) {
        super(name, age);
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
}
