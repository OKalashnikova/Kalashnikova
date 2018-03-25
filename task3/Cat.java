package task3;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Cat extends Animal {

    public Cat(String name, double age) {
        super(name, age);
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
