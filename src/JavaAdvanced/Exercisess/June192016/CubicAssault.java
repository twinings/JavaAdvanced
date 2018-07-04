package JavaAdvanced.Exercisess.June192016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Region> regionMap = new LinkedHashMap<>();
        while (true) {
            String line = reader.readLine();
            if ("Count em all".equals(line)) {
                break;
            }
            String[] tokens = line.split(" -> ");
            String currentRegion = tokens[0];
            String currentMeteor = tokens[1];
            long currentAmount = Long.parseLong(tokens[2]);
            regionMap.putIfAbsent(currentRegion,new Region(currentRegion));
            regionMap.get(currentRegion).add(currentMeteor,currentAmount);
        }
regionMap.values().stream().sorted().forEach(System.out::print);

    }
}
class Region implements Comparable<Region> {

    private static final long MILLION = 1_000_000L;
    private static final String GREEN = "Green";
    private static final String RED = "Red";
    private static final String BLACK = "Black";
    private String name;
    private Map<String,Meteor>  meteors;
    {
        this.meteors=new LinkedHashMap<String, Meteor>(){{
            put(GREEN,new Meteor(GREEN));
            put(RED,new Meteor(RED));
            put(BLACK,new Meteor(BLACK));
        }

        };

    }
    public Region(String name){
        this.name=name;
    }

    void add(String meteor,long amount){
        this.meteors.get(meteor).add(amount);
        long greenMeteors = this.meteors.get(GREEN).getAmount();
        long redMeteors = this.meteors.get(RED).getAmount();
        if(this.meteors.get(GREEN).getAmount() >= MILLION){
            this.meteors.get(RED).setAmount(redMeteors + greenMeteors/MILLION);
            this.meteors.get(GREEN).setAmount(greenMeteors % MILLION);
        }
        redMeteors = this.meteors.get(RED).getAmount();
        long blackMeteors = this.meteors.get(BLACK).getAmount();
        if(this.meteors.get(RED).getAmount()>=MILLION){
            this.meteors.get(BLACK).setAmount( blackMeteors+ redMeteors/MILLION);
            this.meteors.get(RED).setAmount(redMeteors % MILLION);
        }

    }
    private String getName(){
        return this.name;
    }
    private long getBlackMeteors(){
        return this.meteors.get(BLACK).getAmount();
    }

    @Override
    public int compareTo(Region o) {
        int compare = Long.compare(o.getBlackMeteors(),this.getBlackMeteors());
        compare = compare != 0 ? compare : Integer.compare(o.getName().length(),this.getName().length());
        return compare !=0 ? compare : this.getName().compareTo(o.getName());

    }
    private String getToString(){
        StringBuilder sb = new StringBuilder();
        this.meteors.values().stream().sorted().forEach(e ->
            sb.append(e).append(System.lineSeparator())
        );
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s%n%s",this.getName(),this.getToString());
    }
}
class Meteor implements Comparable<Meteor>{
    private String type;
    private  long amount;
    public Meteor(String type){
        this.type = type;
        this.amount=0L;
    }

    private String getType() {
        return type;
    }
    void setAmount(long amount){
        this.amount = amount;
    }
    void add(long amount){
        this.amount += amount;
    }
    long getAmount(){
        return  this.amount;
    }

    @Override
    public int compareTo(Meteor o) {
        int diff = Long.compare(o.getAmount(),this.getAmount());
        return diff != 0 ? diff : this.getType().compareTo(o.getType());
    }

    @Override
    public String toString() {
        return String.format("-> %s : %d",this.getType(),this.getAmount());

    }
}
