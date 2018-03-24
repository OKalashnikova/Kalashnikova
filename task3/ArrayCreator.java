package task3;


import java.util.Arrays;

public class ArrayCreator {

    int max;

    public int[] arrayCreat(int length){
        int[] array = new int[length];
        for (int i =0; i< length; i ++){
            array[i]= (int)(Math.random()*10);
            System.out.print(array[i]);
        }
        return array;
    }

    public int[] arrayConvert(int[] array){
        System.out.println();
        int[] arrayConvert = new int[array.length];
        for(int j=0; j<arrayConvert.length; j++) {
            int count=0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == j){
                    count+=1;
                }

            }
            arrayConvert[j] = count;
            System.out.print(arrayConvert[j]);
        }
        return arrayConvert;
    }

    public  int [] preobrazArr(int [] array) { //преобразование масива
        Arrays.sort(array);
        max = array[array.length - 1];
        max=max+1;
        System.out.println('\n' + "длина " + max);
        int[]preArr = new int [max]; // новый массив
        for(int i = 0; i<array.length;i++) {  // цикл входящего в метод массива
            preArr[array[i]]+=1; // увеличиваем значение ячейки под нужным нам индексом на 1
        }
        printArray(preArr);
        return preArr;
    }//metod

    public static void printArray(int [] arr) {

        for(int i = 0; i<arr.length;i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
