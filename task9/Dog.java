package task9;

public class Dog extends Animal {

    public Dog(String name, double age) {
        super(name, age);
    }

    public Dog(String name, double age, long id) {
        super(name, age, id);
    }

    public void voice() {
        System.out.println("Гав ");
    }

    @Override
    public void dyingVoice() {
        System.out.println("Gav! Gav! Aaaaaaaaaaauuuuuuuuuuu!");
    }

    @Override
    protected void finalize() throws Throwable {
        dyingVoice();
        super.finalize();
    }

}
