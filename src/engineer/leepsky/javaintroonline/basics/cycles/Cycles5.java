package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles5 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("e: ");
			double a; int n = 1; double e = in.nextDouble(), sum = 0;
			do {
				a = (1/Math.pow(2, n))+(1/Math.pow(3, n));
				sum += a;
				n++;
			} while (Math.abs(a) >= e);
			System.out.println(sum);
			in.close();
        }
}
