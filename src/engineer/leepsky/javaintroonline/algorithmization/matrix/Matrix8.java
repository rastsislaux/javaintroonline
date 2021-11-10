package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix8 {
    
    /* В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
       на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
       пользователь с клавиатуры. */

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.println("n, x, y: ");
            int n = in.nextInt(), x = in.nextInt(), y = in.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = in.nextInt();

            for (int i = 0; i < n; i++) {
                int temp = a[i][x];
                a[i][x] = a[i][y];
                a[i][y] = temp; 
            }

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    System.out.print(a[i][j] + " ");

                }

                System.out.println();
            }

            in.close();
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
