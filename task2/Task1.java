package task2;


public class Task1 {

    public int summa(int a, int b, int c) {
        if (a < 0) {
            System.out.println("Число " + a + " отрицательное");
            a = 0;
        }
        if (b < 0) {
            System.out.println("Число " + b + " отрицательное");
            b = 0;
        }
        if (c < 0) {
            System.out.println("Число " + c + " отрицательное");
            c = 0;
        }
        int summa = a + b + c;
        return summa;
    }
}
