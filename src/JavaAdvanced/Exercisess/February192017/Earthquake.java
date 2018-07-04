package JavaAdvanced.Exercisess.February192017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<ArrayDeque<Integer>> earthquakes = new ArrayDeque<>();
Deque<Integer> seismicities  = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
for(int i =0; i< n; i++){
    ArrayDeque<Integer> earthquake = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    earthquakes.addLast(earthquake);
}
while (true){
    if(earthquakes.isEmpty()){
        break;
    }

    ArrayDeque<Integer> currentDeque  = earthquakes.removeFirst();
int seismic = currentDeque.removeFirst();
seismicities.addLast(seismic);
currentDeque = makeCalcs(currentDeque,seismic);
if(!currentDeque.isEmpty()){
    earthquakes.addLast(currentDeque);


}
}
StringBuilder sb = new StringBuilder();
System.out.println(seismicities.size());
while (!seismicities.isEmpty()){
    sb.append(seismicities.removeFirst()).append(" ");
}
System.out.println(sb.toString());
String test = "";
    }
    public static ArrayDeque<Integer> makeCalcs(ArrayDeque<Integer>  arrayDeque,int seicmic){
        while (true){
            if(arrayDeque.size()==0){
                return arrayDeque;
            }
            int integer = arrayDeque.getFirst();
            if(seicmic < arrayDeque.getFirst()){
                return arrayDeque;
            }
            arrayDeque.removeFirst();

        }
    }
}