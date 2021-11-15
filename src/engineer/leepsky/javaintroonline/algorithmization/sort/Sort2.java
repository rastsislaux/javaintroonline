package engineer.leepsky.javaintroonline.algorithmization.sort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sort2 {

    /* Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm . Образовать из них новую последовательность
       так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать. */

    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static int[] sort(int[] source) {

        int[] result = source;

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result.length; j++) {

                if (result[i] < result[j]) {

                    swap(result, i, j);

                }

            }

        }

        return result;
        
    }

    public static int[] combineArraysInc(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        for (int i = 0; i < a.length; result[i] = a[i], i++);
        for (int i = 0; i < b.length; result[a.length + i] = b[i], i++);

        return sort(result);

    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n, m: ");
            int n = in.nextInt(), m = in.nextInt();

            System.out.println("arrays:");
            int[] a = Sort1.scanArray(n, in), b = Sort1.scanArray(m, in);

            Sort1.printArray(combineArraysInc(a, b));

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }

    }
    
}
