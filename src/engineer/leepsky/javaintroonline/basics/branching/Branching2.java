package engineer.leepsky.javaintroonline.basics.branching;

import java.util.Scanner;

public class Branching2 {

	/* Найти max{min(a, b), min(c, d)} */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("a, b, c, d: ");
			int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();
			System.out.println(Math.max(Math.min(a, b), Math.min(c, d)));
			in.close();
        }
}
