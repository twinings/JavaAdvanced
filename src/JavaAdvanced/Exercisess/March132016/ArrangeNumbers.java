package JavaAdvanced.Exercisess.March132016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class ArrangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(", ");
        TreeMap<String, String> sortedNums = new TreeMap<>();
        for (String current : line) {
            String currentNum = "";
            for (int i = 0; i < current.length(); i++) {
                if (i != 0) {
                    currentNum += "-";
                }
                switch (current.charAt(i)) {
                    case '0':
                        currentNum += "zero";
                        break;
                    case '1':
                        currentNum += "one";
                        break;
                    case '2':
                        currentNum += "two";
                        break;
                    case '3':
                        currentNum += "three";
                        break;
                    case '4':
                        currentNum += "four";
                        break;
                    case '5':
                        currentNum += "five";
                        break;
                    case '6':
                        currentNum += "six";
                        break;
                    case '7':
                        currentNum += "seven";
                        break;
                    case '8':
                        currentNum += "eight";
                        break;
                    case '9':
                        currentNum += "nine";
                        break;
                }
            }
            if (sortedNums.containsKey(currentNum)) {
                String newVal = sortedNums.get(currentNum) + ", " + current;
                sortedNums.put(currentNum, newVal);
            } else {
                sortedNums.put(currentNum, current);
            }
        }
        String output = String.join(", ", sortedNums.values());
        System.out.println(output);
    }
}
