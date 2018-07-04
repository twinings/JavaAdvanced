package JavaAdvanced.Exercisess.Octomber222017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Vlogger {
    public final int counter =0 ;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Logger> loggers = new HashMap<>();

while (true){
    String line = reader.readLine();
    if("Statistics".equals(line)){
        break;
    }
    String[] splited = line.split(" ");
    if("joined".equals(splited[1])){
loggers.putIfAbsent(splited[0],new Logger(splited[0]));
    }else if("followed".equals(splited[1])){
if(loggers.containsKey(splited[0]) && loggers.containsKey(splited[2]) && !splited[0].equals(splited[2])){
    loggers.get(splited[0]).addFollowing(splited[2]);
    loggers.get(splited[2]).addFollower(splited[0]);
}
    }
}
StringBuilder sb = new StringBuilder();

 List<String> dsad = loggers.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).collect(Collectors.toList());
sb.append(String.format("The V-Logger has a total of %d vloggers in its logs.",dsad.size())).append(System.lineSeparator());
 for(String logger : dsad){
    int index = dsad.indexOf(logger)+1;
    sb.append(String.format("%d. %s : %d followers, %d following",index,logger,loggers.get(logger).getFollowers().size(),loggers.get(logger).getFollowing().size())).append(System.lineSeparator());
    if(index==1){
loggers.get(logger).getFollowers().stream().sorted((a,b)-> a.compareTo(b)).forEach( entry -> sb.append(String.format("*  %s",entry)).append(System.lineSeparator()));
    }
}
System.out.println(sb.toString());
String test = "";
    }
}
class Logger implements Comparable<Logger>{
    private String name;
    private TreeSet<String> followers;
    private HashSet<String> following;
    public Logger(String name){
        this.name = name;
        this.followers=new TreeSet<>();
        this.following = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public TreeSet<String> getFollowers() {
        return followers;
    }

    public HashSet<String> getFollowing() {
        return following;
    }
    public void addFollower(String followeName){
        if(!this.getFollowers().contains(followeName)){
            this.getFollowers().add(followeName);
        }
    }
    public void addFollowing(String followingName){
        if(!this.getFollowing().contains(followingName)){
            this.getFollowing().add(followingName);
        }
    }
    public String getString(){

        return String.format("%s : %d followers, %d following",this.getName(),this.getFollowers().size(),this.getFollowing().size());
    }


    @Override
    public int compareTo(Logger o) {
        int diff = Integer.compare(o.getFollowers().size(),this.getFollowers().size());
        return  diff != 0 ? diff: Integer.compare(this.getFollowing().size(),o.getFollowing().size());

    }
}