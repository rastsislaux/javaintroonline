package engineer.leepsky.javaintroonline.basics.branching;

import java.util.Scanner;

public class Branching1 {

	/* Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
	   он прямоугольным. */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("a, b: ");
			int x = in.nextInt(), y = in.nextInt();
			if (x + y < 180) {
				System.out.print("Существует, ");
				System.out.println(180 - x - y == 90 ? "прямоугольный." : "непрямоугольный.");
			}
			in.close();
        }
}
