package JavaAdvanced.Exercisess.May082016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        ArrayList<String> royalist = new ArrayList<>();
        ArrayList<String>  notRoyal = new ArrayList<>();
        LinkedHashMap<String,Integer> scores = new LinkedHashMap<>();
        for (String element : str){

            char[] letters = element.toCharArray();
int sum =0;
            for(int i = 0 ;i<letters.length;i++){
sum += (int)letters[i];
if(sum>26){
    sum = sum%26;
}
            }
            if(sum==18){
                royalist.add(element);
            }
            else {
                notRoyal.add(element);
            }


        }
        if(royalist.size()>=notRoyal.size()){
            System.out.printf("Royalists - %d\n",royalist.size());
            royalist.forEach(r -> System.out.println(r));
            System.out.println("All hail Royal!");
        }else{
            notRoyal.forEach(not -> System.out.println(not));
            System.out.println("Royalism, Declined!");
        }
        String test = "";
    }

}