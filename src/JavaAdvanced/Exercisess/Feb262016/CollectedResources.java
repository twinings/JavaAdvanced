package JavaAdvanced.Exercisess.Feb262016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectedResources {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> collectedResources = new ArrayList<>();
        String[] resources = reader.readLine().split(" ");
        int counter = Integer.parseInt(reader.readLine());
        for(int i =0 ; i< counter ; i++){
            List<String> currentCollection = new ArrayList<>();
int[] path= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
int startIndex = path[0];
int step = path[1];
String element;
if(startIndex <0  || step<0 || startIndex>=resources.length){
    continue;
}
while (true){

element = resources[startIndex % resources.length];


    if(check(element)){
        if(currentCollection.contains(element)){
            break;
        }
        currentCollection.add(element);
    }
    startIndex += step;
}
collectedResources.add(currentCollection);
        }
        int biggest =0;
        for(int i = 0 ; i< collectedResources.size() ; i++){
             List<String> words = collectedResources.get(i);
             int count = 0;
             for(int j =0; j< words.size(); j++){
                 int currentNum = convert(words.get(j));
                 count += currentNum;
             }
             if(count>biggest){
                 biggest = count;
             }
        }

       System.out.println(biggest);
    }
    public static boolean check(String word){
        boolean toCheck = false;
        String word1 = word  ;
        if(word.contains("_")){
            int index = word.indexOf("_");

            word1 = word.substring(0,index);
String test = "";
        }
        if("stone".equals(word1) || "gold".equals(word1) || "wood".equals(word1) || "food".equals(word1)){
            toCheck=true;
        }
        return  toCheck;
    }
    public static int convert(String word){
int num = 1;
        if(word.contains("_")){
            int index = word.indexOf("_");

          num   = Integer.parseInt(word.substring(index+1,word.length()));

        }
        return num;
    }

}
