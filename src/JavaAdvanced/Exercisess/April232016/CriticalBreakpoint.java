package JavaAdvanced.Exercisess.April232016;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class CriticalBreakpoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long value =0L;
        Integer counter = 0;
        boolean test = true;
        StringBuilder sb = new StringBuilder();
while (true){
    String line = reader.readLine();
    if("Break it.".equals(line)){
        break;
        }
        int[] coordinatesArr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    long absoluteValue = Math.abs(((long)coordinatesArr[2]+(long)coordinatesArr[3]) -((long)coordinatesArr[0]+(long)coordinatesArr[1]));
    if(absoluteValue != 0){
        if(value==0){
            value=absoluteValue;
        }else if(absoluteValue != value){
                System.out.println("Critical breakpoint does not exist.");
                test = false;
                break;
            }


    }
    sb.append("Line: [").append(String.join(", ",line.split(" "))).append("]").append(System.lineSeparator());
counter++;
}
if(test){
    BigInteger result = new BigInteger(value.toString());
    result = result.pow(counter);
    BigInteger lines = new BigInteger(counter.toString());
    BigInteger remaindr = result.remainder(lines);

System.out.print(sb.toString());
    System.out.println("Critical Breakpoint: "+ remaindr);
}
    }
}