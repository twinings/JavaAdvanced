package JavaAdvanced.Exercisess.Feb262016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, HashSet<Integer>> parkingMatrix = new HashMap<>();
        String line;
        for (int i = 0; i < size[0]; i++) {
            parkingMatrix.put(i, new HashSet<Integer>());
        }
        while (true) {
            line =reader.readLine();
            if ("stop".equals(line)) {
                break;
            }
            int[] coordinates = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int enteringRow = coordinates[0];
            int desiredRow = coordinates[1];
            int desiredCol = coordinates[2];


            if (!isPlaceOccupied(parkingMatrix,desiredRow,desiredCol)) {
                parkingMatrix.get(desiredRow).add(desiredCol);
                int distance = Math.abs(enteringRow-desiredRow) + desiredCol + 1;

                System.out.println(distance);
                }
                else{

                int target = findFreeSpace(parkingMatrix.get(desiredRow) , size[1],desiredCol);
                if(target==0){
                    System.out.printf("Row %d full\n" , desiredRow);
                }else{
                    parkingMatrix.get(desiredRow).add(target);
                    int distance2 = Math.abs(enteringRow-desiredRow)+target+1;
                    System.out.println(distance2);
                }

            }
        }
    }
    public static boolean isPlaceOccupied(HashMap<Integer,HashSet<Integer>> parking , int row , int col){
        return  parking.get(row).contains(col);
    }
    public static int findFreeSpace(HashSet<Integer> line , int size,int target){
int targetColIndex = 0;
int minDist = Integer.MAX_VALUE;
if(line.size() == size-1){
    return targetColIndex;
}else{
        for(int i =1; i<size ; i++){
            int currentDistance = Math.abs(target-i);
            if(!line.contains(i) && currentDistance<minDist){
                 targetColIndex = i;
                 minDist= currentDistance;
            }
        }
}

return targetColIndex;
    }
}

