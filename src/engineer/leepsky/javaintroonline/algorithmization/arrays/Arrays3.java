package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays3 {

    /* Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
       положительных и нулевых элементов. */

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("n: ");
            int n = in.nextInt(), negative = 0, positive = 0, zero = 0;
            int[] a = new int[n];
            System.out.print("a[0-n]: ");
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] > 0) positive++;
                else if (a[i] == 0) zero++;
                else negative++;
            }
            System.out.format("Positive: %d\nNull: %d\nNegative: %d\n", positive, zero, negative);
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("\nInput error! " + e.getMessage());
        }
    }
    
}
