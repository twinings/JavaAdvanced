package JavaAdvanced.Exercisess.May032017RetakeExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ChessKnight {
    public static int invalidMoves;
    public static String startCord;
    public static int outOfBorder;
    public static String[][] matrix;
    public  static ArrayList<String> pieces;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        invalidMoves=0;
        outOfBorder=0;
        pieces= new ArrayList<>();
     matrix = new String[8][8];
     for(int i =0;i<8;i++) {
String[] line = reader.readLine().split("\\|");
for (int j =0;j<line.length ; j++){
    matrix[i][j] = line[j];
}
     }
     startCord = reader.readLine();

     while (true){
         String line = reader.readLine();
         int[] start = Arrays.stream(startCord.split("")).mapToInt(Integer::parseInt).toArray();
         if("END".equals(line)){
             break;
         }
         String[] command = line.split(" -> ");
         int[] end  = Arrays.stream(command[1].split("")).mapToInt(Integer::parseInt).toArray();
         if(!((Math.abs(end[0]-start[0]) == 1 && Math.abs(end[1] - start[1]) ==2 ) || (Math.abs(end[0]-start[0]) == 2 && Math.abs(end[1] - start[1]) ==1))){
             invalidMoves++;
             continue;
         }
         try{
           String piece =  matrix[end[0]][end[1]];
           if(!piece.isEmpty() && !" ".equals(piece)){
               pieces.add(piece);
           }
           matrix[end[0]][end[1]]= " ";
startCord = command[1];
         }catch (IndexOutOfBoundsException ee){
outOfBorder++;
         }


     }
     System.out.println("Pieces take: "+ String.join(", ", pieces));
     System.out.println("Invalid moves: "+ invalidMoves);
     System.out.println("Board out moves: "+ outOfBorder);
     //     Pieces take: Q
        //Invalid moves: 0
        //Board out moves: 0
String test ="";
     }
}
