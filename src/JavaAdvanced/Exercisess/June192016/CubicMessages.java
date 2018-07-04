    package JavaAdvanced.Exercisess.June192016;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.lang.reflect.Array;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class CubicMessages {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int counter = 0;
            Map<String,String> messages = new HashMap<>();
            String toModify ="";
            while (true){
                String line = reader.readLine();
                if("Over!".equals(line)){
                    break;
                }
               if(counter%2==0){
                    toModify = line;
               }else {
                    int num = Integer.parseInt(line);
                    String currentPath = String.format("^([0-9]+)([a-zA-Z]{%d})([^a-zA-Z\\n]*)$",num);
                   Pattern pattern = Pattern.compile(currentPath);
                   Matcher matcher = pattern.matcher(toModify);
                   if(matcher.find()){
                       String combine = matcher.group(1) + matcher.group(3);
                       String  target = matcher.group(2);
                      StringBuilder result = new StringBuilder();
                       for(int i =0;i<combine.length();i++){
                           String character = combine.substring(i,i+1);
                           if(Character.isDigit(combine.charAt(i))){

                               int index = Integer.parseInt(character);
                               if(index>=target.length()){
                                   result.append(" ");
                               }else{
                                   result.append(target.charAt(index));
                               }
                           }
                       }
                       messages.putIfAbsent(target,result.toString());
                   }
               }
    counter++;
            }
            messages.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " == " + entry.getValue());
            });
            String test = "";
        }

    }
