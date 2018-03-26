package task4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import task3.Animal;

public class Fish extends Animal {

    public Fish(String name, double age) {
        super(name, age);
    }

    public void voice(){
        throw new NotImplementedException();
    }
}