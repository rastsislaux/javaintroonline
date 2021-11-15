package engineer.leepsky.javaintroonline.algorithmization.sort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sort3 {

    /* Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an .Требуется переставить элементы так,
       чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
       элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
       повторяется. Написать алгоритм сортировки выбором. */

    public static int max(int[] array, int start) {

        int result = start;

        for (int i = start; i < array.length; i++) {

            if (array[i] > array[result]) result = i; 

        }

        return result;

    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
        
            Sort2.swap(array, i, max(array, i));

        }

    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n: ");
            int n = in.nextInt();
            System.out.print("array: ");
            int[] array = Sort1.scanArray(n, in);

            in.close();

            selectionSort(array);
            Sort1.printArray(array);

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }

    }
    
}
