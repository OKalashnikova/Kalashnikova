package task2;

public class Task3 {
    private int row = 5;
    private int col = 9;
    private int[][] massive = new int[row][col];

    public int[][] getMassive(){
        return massive;
    }

    public int[][] createMassive(int[][] massive) {
        for (int i = 0; i <= (massive.length - 1); i++) {
            for (int j = 0; j <= col - 1; j++) {
                massive[i][j] = (int) (Math.random() * 50);
            }
        }
        System.out.println();
        return massive;
    }

    public void showMassive(int[][] mas) {
        for (int i = 0; i <= (mas.length - 1); i++) {
            for (int j = 0; j <= (mas[0].length - 1); j++) {
                System.out.print(massive[i][j] + " ");
            }
            System.out.println();
        }
    }

}
