package JavaAdvanced.Exercisess.August222016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();
        while (true){
            String line = reader.readLine();
            if("---NMS SEND---".equals(line)){
                break;
            }
            sb.append(line);
        }
        String delimiter = reader.readLine();
String[] letters = sb.toString().split("");
String word = letters[0];
for(int i =1;i<letters.length;i++){
    if( letters[i-1].compareToIgnoreCase(letters[i]) <= 0  ){
        word += letters[i];
    }else{
words.add(word);
word="";
word+=letters[i];
    }
}
if(!word.isEmpty()){
    words.add(word);
}

String test = "";
System.out.println(String.join(delimiter,words));
    }
}
