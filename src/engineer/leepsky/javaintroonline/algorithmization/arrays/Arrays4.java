package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays4 {

    /* Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы. */

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("n: ");
            int n = in.nextInt(), max = 0, min = 0;
            int[] a = new int[n];
            System.out.print("a[0-n]: ");
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] > a[max]) max = i;
                else if (a[i] < a[min]) min = i;
            }
            int temp = a[max];
            a[max] = a[min];
            a[min] = temp;
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("\nInput error! " + e.getMessage());
        }
    }
    
}
