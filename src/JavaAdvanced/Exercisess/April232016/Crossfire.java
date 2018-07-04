package JavaAdvanced.Exercisess.April232016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer counter = 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < size[0]; i++) {
            ArrayList<Integer> fill = new ArrayList<>();
            for (int j = 0; j < size[1]; j++) {
                fill.add(counter);
                counter++;
            }
            matrix.add(fill);
        }
        while (true) {
            String line = reader.readLine();
            if ("Nuke it from orbit".equals(line)) {
                break;
            }
            int[] coordinates = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int desiredRow = coordinates[0];
            int desiredCol = coordinates[1];
            int radius = coordinates[2];

                int start = desiredRow-radius;
                int end = desiredRow+radius;
for(int i  = start ; i<=end ;i++) {
    if(isInMatrix(i,desiredCol,matrix)){
        matrix.get(i).set(desiredCol,-1);
    }
}


        for(int j =desiredCol-radius;j<=desiredCol+radius;j++){
            if(isInMatrix(desiredRow,j,matrix)){
                matrix.get(desiredRow).set(j,-1);

    }
}
filterMatrix(matrix);
            }


            matrix.forEach(line ->{ line.forEach(ii ->{ System.out.printf("%d ",ii);
         }
            );
            System.out.println();});
System.out.println(44%26);

    }
    private static void filterMatrix(ArrayList<ArrayList<Integer>> matrix){
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeAll(Arrays.asList((new Integer[] {-1})));
        }
        matrix.removeAll(Arrays.asList(new ArrayList<Integer>()));
    }
    private static boolean isInMatrix(int row ,int col , ArrayList<ArrayList<Integer>> matrix){
        return  row >= 0 && row < matrix.size() && col>=0 &&  col <matrix.get(row).size()  ;
    }
}
