package JavaAdvanced.Exercisess.SampleExam13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> jedis = new ArrayDeque<>();
        ArrayList<String> messages = new ArrayList<>();
        LinkedHashMap<String,String> jedisWithMessages = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
          stringBuilder.append(line);

        }
        String lines = stringBuilder.toString();
        String strPaternOfNames =reader.readLine();
        String strPatternOfMessages = reader.readLine();
        ArrayList<Integer> indexes = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        String patternOfNamesStr = String.format("%s([A-Za-z]{%d})[^a-zA-z]",strPaternOfNames,strPaternOfNames.length());
        String patternOfMessagesStr = String.format("%s([a-zA-Z0-9]{%d})[^\\w]",strPatternOfMessages,strPatternOfMessages.length());
        Pattern patternOfNames = Pattern.compile(patternOfNamesStr);
        Pattern patternOfMessages = Pattern.compile(patternOfMessagesStr);
        Matcher matcherJedis = patternOfNames.matcher(lines);
        while (matcherJedis.find()){
            String name = matcherJedis.group(1);
            jedis.addLast(name);


        }
        Matcher matcherOfMessages = patternOfMessages.matcher(lines);
        while (matcherOfMessages.find()){
String message = matcherOfMessages.group(1);
messages.add(message);
        }
        int index = 0;
        boolean startFromBegining = false;
        while (true){
            if(jedis.size() ==0){
                break;
            }

String currentMessage = "";
            String jedi = jedis.removeFirst();
            int realIndex ;
            if(startFromBegining ){
                realIndex = indexes.get(0) +1;
            }else {
                realIndex = indexes.get(index);
            }
            if(messages.size() <= realIndex-1 ){
                indexes.remove(index);

                while (true){
                    if(indexes.size() <= index){
                        startFromBegining=true;
                        break;
                    }
                    if(messages.size() > indexes.get(index)){
                        currentMessage = messages.get(indexes.get(index)-1);
                        break;
                    }
                    indexes.remove(index);
                }
            }else{
               currentMessage = messages.get(realIndex-1);
index++;
            }
            jedisWithMessages.putIfAbsent(jedi,currentMessage);
        }
        StringBuilder sb = new StringBuilder();
        jedisWithMessages.entrySet().forEach(entry -> {
            if(entry.getValue().length()>0){
                sb.append(String.format("%s - %s",entry.getKey(),entry.getValue())).append(System.lineSeparator());
            }
        });
        System.out.println(sb.toString());
        String test = "";



     }
}
