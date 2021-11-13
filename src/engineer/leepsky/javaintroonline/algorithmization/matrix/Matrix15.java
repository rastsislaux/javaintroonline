package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix15  {
    
    /* Найдите наибольший элемент матрицы и заменить все нечетные элементы на него. */

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();

        }

    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n: ");
            int n = in.nextInt(), max = Integer.MIN_VALUE;
            int[][] a = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {

                    a[i][j] = in.nextInt();
                    if (max < a[i][j]) max = a[i][j];

                }

            in.close();

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {

                    if(a[i][j] % 2 == 0) a[i][j] = max;

                }

            printMatrix(a);
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
