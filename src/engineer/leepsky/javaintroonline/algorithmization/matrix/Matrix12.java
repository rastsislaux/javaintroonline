package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix12  {
    
    /* Отсортировать строки матрицы по возрастанию и убыванию значений элементов. */

    public static void print_matrix(int[][] matrix) {

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
            int n = in.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = in.nextInt();

            System.out.println("From smaller to bigger: ");

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++) {

                        if (a[i][j] < a[i][k]) {
                            int temp = a[i][j];
                            a[i][j] = a[i][k];
                            a[i][k] = temp;
                        }

                    }

            }

            print_matrix(a);

            System.out.println("From bigger to smaller: ");

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++) {

                        if (a[i][j] > a[i][k]) {
                            int temp = a[i][j];
                            a[i][j] = a[i][k];
                            a[i][k] = temp;
                        }

                    }

            }

            print_matrix(a);

            in.close();
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
