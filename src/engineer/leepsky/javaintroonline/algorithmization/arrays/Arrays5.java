package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.Scanner;

public class Arrays5 {

    /* Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i. */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n: ");
        int n = in.nextInt();
        int[] a = new int[n];
        System.out.print("a[0-n]: ");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > i+1) System.out.print(a[i] + " ");
        }
        System.out.println();
        in.close();
    }
    
}
