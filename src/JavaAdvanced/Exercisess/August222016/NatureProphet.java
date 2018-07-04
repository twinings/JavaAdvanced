package JavaAdvanced.Exercisess.August222016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NatureProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];
        ArrayList<int[]> indexList = new ArrayList<>();
        while (true){
            String line = reader.readLine();
            if("Bloom Bloom Plow".equals(line)){
                break;
            }
            int[] indexes = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if(checkIndexes(indexes[0],indexes[1],matrix)) {
                if (matrix[indexes[0]][indexes[1]] == 0) {
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i][indexes[1]]++;
                    }
                    for (int j = 0; j < matrix[0].length; j++) {

                            matrix[indexes[0]][j]++;

                    }
                    matrix[indexes[0]][indexes[1]]--;
                }
            }
        }
        for(int i =0; i<matrix.length;i++){
            for (int j =0 ;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        String test = "";

    }

    public static boolean checkIndexes(int row,int col, int[][] matrix){
       return  row>=0 && row<matrix.length && col>= 0 && col<matrix[row].length;
    }
}
