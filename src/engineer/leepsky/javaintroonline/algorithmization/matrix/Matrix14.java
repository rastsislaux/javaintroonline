package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Matrix14  {
    
    /* Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
       единиц равно номеру столбца. */

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();

        }

    }

    public static int[][] generateMatrix(int n, int m) {

        int[][] result = new int[n][m];
        Random rand = new Random(System.currentTimeMillis());

        for (int j = 0; j < m; j++) {

            for (int i = 0; i < n; i++) {

                result[i][j] = 0;

            }

            int count = 0;

            while (count < j) {

                int line = rand.nextInt(n);
                if (result[line][j] != 1) {

                    result[line][j] = 1;
                    count++;

                }

            }

        }

        return result;

    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n, m: ");
            int n = in.nextInt(), m = in.nextInt();

            in.close();

            printMatrix(generateMatrix(n, m));
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}