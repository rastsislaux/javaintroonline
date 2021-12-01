package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition7 {

    /* Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9. */

    static double factorial(int number) {

        if (number == 0) return 1;

        return number * factorial(number - 1);

    }

    static double factorialSum() {

        double sum = 0;

        for (int i = 1; i <= 9; i += 2) {

            sum += factorial(i);

        }

        return sum;

    } 

    public static void main(String[] args) {

        System.out.println(factorialSum());

    }
    
}
