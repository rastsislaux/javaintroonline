package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles2 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("a, b, h: ");
			int a = in.nextInt(), b = in.nextInt(), h = in.nextInt();
			for (int x = a; x < b; x += h)
				System.out.format("x = %d, y = %d\n", x, x > 2 ? x : -x);
			in.close();
        }
}
