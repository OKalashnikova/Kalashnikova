package Task4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import task3.Animal;

public class Fish extends Animal {
    public static int count;

    public Fish(String name, double age) {
        super(name, age);
    }

    public void voice() {
//        try{
            count++;
//        }catch (Exception e){
//        throw new NotImplementedException();}
    }

    public static int getCount() {
        return count;
    }

    public static int setCount(){
        return count=0;
    }

}
