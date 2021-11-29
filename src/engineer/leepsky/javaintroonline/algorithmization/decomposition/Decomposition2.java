package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition2 {

    /* Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел. */

    public static int gcd4 (int a, int b, int c, int d) {

        return Decomposition1.gcd(Decomposition1.gcd(a, b), Decomposition1.gcd(c, d));

    }

    public static void main(String[] args) {

        System.out.println(gcd4(50, 250, 225, 550));

    }
    
}
