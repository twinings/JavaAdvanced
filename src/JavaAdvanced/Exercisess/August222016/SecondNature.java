package JavaAdvanced.Exercisess.August222016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> secondNature = new ArrayList<>();
        ArrayDeque<Integer> flowers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> bukets = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        while (!flowers.isEmpty()  && !bukets.isEmpty()){

            int  currentFlower = flowers. getFirst();

            int buket = bukets.removeLast();
            int diffrence = buket- currentFlower;
            if(diffrence<0) {
                while (true) {
                    if (bukets.isEmpty()) {
                        break;
                    }
                    currentFlower -= buket;
                    buket = bukets.removeLast();
                    if (buket - currentFlower >= 0) {
                        diffrence = buket - currentFlower;
                    }
                }
            }
                if(diffrence>0){
                flowers.removeFirst();
                if(bukets.size()>0){
                    int add = diffrence + bukets.removeLast();
                    bukets.addLast(add);


                }else {
                    bukets.addLast(diffrence);
                }
            }
            if(diffrence==0){
                secondNature.add(flowers.removeFirst());
            }

        }
        StringBuilder sb = new StringBuilder();
        while (!bukets.isEmpty()){
            sb.append(bukets.removeLast()).append(" ");
        }
        while (!flowers.isEmpty()){
            sb.append(flowers.poll()).append(" ");
        }
        sb.append(System.lineSeparator());
        if(!secondNature.isEmpty()) {
            secondNature.stream().forEach(e -> sb.append(e).append(" "));
        }else{
            sb.append("None");
        }
      System.out.println(sb.toString());
    }

}
