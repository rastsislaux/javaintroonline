package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cycles8 {

	/* Даны два числа. Определить цифры, входящие в запись как первого так и второго числа. */

	public static void main(String[] args) {
			try {
				Scanner in = new Scanner(System.in);
				System.out.print("a, b: ");
				int a = in.nextInt(), b = in.nextInt();
				for(int x = a; x > 0; x /= 10)
					for(int y = b; y > 0; y /= 10)
						if (x % 10 == y % 10) {
							System.out.print(x % 10);
							System.out.print(" ");
						}
				System.out.println();
				in.close();
			} catch (InputMismatchException e) {
				System.out.println("\nInput error! " + e.getMessage());
			}
        }
}
