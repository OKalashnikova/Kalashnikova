package task2;

public class Task4 {
    private int i = (int) (Math.random()*10);

    public int getI() {
        return i;
    }

    public int factorial() {
        int f = 1;
        if (i == 0) {
            System.out.println("не может быть вычислен");
           f=0;
        } else {
            for (int j = i; j > 0; j--) {
                f *= j;
            }
        }
        return f;
    }

    public static int factorialRec(int i) {
        if (i == 1) {
            return 1;
        }if(i==0){
            return 0;
        } if(i<0) {
            System.out.println("Число отрицательное");
            return i;
        }else
         {
            return i * factorialRec(i - 1);
        }
    }
}
