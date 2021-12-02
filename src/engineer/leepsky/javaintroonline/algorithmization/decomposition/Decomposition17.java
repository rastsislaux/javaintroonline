package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition17 {

    /* Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
       действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию. */

    public static int countOperations(int number) {

        int k = number, i;
        int sum = Decomposition12.arraySum(
            Decomposition10.getArrayFromNumber(number)
        );

        for (i = 0; k > 0; i++) {

            k -= sum;

        }

        if (k != 0) return -1;

        return i;

    }

    public static void main(String[] args) {

        int out = countOperations(245349);

        if (out == -1) {

            System.out.println("Получить нуль невозможно.");
            return;

        }

        System.out.println(out);

    }
    
}
