package JavaAdvanced.Exercisess.February192017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];
        while (true) {
            String line = reader.readLine();
            if ("Here We Go".equals(line)) {
                break;
            }
            int[] indexes = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (checker(indexes[0], indexes[1], indexes[2], indexes[3], matrix)) {
                for (int i = indexes[0]; i <= indexes[2]; i++) {
                    for (int j = indexes[1]; j <= indexes[3]; j++) {
                        matrix[i][j]++;
                    }
                }
            }
        }
String test = "";
        for (int i =0; i<matrix.length ; i++){
            for (int j =0; j<matrix[i].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean checker(int startRow , int startCol , int endRow , int endCol , int[][] matrix){
        return  startRow>=0 && startRow<matrix.length && startCol >= 0 && startCol<matrix[0].length && endRow>=0 && endRow>=startRow && endCol >=0 && endCol>= startCol && endCol<matrix[0].length;

    }
}