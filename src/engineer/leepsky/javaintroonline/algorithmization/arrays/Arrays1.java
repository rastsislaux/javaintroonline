package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays1 {

    /* В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К. */

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("n, k: ");
            int n = in.nextInt(), k = in.nextInt(), sum = 0;
            int[] a = new int[n];
            System.out.print("a[0-i]: ");
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] % k == 0)
                    sum += a[i];
            }
            System.out.println(sum);
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("\nInput error! " + e.getMessage());
        }
    }
    
}
