package JavaAdvanced.Exercisess.SampleExam13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> evilPower = new ArrayList<>();
        int[][] matrix = new int[size[0]][size[1]];
        int counter = 0;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        while (true) {
            String line = reader.readLine();
            if ("Let the Force be with you".equals(line)) {
                break;
            }
            int[] coordinates = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            evilPower.addAll(getEvilDiagonal(evilCoordinates[0], evilCoordinates[1], matrix));
            ArrayList<Integer> ivoo = getIvoDiagonal(coordinates[0], coordinates[1], matrix);
            for (int jj : ivoo) {
                if (!evilPower.contains(jj)) {
                    sum += jj;
                }
            }

        }

        System.out.println(sum);
    }

    public static ArrayList<Integer> getIvoDiagonal(int startRow, int startCol, int[][] matrix) {
        ArrayList<Integer> ivoPath = new ArrayList<>();

        for (; startRow>=0 && startCol<matrix[0].length ; startRow--,startCol++) {
            if (startRow < matrix.length && startCol >= 0) {
                ivoPath.add(matrix[startRow][startCol]);

            }
        }
        return ivoPath;

    }

    public static ArrayList<Integer> getEvilDiagonal(int startRow, int startCol, int[][] matrix) {
        ArrayList<Integer> evilPath = new ArrayList<>();

        for (; startCol >= 0 && startRow >= 0; startCol--, startRow--) {
            if (startCol < matrix[0].length && startRow < matrix.length) {
                evilPath.add(matrix[startRow][startCol]);

            }
        }
            return evilPath;
        }
    }
