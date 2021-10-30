package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.Scanner;

public class Arrays8 {

    /* Дана последовательность целых чисел a 1 , a 2 , ... , a n . Образовать новую последовательность, выбросив из
       исходной те члены, которые равны min( a 1 , a 2 , ... , a n ) . */

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();
        int[] a = new int[n], b = new int[n];

        System.out.print("a[0-n]: ");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int min = a[0];

        for (int i = 0; i < n; i++) {
            if (min > a[i]) min = a[i];
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != min) {
                b[j] = a[i];
                j++;
            } 
        }

        for (int i = 0; i < j; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        in.close();
    }
    
}
