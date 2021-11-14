package engineer.leepsky.javaintroonline.algorithmization.sort;

import java.util.Scanner;

public class Sort2 {

    /* Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm . Образовать из них новую последовательность
       так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать. */

    public static int[] bubbleSort(int[] source) {

        int[] result = source;

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result.length; j++) {

                if (result[i] < result[j]) {

                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;

                }

            }

        }

        return result;
        
    }

    public static int[] combineArraysInc(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        for (int i = 0; i < a.length; result[i] = a[i], i++);
        for (int i = 0; i < b.length; result[a.length + i] = b[i], i++);

        return bubbleSort(result);

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("n, m: ");
        int n = in.nextInt(), m = in.nextInt();

        System.out.println("arrays:");
        int[] a = Sort1.scanArray(n, in), b = Sort1.scanArray(m, in);

        Sort1.printArray(combineArraysInc(a, b));

    }
    
}
