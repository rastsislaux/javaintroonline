package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.Scanner;

public class Arrays6 {

    /* Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
       являются простыми числами. */

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n: ");
        int n = in.nextInt(), sum = 0;
        int[] a = new int[n];
        System.out.print("a[0-n]: ");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (isPrime(i)) sum += a[i];
        }
        System.out.println(sum);
        in.close();
    }
    
}
