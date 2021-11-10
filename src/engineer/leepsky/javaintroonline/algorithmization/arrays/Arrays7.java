package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays7 {

    /* Даны действительные числа a 1 , a 2 ,  , a n . Найти max(a1 + a2n, a2 + a2n-1) */

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("n: ");
            int n = in.nextInt();
            int[] a = new int[n];
            System.out.print("a[0-n]: ");
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int max = 0;
            for (int i = 0; i <= n/2; i++) {
                if (a[i] + a[n-1-i] > max) {
                    max = a[i] + a[n-1-i];
                }
            }
            System.out.println(max);
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("\nInput error! " + e.getMessage());
        }
    }
    
}
