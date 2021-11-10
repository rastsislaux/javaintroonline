package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cycles2 {

	/* Вычислить значение функции на отрезке [a,b] c шагом h:
       x, x>2
       -x, x<=2 */

	public static void main(String[] args) {
			try {
				Scanner in = new Scanner(System.in);
				System.out.print("a, b, h: ");
				int a = in.nextInt(), b = in.nextInt(), h = in.nextInt();
				for (int x = a; x < b; x += h)
					System.out.format("x = %d, y = %d\n", x, x > 2 ? x : -x);
				in.close();
			} catch (InputMismatchException e) {
				System.out.println("\nInput error! " + e.getMessage());
			}
        }
}
