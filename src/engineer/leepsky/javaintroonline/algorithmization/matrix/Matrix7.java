package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.Scanner;

public class Matrix7 {
    
    /* Сформировать квадратную матрицу порядка N по правилу:
       a[i, j] = sin((i^2 - j^2)/N) */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();

        in.close();

        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Math.sin((i*i-j*j)/n);
                System.out.print((float)arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
