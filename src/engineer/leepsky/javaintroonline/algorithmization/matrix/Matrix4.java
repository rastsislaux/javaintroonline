package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.Scanner;

public class Matrix4 {

    /* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
       1    2   ... n
       n    n-1 ... 1
       1    2   ... n
       ... */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) arr[i][j] = j+1;
                else arr[i][j] = n-j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        in.close();

    }
    
}
