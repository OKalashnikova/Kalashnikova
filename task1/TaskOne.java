package task1;

public class TaskOne {
    int number1 = (int) (Math.random() * 100);
    int number2 = (int) (Math.random() * 100);
    int number3 = (int) (Math.random() * 100);

    public void summa() {
        System.out.println("Сумма чисел " + number1 + " " + number2 + " " + number3 + "\n" + "равна " + (number1 + number2 + number3));
    }
}
