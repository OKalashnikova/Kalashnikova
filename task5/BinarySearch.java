package task5;

import java.util.Arrays;

public class BinarySearch {

    public static int[] fillArray(int[] data){
        for(int i=0; i<data.length; i++){
            data[i] = (int) (Math.random() *50);
            for (int j =0; j<i; j++){
                if(data[j]== data[i]){
                    data[i]= 0;
                    --i;
                }
            }
        }
        Arrays.sort(data);
        return data;
    }

    public static int binarySearch(int[] data, int element) {
        int i = -1;
        if (data != null) {
            int low = 0;
            int high = data.length;
            int mid;
            while (low < high) {
                mid = (low + high)/2;
                if (element == data[mid]) {
                    i = mid;
                    break;
                } else if (element < data[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        return i;
    }
}
