package engineer.leepsky.javaintroonline.algorithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix16  {
    
    /* Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
       ..., n 2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
       собой. Построить такой квадрат. */

    public static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static int[][] arrayToMatrix(int[] array) {

        int n = (int)Math.sqrt(array.length);

        int[][] result = new int[n][n];

        for (int i = 0; i < array.length; i++) {

            result[(int)(i / n)][i % n] = array[i];

        }

        return result;

    }

    public static boolean nextPermutation(int[] a) {

        // Генератор всевозможных перестановок

        int i = a.length - 1;

        while (--i >= 0 && a[i] > a[i + 1]);

        if (i == -1) {

            // Если перестановок более нет...
            return false;

        }

        for (int j = i + 1, k = a.length - 1; j < k; j++, k--) {

            swap(a, j, k);

        }

        int j = i + 1;
        while (a[j] < a[i]) {

            j++;

        }

        swap(a, i, j);
        return true;

    }

    public static boolean checkForMagicSquare(int[][] a) {

        int previousSum = 0;

        // Проверим суммы строк
        for (int i = 0; i < a.length; i++) {

            int rowSum = 0;

            for (int j = 0; j < a[i].length; j++) {

                rowSum += a[i][j];

            }

            if (i != 0 && rowSum != previousSum) {

                return false;

            }

            previousSum = rowSum;

        }


        // Проверим суммы колонок
        for (int j = 0; j < a[0].length; j++) {

            int columnSum = 0;

            for (int i = 0; i < a.length; i++) {

                columnSum += a[i][j];

            }

            if (columnSum != previousSum) {

                return false;

            }

            previousSum = columnSum;

        }

        // Проверим суммы диагоналей

        previousSum = 0;

        for (int i = 0; i < a.length; i++) {

            previousSum += a[i][i];

        }

        int sideSum = 0;

        for (int i = a.length-1; i >= 0; i--) {

            sideSum += a[i][a.length-1-i];

        }

        if (sideSum != previousSum) {

            return false;

        }

        return true;

    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n: ");
            int n = in.nextInt();

            in.close();

            int[] a = new int[n*n];

            for (int i = 0; i < n*n; i++)
                a[i] = i+1;

            do {

                if (checkForMagicSquare(arrayToMatrix(a))) {

                    Matrix14.printMatrix(arrayToMatrix(a));
                    return;

                }

            } while (nextPermutation(a));

            System.out.println("No magic squares found.");

            in.close();
        
        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());
            
        }

    }

}
