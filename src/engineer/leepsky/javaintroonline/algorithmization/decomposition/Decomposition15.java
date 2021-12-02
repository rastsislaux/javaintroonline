package engineer.leepsky.javaintroonline.algorithmization.decomposition;

import engineer.leepsky.javaintroonline.algorithmization.sort.Sort1;

public class Decomposition15 {

    /* Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
       последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию. */

    public static int getFirstNSized(int d) { return (int)Math.pow(10, d-1); }

    public static int getLastNSized(int d) { return (int)Math.pow(10, d) - 1;  }

    public static boolean isIncreasing(int number) {

        long[] array = Decomposition10.getArrayFromNumber(number);

        for (int i = 1; i < array.length; i++)
            if ( array[i] <= array[i-1] ) return false;

        return true;

    }

    public static int[] getIncreasingNumbers(int d) {

        int[] array = new int[0];

        for (int i = getFirstNSized(d); i <= getLastNSized(d); i++)
            if ( isIncreasing(i) )
                array = Decomposition12.addElement(array, i);

        return array;

    }

    public static void main(String[] args) {

        int d = 4;

        Sort1.printArray(
            getIncreasingNumbers(d)
        );

    }
    
}
