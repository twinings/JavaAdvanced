package JavaAdvanced.Exercisess.SampleExam13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class JadiMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(reader.readLine());
        ArrayList<String> allJedi = new ArrayList<>();
ArrayList<String> result = new ArrayList<>();
StringBuilder sb = new StringBuilder();
        Deque<String> masters = new ArrayDeque<>();
        Deque<String> jediKnight = new ArrayDeque<>();
        Deque<String>  padowan = new ArrayDeque<>();
        boolean masterJoda = false;
Deque<String> toshkoAndSlav = new ArrayDeque<>();
for(int i =0; i< n ; i++){
  ArrayList<String> list = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toCollection(ArrayList::new));
  allJedi.addAll(list);
}
for(String jedi : allJedi){
String type = jedi.substring(0,1);
int level = Integer.parseInt(jedi.substring(1,jedi.length()));
switch (jedi.charAt(0)){
    case 'p':
if(!padowan.contains(jedi)){
    padowan.addLast(jedi);
}
        break;
    case 'k':
        if(!jediKnight.contains(jedi)) {
            jediKnight.addLast(jedi);
        }
        break;
    case 'm':
        if(!masters.contains(jedi)){
            masters.addLast(jedi);
        }
        break;
    case 't':
if(!toshkoAndSlav.contains(jedi)){
    toshkoAndSlav.addLast(jedi);
}
        break;
    case 's':
        if(!toshkoAndSlav.contains(jedi)){
            toshkoAndSlav.addLast(jedi);
        }
        break;
    case 'y':
        masterJoda=true;
        break;
        default:
            break;
}
}
if(masterJoda){

    sb.append(String.join(" ",masters)).append(" ").append(String.join(" ",jediKnight)).append(" ").append(String.join(" ",toshkoAndSlav)).append(" ").append(String.join(" ",padowan));
}else{
    sb.append(String.join(" ",toshkoAndSlav)).append(" ").append(String.join(" ",masters)).append(" ").append(String.join(" ",jediKnight)).append(" ").append(String.join(" ",padowan));

}
System.out.println(sb.toString());
    }
}

