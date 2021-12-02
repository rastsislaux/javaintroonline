package engineer.leepsky.javaintroonline.algorithmization.decomposition;

import engineer.leepsky.javaintroonline.algorithmization.sort.Sort1;

public class Decomposition13 {

    /* Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
       Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
       решения задачи использовать декомпозицию. */

    public static boolean isPrime(int n) {

        for (int i = 2; i*i < n; i += 2)
            if (n % i == 0) return false;
        return true;

    }

    public static int[] getPrimeNumbers(int n) {
        
        int primes[] = new int[0];

        for (int i = n; i <= 2*n; i++)
            if ( isPrime(i) ) primes = Decomposition12.addElement(primes, i);

        return primes;

    }

    public static void main(String[] args) {

        int n = 10;

        Sort1.printArray(
            getPrimeNumbers(n)
        );

    }
    
}
