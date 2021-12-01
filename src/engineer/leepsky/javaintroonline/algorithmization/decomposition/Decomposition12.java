package engineer.leepsky.javaintroonline.algorithmization.decomposition;

import engineer.leepsky.javaintroonline.algorithmization.sort.Sort1;

public class Decomposition12 {

    /* Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
       являются числа, сумма цифр которых равна К и которые не большее N. */

    public static int arraySum(long[] array) {

        int sum = 0;
        for (long e : array) sum += e;
        return sum;

    }

    public static int[] addElement(int[] array, int element) {

        int[] temp = new int[array.length + 1];

        System.arraycopy(array, 0, temp, 0, array.length);

        temp[temp.length - 1] = element;

        return temp;

    }

    public static int[] generateArray(int k, int n) {

        int i = 0; int[] array = new int[0];

        while (i <= n) {

            if ( arraySum(Decomposition10.getArrayFromNumber(i)) == k) array = addElement(array, i); 
            i++;

        }

        return array;

    }

    public static void main(String[] args) {

        Sort1.printArray(
            generateArray(12, 1000)
        );

    }
    
}
