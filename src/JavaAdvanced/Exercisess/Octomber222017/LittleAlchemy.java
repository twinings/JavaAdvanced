package JavaAdvanced.Exercisess.Octomber222017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LittleAlchemy {
    private static int gold;
    private static ArrayDeque<Integer> stones;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gold = 0;

        stones = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        while (true) {
            String line = reader.readLine();
            if ("Revision".equalsIgnoreCase(line)) {
                break;
            }

            String[] commands = line.split(" ");
            int value = Integer.parseInt(commands[2]);
            if ("Apply".equalsIgnoreCase(commands[0])) {
                if (value > 0 && stones.size() > 0) {
                    for (int i = 0; i < value; i++) {
                        if(stones.isEmpty()){
                            break;
                        }
                        int current = stones.poll();
                        if (current > 1) {
                            current--;
                            stones.addLast(current);
                        } else if (current == 1) {
                            gold++;

                        }
                    }
                }
            } else if ("Air".equalsIgnoreCase(commands[0])) {
                if (gold > 0) {
                    stones.addLast(value);
                    gold--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stones.isEmpty()) {
            sb.append(stones.removeFirst()).append(" ");
        }
        if (!sb.toString().isEmpty()) {
            System.out.println(sb.toString());
        }
        System.out.println(gold);

    }
}