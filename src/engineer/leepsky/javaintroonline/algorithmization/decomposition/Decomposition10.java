package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition10 {

    /* Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
       являются цифры числа N. */

    public static void printArray(long[] array) {

        for (long e : array) System.out.print(e + " ");
        System.out.println();

    }

    public static int getCountOfDigits(long number) { return (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5)); }

    public static long[] getArrayFromNumber(long number)
    {

        int countOfDigits = getCountOfDigits(number);

        long[] result = new long[countOfDigits];

        for (int i = 0; i < countOfDigits; i++) {

            result[i] = number / (long)Math.pow(10, countOfDigits - i - 1);
            number -= result[i] * (long)Math.pow(10, countOfDigits - i - 1);

        }

        return result;

    }

    public static void main(String[] args) {

        printArray(
            getArrayFromNumber(37529222)
        );

    }
    
}
