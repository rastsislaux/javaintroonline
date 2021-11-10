package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix3 {

    /* Дана матрица. Вывести k-ю строку и p-й столбец матрицы */
    
    public static void main(String[] args) {

        try {
        
            Scanner in = new Scanner(System.in);

            System.out.println("n, m: ");
            int n = in.nextInt(), m = in.nextInt();

            int[][] arr = new int[n][m];
            System.out.println("a[0-n][0-m]: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            System.out.println("k, p: ");
            int k = in.nextInt(), p = in.nextInt();

            in.close();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == k || j == p) System.out.print(arr[i][j] + "\t");
                    else System.out.print(" \t");
                }
                System.out.println();
            }

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }

    }
}
