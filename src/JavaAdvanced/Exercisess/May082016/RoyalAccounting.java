package JavaAdvanced.Exercisess.May082016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String patt = "^(?<employee>[A-Za-z]+);(?<hours>(?:-|\\+)*\\d+);(?<payment>(?:-|\\+)*\\d+(?:\\.\\d+)?);(?<team>[A-Za-z]+)$";
        HashSet<String> names = new HashSet<>();
        HashMap<String, Team> teams = new HashMap<>();
        Pattern pattern = Pattern.compile(patt);
        while (true) {
            String line = reader.readLine();
            if ("Pishi kuf i da si hodim".equals(line)) {
                break;
            }
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String currentEmployee = matcher.group("employee");
                if (!names.contains(currentEmployee)) {
                    names.add(currentEmployee);
                    int currentHours = Integer.parseInt(matcher.group("hours"));
                    double currentPayment = Double.parseDouble(matcher.group("payment"));
                    String currentTeam = matcher.group("team");

                    teams.putIfAbsent(currentTeam, new Team(currentTeam));
                    teams.get(currentTeam).addEmplyee(new Employee(currentEmployee,currentHours,currentPayment));
                }


            }
        }
        teams.values().stream().sorted().forEach(System.out::print);
    }
}
class Employee implements Comparable<Employee> {
    private static final double WORKING_DAYS = 30.0;
    private static final double TWENTY_FOUR_HOURS = 24.0;
    private String name;
    private  int hoursPerDay;
    private double dailyPayment;
    public Employee(String name,int hoursPerDay,double dailyPayment){
        this.name=name;
        this.hoursPerDay=hoursPerDay;
        this.dailyPayment=dailyPayment;
    }

    public String getName() {
        return this.name;
    }

    public double getDailyPayment() {
        return this.dailyPayment;
    }

    @Override
    public String toString() {
        return  String.format("$$$%s - %s - %.6f",this.getName() ,this.getHoursPerDay(),this.getDailyIncom());
    }

     double getMonthlyPayment(){
        return ((this.getDailyPayment() * this.getHoursPerDay())/ TWENTY_FOUR_HOURS)*WORKING_DAYS;

    }

    public int getHoursPerDay() {
        return this.hoursPerDay;
    }
    private double getDailyIncom(){
        return  (this.getDailyPayment() * this.getHoursPerDay())/TWENTY_FOUR_HOURS;

    }

    @Override
    public int compareTo(Employee o) {
        int diff = Integer.compare(o.getHoursPerDay(),this.getHoursPerDay());
        diff = diff != 0 ? diff : Double.compare(o.getDailyIncom()  ,this.getDailyIncom());
        return diff != 0 ? diff : this.getName().compareTo(o.getName());
    }

}
class Team implements Comparable<Team>{
private String name;
private List<Employee> employees;
public Team(String name){
    this.name = name;
    this.employees= new ArrayList<>();
}
public void addEmplyee(Employee employee){
    this.getEmployees().add(employee);
}
public double getSum(){
    return  this.getEmployees().stream().map(Employee::getMonthlyPayment).reduce(0.0,Double::sum);

}
private String getName() {
    return this.name;
}

    private List<Employee> getEmployees() {
        return this.employees;
    }

    private String getToString() {
    StringBuilder sb = new StringBuilder();
    this.getEmployees().stream().sorted().forEach(e -> sb.append(e).append(System.lineSeparator()));
    return sb.toString();
}

    @Override
    public String toString() {
        return String.format("Team - %s%n%s", this.getName(),this.getToString());
    }

    @Override
    public int compareTo(Team other) {
        return Double.compare(other.getSum(),this.getSum());
    }
}

