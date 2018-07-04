package JavaAdvanced.Exercisess.March132016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ChampionsLeague {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Data> league = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if ("stop".equals(line)) {
                break;
            }
            String[] game = line.split("\\s*\\|\\s*");
            String firstOpponent = game[0];
            String secondOpponent = game[1];
            int[] firstMatch = Arrays.stream(game[2].split(":")).mapToInt(Integer::parseInt).toArray();
            int[] secondMatch = Arrays.stream(game[3].split(":")).mapToInt(Integer::parseInt).toArray();
            int firstScore1 = firstMatch[0];
            int secondScore1 = firstMatch[1];
            int firstScore2 = secondMatch[1];
            int secondScore2 = secondMatch[0];
            int difference = (firstScore1 + firstScore2) - (secondScore1 + secondScore2);
            if (!league.containsKey(firstOpponent)) {
                Data firstData = new Data(firstOpponent);
                league.put(firstOpponent, firstData);
            }
            if (!league.containsKey(secondOpponent)) {
                Data secondData = new Data(secondOpponent);
                league.put(secondOpponent, secondData);
            }
            league.get(firstOpponent).addOpponent(secondOpponent);
            league.get(secondOpponent).addOpponent(firstOpponent);
            if (difference > 0) {
                league.get(firstOpponent).setWins();
            } else if (difference < 0) {
                league.get(secondOpponent).setWins();
            } else if (firstScore1 < secondScore1) {
                league.get(secondOpponent).setWins();
            } else if (secondScore1 < firstScore1) {
                league.get(firstOpponent).setWins();

            } else if (firstScore1 == secondScore1) {
                if (firstScore1 < secondScore2) {
                    league.get(firstOpponent).setWins();
                } else {
                    league.get(secondOpponent).setWins();
                }
            }
        }


            String test = "";
            league.entrySet().stream().sorted((a, b) -> {
                int firstWins = a.getValue().getWins();
                int secondWins = b.getValue().getWins();
                int diff = secondWins - firstWins;
                if (diff != 0) {
                    return diff;
                }
                int secondCriteria = a.getKey().compareTo(b.getKey());
                return secondCriteria;
            }).forEach(entry -> {
                sb.append(entry.getKey()).append(System.lineSeparator()).append(String.format("- Wins: %d\n", entry.getValue().getWins()));
                sb.append("- Opponents: ");
                entry.getValue().getOpponents().stream().sorted((a1, a2) -> {
                    return a1.compareTo(a2);

                }).forEach(yy -> sb.append(String.format("%s, ", yy)));
                sb.delete(sb.length() - 2, sb.length()).append(System.lineSeparator());
            });
            System.out.println(sb.toString());
        }
    }

class Data{
    private String name;
    private int wins;
    private ArrayList<String> opponents;
    public Data(String name){
        this.name = name;
        this.wins = 0;
        this.opponents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getOpponents() {
        return opponents;
    }

    public void setWins() {
        this.wins++;
    }

 public void addOpponent(String opponentName){
        this.opponents.add(opponentName);
 }

    public int getWins() {
        return wins;
    }
}
