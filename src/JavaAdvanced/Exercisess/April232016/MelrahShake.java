package JavaAdvanced.Exercisess.April232016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder append = strBuilder.append(str);
        String target = reader.readLine();
        StringBuilder targetBuilder = new StringBuilder();
        targetBuilder.append(target);
        while (true){
            if(targetBuilder.toString().isEmpty()){
                System.out.println("No shake.");
                break;
            }
            if(!strBuilder.toString().contains(targetBuilder)){
                System.out.println("No shake.");
                break;
            }
            int ind1 = strBuilder.indexOf(targetBuilder.toString());
            int idx2 = strBuilder.lastIndexOf(targetBuilder.toString());
            if(idx2<ind1+targetBuilder.toString().length()){
                System.out.println("No shake.");
                break;
            }

                strBuilder.delete(idx2,idx2+targetBuilder.toString().length());
                strBuilder.delete(ind1,+ind1+targetBuilder.toString().length());
                targetBuilder.delete(targetBuilder.toString().length()/2,targetBuilder.toString().length()/2+1);
            System.out.println("Shaked it.");
            }
            System.out.println(strBuilder.toString());

String test ="";

        }
    }

