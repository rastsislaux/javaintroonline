package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cycles4 {

	/* Составить программу нахождения произведения квадратов первых двухсот чисел. */

	public static void main(String[] args) {
			try {
				Scanner in = new Scanner(System.in);
				int n = 200;
				long sum = 1;
				for (int i = 1; i <= n; i++)
					sum *= Math.pow(i, 2);
				System.out.println(sum);
				in.close();
			} catch (InputMismatchException e) {
				System.out.println("\nInput error! " + e.getMessage());
			}
        }
}
