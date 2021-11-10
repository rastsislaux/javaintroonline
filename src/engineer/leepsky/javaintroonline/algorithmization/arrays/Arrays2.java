package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays2 {

    /* Дана последовательность действительных чисел а1 ,а2 ,..., аn. Заменить все ее члены, большие данного Z, этим
       числом. Подсчитать количество замен. */

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("n, z: ");
            int n = in.nextInt(), z = in.nextInt();
            int[] a = new int[n];
            System.out.print("a[0-n]: ");
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] > z) a[i] = z;
            }
            System.out.print("a: ");
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
