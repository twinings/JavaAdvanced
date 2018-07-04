package JavaAdvanced.Exercisess.August222016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String ,Region> regionMap = new HashMap<>();
        Pattern check = Pattern.compile("^Grow\\s\\<([A-Z][a-z]+)\\>\\s\\<([A-Za-z0-9]+)\\>\\s(\\d+)$");
        while (true){
            String line = reader.readLine();
            if("Icarus, Ignite!".equals(line)){
                break;
            }
            Matcher checker = check.matcher(line);
            if(checker.find()){
                String reagionName = checker.group(1);
                String roseColor = checker.group(2);
                int rosesAmount = Integer.parseInt(checker.group(3));
                regionMap.putIfAbsent(reagionName,new Region(reagionName));
                regionMap.get(reagionName).add(roseColor,rosesAmount);
            }
        }
        regionMap.values().stream().sorted().forEach(System.out::print);



    }
}

class Rose implements Comparable<Rose> {
    private String color;
    private long amount;
    public Rose(String color){
        this.color = color;
        this.amount = 0;
    }
    private void setAmount(int amount){
        this.amount= amount;
    }
    void addAmount(int amount){
        this.amount += amount;
    }
    private String getColor(){
        return this.color;
    }
    public long getAmount(){
        return  this.amount;
    }

    @Override
    public int compareTo(Rose o) {
        int diff = Long.compare(this.getAmount(),o.getAmount());
        return diff != 0 ? diff : this.getColor().compareTo(o.getColor());
    }

    @Override
    public String toString() {
        return String.format("*--%s | %d", this.getColor(),this.getAmount());
    }
}
class Region  implements Comparable<Region>{
    private String name;
    private Map<String,Rose> roses;
    public Region(String name){
        this.name=name;
        this.roses = new HashMap<>();
    }
    private String getName(){
        return  this.name;
    }
    private long getSum(){
        return this.roses.values().stream().map(Rose::getAmount).reduce(0L,Long::sum);
    }
     void add(String color,int amount){
        this.roses.putIfAbsent(color,new Rose(color));
        this.roses.get(color).addAmount(amount);

    }
    private String getToString(){
        StringBuilder sb = new StringBuilder();
        this.roses.values().stream().sorted().forEach(rose -> sb.append(rose).append(System.lineSeparator()));
        return sb.toString();
    }

    @Override
    public int compareTo(Region o) {
        int  diff = Long.compare(o.getSum(),this.getSum());
        return diff != 0 ? diff:  this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s",this.getName(),this.getToString());
    }
}
