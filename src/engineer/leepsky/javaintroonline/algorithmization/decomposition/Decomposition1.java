package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition1 {

    /* Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
       натуральных чисел: НОК(A, B) = (A*B / НОД(A,B)) */

       public static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a%b); }
       
       public static int lcm(int a, int b) { return (a*b)/gcd(a, b); }

       public static void main(String[] args) {

            int a = 6, b = 4;
            System.out.println("lcm(a, b) = " + lcm(a, b) + ", gcd(a, b) = " + gcd(a,b));

       }

}
