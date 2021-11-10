package engineer.leepsky.javaintroonline.basics.branching;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Branching4 {

	/* Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
	   отверстие. */

	public static void main(String[] args) {
			try {
				Scanner in = new Scanner(System.in);
				System.out.print("a, b, x, y, z: ");
				int a = in.nextInt(), b = in.nextInt(), x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
				System.out.println((a*b > x*y) && (a*b > y*z) && (a*b > z*x));
				in.close();
			} catch (InputMismatchException e) {
				System.out.println("\nInput error: " + e.getMessage());
			}
        }
}
