package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix9  {
    
    /* Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
       столбец содержит максимальную сумму. */

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.println("n: ");
            int n = in.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = in.nextInt();

            int[] sum = new int[n];

            for (int j = 0; j < n; j++) {

                sum[j] = 0;

                for (int i = 0; i < n; i++) {

                    sum[j] += a[i][j];

                }

            }

            int max = 0;
            for (int i = 1; i < n; i++) {
                if (sum[i] > sum[max]) max = i;
            }

            System.out.println(max);

            in.close();
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
