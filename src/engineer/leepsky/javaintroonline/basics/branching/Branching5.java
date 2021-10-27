package engineer.leepsky.javaintroonline.basics.branching;

import java.util.Scanner;

public class Branching5 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("x: ");
			double x = in.nextDouble();
			System.out.println(x > 3 ? 1 / (Math.pow(x, 3) + 6) : Math.pow(x, 2) - 3 * x + 9);
			in.close();
        }
}
