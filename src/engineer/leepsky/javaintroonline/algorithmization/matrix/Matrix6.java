package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.Scanner;

public class Matrix6 {

    /* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
       1    1   1   ... 1   1   1
       0    1   1   ... 1   1   0
       0    0   1   ... 1   0   0
       ...  ... ... ... ... ... ...
       0    1   1   ... 1   1   0
       1    1   1   ... 1   1   1 */

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();
        
        in.close();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= i/2+1 && j >= i && j < n-i) arr[i][j] = 1;
                else if (j >= n-i-1 && j < i+1) arr[i][j] = 1;
                else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    
}
