package JavaAdvanced.Exercisess.May032017RetakeExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> cards = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toCollection(ArrayList::new));

        String lastCard = "";
        int sum = 0;
        ArrayList<Integer> setCard = new ArrayList<>();
for(String card : cards){
if( !lastCard.isEmpty() &&!lastCard.equals(card.substring(card.length()-1,card.length()))){
    int local = 0;
    for(int current : setCard){
        local += current;
    }

    sum += local*setCard.size();
    setCard.clear();

}
    setCard.add(getValue(card.substring(0,card.length()-1)));
lastCard=card.substring(card.length()-1,card.length());
}
if(!setCard.isEmpty()){
    int local = 0;
    for(int card : setCard){
        local += card;
    }
    sum += local*setCard.size();
}
System.out.println(sum);

    }
    public static int getValue(String str){
        switch (str){
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 12;
            case "Q":
                return 13;
            case "K":
                return 14;
            case "A":
                return 15;
        }
        return 0;
    }
}
