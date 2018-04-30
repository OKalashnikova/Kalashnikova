package task9;

public class Cat extends Animal {

    public Cat(String name, double age) {
        super(name, age);
    }

    public Cat(String name, double age, long id) {
        super(name, age, id);
    }

    public void voice() {
        System.out.println("Мяу ");
    }

    @Override
    public void dyingVoice() {
        System.out.println("Nooooooooooo! Meeeeeeeew!");
    }

    @Override
    protected void finalize() throws Throwable {
        dyingVoice();
        super.finalize();
    }

}
