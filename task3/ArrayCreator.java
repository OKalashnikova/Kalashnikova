package task3;

import java.lang.reflect.Array;

public class ArrayCreator {

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
}
