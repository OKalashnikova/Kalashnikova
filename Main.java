import task1.*;

import java.io.IOException;

public class Main {
    public static TaskOne task1 = new TaskOne();
    public static TaskTwo task2 = new TaskTwo();
    public static TaskThree task3 = new TaskThree();
    public static TaskFour task4 = new TaskFour();
    public static TaskFive task5 = new TaskFive();

    public static void main(String[] args) throws IOException {
        System.out.println("Задание 1");
        task1.summa();
        System.out.println();

        System.out.println("Задание 2");
        task2.simvol();
        System.out.println();

        System.out.println("Задание 3");
        task3.convertToBig();
        System.out.println();

        System.out.println("Задание 4");
        task4.convertToSmall();
        System.out.println();

        System.out.println("Задание 5");
        task5.print();
        System.out.println();
    }
}
