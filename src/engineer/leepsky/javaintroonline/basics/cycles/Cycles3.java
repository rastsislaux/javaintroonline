package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles3 {

	/* Найти сумму квадратов первых ста чисел. */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			int n = 100, sum = 0;
			System.out.println((n*(n+1)*(2*n+1))/6);
			// or
			for (int i = 1; i <= n; i++)
				sum += i*i;
			System.out.println(sum);
			in.close();
        }
}
