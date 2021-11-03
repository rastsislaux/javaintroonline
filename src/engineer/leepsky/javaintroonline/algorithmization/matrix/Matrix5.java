package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.Scanner;

public class Matrix5 {
    
    /* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
       1    1   1   ... 1   1   1
       2    2   2   ... 2   2   0
       3    3   3   ... 3   0   0
       ...  ... ... ... ... ... ...
       n-1  n-1 0   ... 0   0   0
       n    0   0   ... 0   0   0 */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        System.out.print("n: ");
        int n = in.nextInt();

        in.close();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n-i) arr[i][j] = i+1;
                else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
