package engineer.leepsky.javaintroonline.basics.branching;

import java.util.Scanner;

public class Branching5 {

	/* Вычислить значение функции:
	   если x<=3 x^2-3x+9
       если x>3 1/(x^3+6) */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("x: ");
			double x = in.nextDouble();
			System.out.println(x > 3 ? 1 / (Math.pow(x, 3) + 6) : Math.pow(x, 2) - 3 * x + 9);
			in.close();
        }
}
