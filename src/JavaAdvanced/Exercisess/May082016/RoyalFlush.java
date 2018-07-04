package JavaAdvanced.Exercisess.May082016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,ArrayList<String>> hands = new TreeMap<>();
        int combinationCouter =0;
        String stringPattern = "(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)";
        List<String> ranks = Arrays.asList(new String[] { "10", "J", "Q", "K", "A" });
        List<String> suits = Arrays.asList(new String[] { "c", "d", "h", "s" });
        String[] outputSuits = new String[] { "Clubs", "Diamonds", "Hearts", "Spades" };
         int lines = Integer.parseInt(reader.readLine());
        String str = "";
        for (int i =0 ;i<lines;i++){
            String newLine = reader.readLine();
            str+= newLine;
        }
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matchCombinations = pattern.matcher(str);
        while (matchCombinations.find()){
String rank = matchCombinations.group(1);
String suit = matchCombinations.group(2);
if(!hands.containsKey(suit)){
    hands.put(suit,new ArrayList<>());
}
if(hands.get(suit).size() == 0){
if(ranks.indexOf(rank) ==0){
    hands.get(suit).add(rank);
}

}else{
    if(ranks.indexOf(rank)==hands.get(suit).size()){
        hands.get(suit).add(rank);
    }else{
        hands.get(suit).clear();
        if(ranks.indexOf(rank)==0){
            hands.get(suit).add(rank);
        }
    }
}
if(hands.get(suit).size()==5){
    System.out.println(String.format("Royal Flush Found - %s", outputSuits[suits.indexOf(suit)]));
    hands.get(suit).clear();
    combinationCouter++;
}
        }
        System.out.println(String.format("Royal's Royal Flushes - %s.", combinationCouter));


    }
}
