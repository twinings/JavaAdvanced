package JavaAdvanced.Exercisess.February192017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("[,_]([a-zA-Z]+)([0-9])");
        StringBuilder sb=  new StringBuilder();
while (true) {
    String line = reader.readLine();
    if ("Ascend".equals(line)) {
        break;
    }
    Matcher match = pattern.matcher(line);
    while (match.find()) {
        String newLine = "";
        String matched = match.group();
        String number = match.group(2);
        int index = line.indexOf(matched);
        newLine += line.substring(0, index);
        String word = match.group(1);
        int num = Integer.parseInt(number);
        String newWord = modify(word, num, matched.charAt(0));
        newLine += newWord;
        newLine += line.substring(line.indexOf(number) + 1, line.length());
        line = newLine;
        match = pattern.matcher(line);
    }
    if (!line.isEmpty()) {
        sb.append(line).append(System.lineSeparator());
    }
}

System.out.println(sb);
String test = "";
    }
    public static String modify(String oldWord , int num,char ii){
        String newWord = "";
        char[] oldChars = oldWord.toCharArray();
        if(ii == ',') {
            for (int i = 0; i < oldChars.length; i++) {
                newWord += (char) ((int) oldChars[i] + num);
            }
        }else if(ii == '_'){
            for (int i = 0; i < oldChars.length; i++) {
                newWord += (char) ((int) oldChars[i] - num);
            }
        }
        return newWord;
    }
}
