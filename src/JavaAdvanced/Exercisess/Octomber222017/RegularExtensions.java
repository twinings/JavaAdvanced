package JavaAdvanced.Exercisess.Octomber222017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
StringBuilder text = new StringBuilder(reader.readLine());
while (true){
    String line = reader.readLine();
    if("Print".equals(line)){
        break;
    }
    StringBuilder sb = new StringBuilder(line);
    if(!line.contains("%")){
        String reversed = sb.reverse().toString();
        while (text.toString().contains(line)){
            text.replace(text.toString().indexOf(line),text.toString().indexOf(line)+line.length(),reversed);
        }
        continue;
    }


      line=  line.replace("%","[^\\s]*");
    line = line.replace(".","\\.");

    Pattern pattern = Pattern.compile(line);
    Matcher matcher = pattern.matcher(text.toString());
    while (matcher.find()){
        StringBuilder word =new StringBuilder(matcher.group());
        text.replace(text.indexOf(word.toString()),text.indexOf(word.toString())+word.length(),word.reverse().toString());

    }
    }
    System.out.println(text.toString());
    String test ="";
}

    }

