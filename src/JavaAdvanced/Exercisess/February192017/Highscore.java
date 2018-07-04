package JavaAdvanced.Exercisess.February192017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Highscore {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Player> players = new LinkedHashMap<>();
while (true){
    String line = reader.readLine();
    if("osu!".equals(line)){
        break;
    }
    String[] data = line.split("<->");
    String[] firstPlayer = data[0].split(" ");
    String[] secondPlayer = data[1].split(" ");
long firstScores = Long.parseLong(firstPlayer[0]);
long secondScores = Long.parseLong(secondPlayer[1]);
players.putIfAbsent(firstPlayer[1],new Player(firstPlayer[1]));
players.putIfAbsent(secondPlayer[0],new Player(secondPlayer[0]));
players.get(firstPlayer[1]).addOpponent(secondPlayer[0],firstScores-secondScores);
players.get(secondPlayer[0]).addOpponent(firstPlayer[1],secondScores-firstScores);

}
players.values().stream().sorted().forEach(System.out::print);

    }
}
class Player implements  Comparable<Player>{
    private String name;
    private Long scores;
    private ArrayList<String> players;
    public Player(String name){
        this.name = name;
        this.scores = 0L;
        this.players = new ArrayList<>();
    }


    public void addOpponent(String name,long scores ){
     this.scores += scores;
     players.add(String.format("*   %s <-> %d",name,scores));
    }

    private Long getScores() {
        return scores;
    }

    private String getName() {
        return name;
    }

    public ArrayList<String> getPlayers() {
        return this.players;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - (").append(this.getScores()).append(")").append(System.lineSeparator());
        for(String game : this.getPlayers()){
            sb.append(game).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Player o) {
        return o.getScores().compareTo(this.getScores());
    }
}
