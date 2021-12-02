package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition16 {

    /* Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
       Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию. */

    public static int getEvenCount(int number) {

        long[] array = Decomposition10.getArrayFromNumber(number);

        int result = 0;

        for (int i = 0; i < array.length; i++)
            if (array[i] % 2 == 0) result++;

        return result;

    }

    public static int[] getNumbersWithUnevenDigits(int d) {

        int[] array = new int[0];

        for (int i = Decomposition15.getFirstNSized(d); i <= Decomposition15.getLastNSized(d); i++) {

            if ( getEvenCount(i) == 0 ) array = Decomposition12.addElement(array, i);

        }

        return array;

    }

    public static int intArraySum(int[] array) {

        int sum = 0;

        for (int a : array) {

            sum += a;

        }

        return sum;

    }

    public static void main(String[] args) {

        int d = 4;

        int sum = intArraySum(
            getNumbersWithUnevenDigits(d)
        );

        System.out.println(
             sum + " " + getEvenCount(sum)
        );

    }
    
}
