package JavaAdvanced.Exercisess.Feb262016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Events {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, TreeMap<String, HashSet<Time>>> events = new TreeMap<>();
        Pattern pattern = Pattern.compile("^#([a-zA-Z]+):\\s*@([a-zA-Z]+)\\s*([0-9]+):([0-9]+)$");
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String name = matcher.group(1);
                String loc = matcher.group(2);
                int hours = Integer.parseInt(matcher.group(3));
                int minutes = Integer.parseInt(matcher.group(4));
                if ((hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59)) {
                    Time time1 = new Time(hours, minutes);
                    HashSet<Time> times = new HashSet<>();
                    TreeMap<String, HashSet<Time>> people = new TreeMap<>();
                    if (events.containsKey(loc)) {
                        people = events.get(loc);
                        if (people.containsKey(name)) {
                            times = people.get(name);
                        }
                    }
                    times.add(time1);
                    people.put(name, times);
                    events.put(loc, people);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> last = Arrays.stream(reader.readLine().split(",")).sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        for (String city : last) {

            if (events.containsKey(city)) {
                sb.append(String.format("%s:\n", city));
                int counter = 1;
                for (Map.Entry<String, HashSet<Time>> people : events.get(city).entrySet()) {

                    sb.append(String.format("%d. %s -> ", counter, people.getKey()));
                    people.getValue().stream().sorted((s1, s2) -> {
                        int h1 = s1.getHours();
                        int h2 = s2.getHours();
                        int dif1 = h1 - h2;
                        if (dif1 != 0) {
                            return dif1;
                        }
                        int min1 = s1.getMinutes();
                        int min2 = s2.getMinutes();
                        int dif2 = min1 - min2;
                        return dif2;
                    }).forEach(hhh -> {
                        sb.append(String.format("%02d:%02d, ", hhh.getHours(), hhh.getMinutes()));
                    });
                    sb.delete(sb.length() - 2, sb.length()).append(System.lineSeparator());
                    counter++;
                }
            }
        }
        System.out.println(sb.toString());
        String tt = "";

    }
}
class Time {
private  int hours;
private int minutes;
public Time(int hours,int minutes){
    this.hours = hours;
    this.minutes=minutes;
}

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}

