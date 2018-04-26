package task8;

public class Count {
    public static long summ() {
        int summ = 0;
        for (int i = 1; i < 10000000; i++) {
            summ += i;
        }
        return Math.abs(summ);
    }
}
