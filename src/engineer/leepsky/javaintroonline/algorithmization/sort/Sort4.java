package engineer.leepsky.javaintroonline.algorithmization.sort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sort4 {
    
    /* Сортировка обменами. Дана последовательность чисел a1 <= a2 <= ... <= an .Требуется переставить числа в
       порядке возрастания. Для этого сравниваются два соседних числа ai и ai +1 . Если ai > ai +1 , то делается
       перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
       Составить алгоритм сортировки, подсчитывая при этом количества перестановок. */

    public static int bubbleSortWithCounter(int[] array) {

        int counter = 0;

        for (int i = 1; i < array.length; i++) {

            boolean f = false;

            for (int j = 0; j < array.length-i; j++) {

                if (array[j] < array[j+1]) {

                    Sort2.swap(array, j, j+1);
                    counter++;
                    f = true;

                }

            }

            if (!f) break;

        }

        return counter;

    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("n: ");
            int n = in.nextInt();
            System.out.print("array: ");
            int[] array = Sort1.scanArray(n, in);
            
            int c = bubbleSortWithCounter(array);

            System.out.println("Replacements: " + c);
            Sort1.printArray(array);

            in.close();

        } catch (InputMismatchException e) {

            System.out.println("\nInput error! " + e.getMessage());

        }

    }

}
