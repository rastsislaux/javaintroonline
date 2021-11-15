package engineer.leepsky.javaintroonline.algorithmization.sort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sort1 {
    
    /* Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
       один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
       дополнительный массив. */

    public static int[] scanArray(int n, Scanner in) {

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            result[i] = in.nextInt();

        }

        return result;

    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");

        }

        System.out.println();

    }

    public static int[] combineArrays(int[] first, int[] second, int k) {

        int[] result = new int[first.length + second.length];
        int j = 0;

        for (; j < k; j++) {

            result[j] = first[j];

        }

        for (int i = 0; i < second.length; i++, j++) {

            result[j] = second[i];

        }

        for (int i = k; i < first.length; i++, j++) {

            result[j] = first[i];

        }

        return result;

    }
    
    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n, m, k: ");
            int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

            System.out.println("arrays: ");
            int[] first = scanArray(n, in), second = scanArray(m, in);

            in.close();

            printArray(combineArrays(first, second, k));

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }

    }

}
