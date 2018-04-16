package task6;

import java.util.HashMap;

public class CountLitters {

    private static HashMap<Character, Integer> mapLitters = new HashMap<Character, Integer>(40);

    public static void countLitters(String txt) {
        char[] chars = txt.toCharArray();
        for (int i = 0; i < txt.length(); ++i) {
            char c = chars[i];
                if (mapLitters.containsKey(c)) {
                    mapLitters.put(c, mapLitters.get(c) + 1);
                } else {
                    mapLitters.put(c, 1);
                }
            }
        for (HashMap.Entry<Character,Integer> pair : mapLitters.entrySet()){
            if(pair.getValue() == 1){
                System.out.print(pair.getKey() + ", ");
            }
        }
        }
}
