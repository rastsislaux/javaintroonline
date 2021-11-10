package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix1 {
    
    /* Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего. */

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n, m: ");
            int n = in.nextInt(), m = in.nextInt();

            int[][] arr = new int[n][m];
            System.out.println("a[0-n][0-m]: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            /* Будем считать, что нечетные - 0-ой, 2-ой и т.д. столбцы */

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[0][j] > arr[n-1][j]) System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            in.close();

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }
    }

}
