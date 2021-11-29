package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition6 {

    /* Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми. */

    public static boolean isCoprime(int a, int b, int c) {

        return Decomposition1.gcd(a, b) == 1 && Decomposition1.gcd(b, c) == 1 && Decomposition1.gcd(a, c) == 1;

    }

    public static void main(String[] args) {

        System.out.println(
                isCoprime(2, 3, 11)
            );

    }
    
}
