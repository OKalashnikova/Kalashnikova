package task2;

public class Task3 {
    private int row = 5;
    private int col = 9;
    private int[][] massive = new int[row][col];

    public void createMassive(){
        for (int i = 0; i <= row-1; i++) {
            for (int j = 0; j <= col - 1; j++) {
                massive[i][j] = (int) (Math.random() * 50);
                System.out.print(massive[i][j] + " ");
            }
            System.out.println();
        }
    }
}
