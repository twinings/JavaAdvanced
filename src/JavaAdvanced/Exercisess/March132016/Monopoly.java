package JavaAdvanced.Exercisess.March132016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Monopoly {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startCol = 0;
        int turns =0;
        int initialMoney = 50;
        ArrayList<Integer> indexesOfHotels = new ArrayList<>();
        for (int i = 0; i < size[0]; i++) {
            String[] commands = reader.readLine().split("");

            for (int j = 0; j < size[1]; j++) {
                if (i % 2 != 0) {

                    startCol--;
                }
                String current = commands[startCol];



                switch(current){
                    case "H":
indexesOfHotels.add(turns);
System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", initialMoney,indexesOfHotels.size());
initialMoney=0;
turns++;

                        break;
                    case "F":
                        turns++;
                        break;
                    case "J":
                        System.out.printf("Gone to jail at turn %d.\n",turns);
                        turns +=3;
                        initialMoney +=2 *( indexesOfHotels.size() * 10);
                        break;
                    case "S":
                        if(initialMoney>=(i+1)*(startCol+1)) {

                            System.out.printf("Spent %d money at the shop.\n", (i +1)*( startCol+1));
                            initialMoney -= (i+1) * (startCol+1);}
                         else{
                            System.out.printf("Spent %d money at the shop.\n", initialMoney);
                            initialMoney=0;
                        }
                        turns++;
                        break;
                        default:
                            break;
                }
                initialMoney += indexesOfHotels.size() * 10;
                if (i % 2 == 0) {

                    startCol++;
                }
            }
        }
        System.out.println("Turns " + turns);
        System.out.println("Money " + initialMoney );
    }
}
