package task2;

public class Task2 {
    private int[] massive = new int[10];

    public void summa() {
        System.out.println("Сумма чисел без остатка " + summaChisel(massive));
    }


    public int summaChisel(int[] massive) {
        int summa = 0;
        for (int i = 0; i <= (massive.length - 1); i++) {
            massive[i] = (int) (Math.random() * 50);
            System.out.print(massive[i] + " ");
        }
        System.out.println();

        for (int i = 0; (massive.length - 1) >= i; i++) {

            int j = massive[i];
            if (j % 2 == 0) {
                summa += j;
            } else {
                System.out.println(j + " делится с остатком");
            }
        }
        return summa;
    }
}
