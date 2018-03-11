import task2.*;

import java.util.Scanner;

public class Main2 {
    public static Task1 task1 = new Task1();
    public static Task2 task2 = new Task2();
    public static Task3 task3 = new Task3();
    public static Task4 task4 = new Task4();

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = in.nextInt();
        System.out.println("Введите второе число: ");
        int b = in.nextInt();
        System.out.println("Введите третье число: ");
        int c = in.nextInt();
        System.out.println("Сумма положительных чисел " + task1.summa(a, b, c));

        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Массив заполнен такими числами: ");
        System.out.println("Сумма четных чисел равна " + task2.summaChisel(task2.createMassive(task2.getMass())));

        System.out.println();
        System.out.println("Задание 3");
        System.out.println("двумерный массив:");
        task3.showMassive(task3.createMassive(task3.getMassive()));


        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Итеративная версия");
        System.out.println("факториал числа " + task4.getI());
        System.out.println("равен " + task4.factorial());
        System.out.println();
        System.out.println("Рекурсивная версия");
        System.out.println("факториал числа " + task4.getI());
        System.out.println("равен " + task4.factorialRec(task4.getI()));
    }
}
