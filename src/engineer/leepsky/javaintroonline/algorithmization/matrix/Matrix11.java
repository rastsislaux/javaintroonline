package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;

public class Matrix11  {
    
    /* Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
       которых число 5 встречается три и более раз. */

    public static void main(String[] args) {

        try {

            int[][] a = new int[10][20];

            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 20; j++) {

                    a[i][j] = (int)(Math.random() * 15);
                    System.out.print(a[i][j] + " ");

                }

                System.out.println();

            }

            System.out.print("Row numbers: ");

            for (int i = 0; i < 10; i++) {

                int count = 0;

                for (int j = 0; j < 20; j++) {

                    if (a[i][j] == 5) count++;
                    if (count == 3) break;

                }

                if (count >= 3) System.out.print(i + " ");

            }

            System.out.println();
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
