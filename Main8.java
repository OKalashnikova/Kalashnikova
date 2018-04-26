import task3.Animal;
import task3.Cat;
import task3.Dog;
import task8.Count;
import task8.TimeFly;

import java.io.*;
import java.util.ArrayList;

public class Main8 {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Написать класс, содержащий методы по сериализации и десериализации животных.
        System.out.println();
        System.out.println("Задание 1");

        FileOutputStream fosAnimal = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fosAnimal);
        Animal cat1 = new Cat("Shrek", 3.0);
        Animal dog1 = new Dog("Simpson", 1.2);
        ArrayList<Animal> listAnimal = new ArrayList<>();
        listAnimal.add(cat1);
        listAnimal.add(dog1);
        oos.writeObject(listAnimal);
       // oos.flush();
        oos.close();

        FileInputStream fisAnimal = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fisAnimal);
        ArrayList<Animal> animal = null;
        try {
            animal = (ArrayList<Animal>) oin.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Animal a : animal)
        System.out.println("Объект "+a.toString());



        //Написать программу, которая 4 раза считает сумму от1 до 10000000 и выводит результат на консоль.
        System.out.println();
        System.out.println("Задание 2");
        Thread t0 = new Thread(() -> countFor());
        System.out.println("Вызываем метод, выполняющий 4-ре раза одно действие и четыре потока ");

        //Написать программу, которая задание 2 выполнит в 4 потоках из пула. Сравнить, быстрее ли параллельное выполнение.
        System.out.println();
        System.out.println("Задание 3");
       Thread t1 = new Thread(() -> System.out.println("Поток 1 " + Count.summ()));
       Thread t2 = new Thread(() -> System.out.println("Поток 2 " + Count.summ()));
       Thread t3 = new Thread(() -> System.out.println("Поток 3 " + Count.summ()));
       Thread t4 = new Thread(() -> System.out.println("Поток 4 " + Count.summ()));
       t0.start();
       t1.start();
       t2.start();
       t3.start();
       t4.start();

        t0.join();
        t1.join();
        t2.join();
        t3.join();
        t4.join();


         //Написать программу, демонстрирующую race conditions(
        // доказать, что при одновременной записи в одну и ту же память из более чем одного потока, возможна потеря данных)
        System.out.println();
        System.out.println("Задание 4");

        System.out.println("Животному " + cat1.getAge() + " лет");
        TimeFly time = new TimeFly();
        time.setYears(cat1);
        System.out.println("Прошло 4-ре года");
        Thread y1 = new Thread(() -> time.oneYear());
        Thread y2 = new Thread(() -> time.oneYear());
        Thread y3 = new Thread(() -> time.oneYear());
        Thread y4= new Thread(() -> time.oneYear());
        y1.start();
        //y1.sleep(1000);
       // y1.join();
        y2.start();
        //y2.sleep(1000);
        //y2.join();
        y3.start();
       //y3.sleep(1000);
        //y3.join();
        y4.start();
        //y2.sleep(1000);

        System.out.println("Животному " + time.getYears());

    }

    public static void countFor(){
       for (int i=1; i<5; i++){
           System.out.println("Метод, цикл " + i + " " + Count.summ());
        }
    }
}
