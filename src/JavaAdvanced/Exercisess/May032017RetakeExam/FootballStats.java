package JavaAdvanced.Exercisess.May032017RetakeExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([A-Za-z0-9]+)\\s*-\\s*([A-Za-z0-9]+)\\s*result\\s*(\\d+):(\\d+)");
        Map<String,Team> teams = new TreeMap<>();
while (true){
    String line = reader.readLine();
    if("Season End".equals(line)){
        break;
    }
    Matcher matcher = pattern.matcher(line);
    if(matcher.find()){
        String firstTeam = matcher.group(1);
        String secondTeam = matcher.group(2);
        int firstTeamGoals = Integer.parseInt(matcher.group(3));
        int secondTeamGoals = Integer.parseInt(matcher.group(4));
teams.putIfAbsent(firstTeam,new Team(firstTeam));
teams.putIfAbsent(secondTeam,new Team(secondTeam));
teams.get(firstTeam).addOpponent(secondTeam,String.format("%d:%d",firstTeamGoals,secondTeamGoals));
teams.get(secondTeam).addOpponent(firstTeam,String.format("%d:%d",secondTeamGoals,firstTeamGoals));

    }

}
StringBuilder output = new StringBuilder();
String[] teamsToPrint = reader.readLine().split(", ");
for(String current : teamsToPrint){
    if(teams.containsKey(current)){
        output.append(teams.get(current));
    }
}
System.out.print(output.toString());
    }

}
class Team {
    private String team;
    private Map<String,List<String>> opponents;
    public Team(String team){
        this.team=team;
        this.opponents=new TreeMap<>();
    }
    public void  addOpponent(String opponentName,String data){
this.opponents.putIfAbsent(opponentName,new ArrayList<>());
this.opponents.get(opponentName).add(data);
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.opponents.forEach((name,list) -> {

            list.forEach(ee -> sb.append(String.format("%s - %s -> %s%n",this.getTeam(),name,ee)));
        });
        return sb.toString();
    }
}
