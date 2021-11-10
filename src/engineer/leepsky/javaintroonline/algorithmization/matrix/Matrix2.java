package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix2 {
    
    /* Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали. */

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);
            System.out.print("n: ");
            int n = in.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            in.close();

            System.out.print("Result: ");
            for (int i = 0, j = 0; i < n && j < n; i++, j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }
    }

}
