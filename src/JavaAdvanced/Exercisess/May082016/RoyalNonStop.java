package JavaAdvanced.Exercisess.May082016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double[] prices =Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        HashMap<String,BigDecimal> price = new HashMap<>();
        BigDecimal ll = new BigDecimal(Double.toString(prices[0]));
        BigDecimal rr = new BigDecimal(Double.toString(prices[1]));
        price.put("L",ll);
        price.put("R",rr);
        int costumers =0;
        BigDecimal total = BigDecimal.ZERO;
        double moneyEarned = 0;
        String[][] arr = new String[size[0]][size[1]];

for(int i = 0 ; i< size[0]; i++){
    for (int j =0; j<size[1]; j++){
if(i==0 && j== 0){
    arr[i][j] = "D";
    continue;
}
if(i%2 == 0){
    arr[i][j] = "L";
}else{
    arr[i][j] = "R";
}
    }
}
        while (true){
            String line = reader.readLine();
            if("Royal Close".equals(line)){
                break;
            }
            int[] indexes = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();


if(indexes[0] < indexes[1]){
total=total.add(upAndLeft(indexes[0] , indexes[1],arr,price));
}else{
  total= total.add(leftAndUp(indexes[0],indexes[1],arr,price));

}
String ddd ="";
costumers++;
        }
        System.out.println(total.setScale(6, RoundingMode.HALF_EVEN));
System.out.println(costumers);
    }
    public  static BigDecimal upAndLeft(int row , int col , String[][] matrix ,HashMap<String,BigDecimal> price){
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal startCol = new BigDecimal(Integer.toString(col +1));

        for(int i = row; i>=0; i--){
            BigDecimal bigRow = new BigDecimal(Integer.toString(i+1));
            sum =sum.add( price.get(matrix[i][col]).multiply(startCol).multiply(bigRow));
        }
        for(int i = col-1;i>0; i--){
            BigDecimal bigCol = new BigDecimal(Integer.toString(i+1));
         sum=  sum.add( price.get(matrix[0][i]).multiply(bigCol)) ;

        }
        return sum;


    }
    public static BigDecimal leftAndUp(int row,int col,String[][] matrix , HashMap<String,BigDecimal> price){
        BigDecimal currentCustomer = BigDecimal.ZERO;
BigDecimal startRow = new BigDecimal(Integer.toString(row+1));

        for(int i = col;i>=0 ;i--){
            BigDecimal currentCol = new BigDecimal(Integer.toString(i+1));
currentCustomer             =currentCustomer.add(price.get(matrix[row][i]).multiply(startRow).multiply(currentCol));

        }
        for(int i = row-1; i >0 ; i--){
            BigDecimal bigRow = new BigDecimal(Integer.toString(i+1));
            currentCustomer             =currentCustomer.add(price.get(matrix[row][i]).multiply(bigRow));
        }
        return currentCustomer;
    }

}
