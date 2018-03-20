package task3;

public class Cat extends Animal {

    public Cat(String name, double age) {
        super(name, age);
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
}
