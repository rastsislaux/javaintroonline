package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix10  {
    
    /* Найти положительные элементы главной диагонали квадратной матрицы. */

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n: ");
            int n = in.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = in.nextInt();

            for (int i = 0; i < n; i++) {

                if (a[i][i] > 0) System.out.print(a[i][i] + " ");

            }
                        
            System.out.println();

            in.close();
            
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
