package engineer.leepsky.javaintroonline.algorithmization.decomposition;

import engineer.leepsky.javaintroonline.algorithmization.sort.Sort1;

public class Decomposition14 {
    
    /* Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
       возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
       использовать декомпозицию. */

    public static boolean isArmstrong(int n) {

        long[] digits = Decomposition10.getArrayFromNumber(n);

        if (Math.pow(Decomposition12.arraySum(digits), digits.length) == n) return true;

        return false;

    }

    public static int[] getArmstrongNumbers(int k) {

        int[] armstrongNumbers = new int[0];

        for (int i = 1; i <= k; i++) {

            if ( isArmstrong(i) ) armstrongNumbers = Decomposition12.addElement(armstrongNumbers, i);

        }

        return armstrongNumbers;

    }

    public static void main(String[] args) {

        int k = 1000;

        Sort1.printArray(
            getArmstrongNumbers(k)
        );

    }

}
