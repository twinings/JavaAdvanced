package JavaAdvanced.Exercisess.March132016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkupLanguage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("<\\s*([a-z]+)\\s*([^\\/]+)\\s*\\/\\s*>$");
        Pattern contentPattern = Pattern.compile("[a-z]+\\s*=\\s*\"([a-zA-Z ]+)\"");
        Pattern contentPattern2 = Pattern.compile("[a-z]+\\s*=\\s*\"\\s*([^\"]+)\\s*\"");
        Pattern pastPattern = Pattern.compile("[a-z]+\\s*=\\s*\"([0-9])+\"\\s*[a-z]+\\s*=\\s*\"([^\"]+)\"");
        int counter = 1;
        while (true){
            String line = reader.readLine();
            if("<stop/>".equals(line)){
                break;
            }
            Matcher matcher = pattern.matcher(line);
            String result ="";
            if(matcher.find()){
                switch (matcher.group(1)){
                    case "inverse":
                        Matcher content = contentPattern.matcher(matcher.group(2));
                        if(content.find()){
result = inverse(content.group(1));
System.out.printf("%d. %s\n",counter,result);
counter++;}
                        break;
                    case "reverse":
                        Matcher content3 = contentPattern2.matcher(matcher.group(2));
                        if(content3.find()){
                            result = reverse(content3.group(1));
                            System.out.printf("%d. %s\n",counter,result);
                            counter++;}
                        break;
                    case "repeat":
                        Matcher last = pastPattern.matcher(matcher.group(2));
                        if(last.find()){
                            int n = Integer.parseInt(last.group(1));
                            if(n>0&&n<10)
                            for(int i=0;i<n;i++){
                                System.out.printf("%d. %s\n",counter,last.group(2));
                                counter++;
                            }
                        }
                        break;
                        default:
                            break;
                }
            }

        }
    }
    public static String inverse(String initialStr){
String formated = "" ;
char[] arr = initialStr.toCharArray();
for(int i = 0 ; i< arr.length;i++){
    if((int)arr[i]>=65 && (int)arr[i] <=90){
        formated+= (char)((int)arr[i]+32);
    }else{
        formated+= (char)((int)arr[i]-32);
    }
}
return formated;
    }
    public static String reverse(String initialStr){
String newString = "";
char[] arr = initialStr.toCharArray();
for (int i = arr.length-1;i>=0;i--){
    newString += arr[i];
}
return newString;
    }

}
