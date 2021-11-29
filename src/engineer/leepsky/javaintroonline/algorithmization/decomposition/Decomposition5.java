package engineer.leepsky.javaintroonline.algorithmization.decomposition;

import engineer.leepsky.javaintroonline.algorithmization.sort.Sort1;
import engineer.leepsky.javaintroonline.algorithmization.sort.Sort6;

public class Decomposition5 {

    /* Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
       которое меньше максимального элемента массива, но больше всех других элементов). */

    public static int secondAfterMax(int[] array) {

        int[] temp = new int[array.length];

        System.arraycopy(array, 0, temp, 0, array.length);

        Sort6.sortShell(temp);

        return temp[temp.length - 2];

    }

    public static void main(String[] args) {

        int[] array = {5, 1, -3, 6, 8, 4, -6};

        System.out.println(
            secondAfterMax(array)
        );

        Sort1.printArray(array);

    }
    
}
