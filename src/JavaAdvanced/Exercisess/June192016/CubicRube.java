package JavaAdvanced.Exercisess.June192016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CubicRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int sum =0;
        int sells =  n * n * n;
        while (true) {
String line = reader.readLine();
if("Analyze".equals(line)){
    break;
}
int[] coordinates = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
int xCoordinate = coordinates[0];
int yCoordinate = coordinates[1];
int zCoordinate = coordinates[2];
int terget = coordinates[3];
if(check(xCoordinate,yCoordinate,zCoordinate,n) && terget !=0){
sum += terget;
sells--;
}
        }
        System.out.println(sum);
        System.out.println(sells);
    }
    public static boolean check(int x,int y,int z ,int size){
        return x>=0 && x<size && y >= 0 && y< size && z>= 0 && z<size;
    }
}
