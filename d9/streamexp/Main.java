package d9.streamexp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;

        for(char c : "BINGO".toCharArray()){
            for (int i = 0; i  < (start + 15) ; i ++) {
                bingoPool.add("" + c + i);
              //  System.out.println("" + c + i);
            }
            start += 15;
        }

        System.out.println("-----");

        List<String> firstOnes = bingoPool;
        firstOnes.sort(Comparator.naturalOrder());
//        for(String s : firstOnes){
//            System.out.println(s);
//        }
        firstOnes.replaceAll(s -> {
            if(s.startsWith("G")  || s.startsWith("O")){
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.println(updated + " ");
                return updated;
            }
            return s;
        });

        System.out.println("-----");



    }
}
