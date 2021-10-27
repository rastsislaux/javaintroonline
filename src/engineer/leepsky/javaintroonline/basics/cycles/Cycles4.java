package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles4 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			int n = 200;
			long sum = 1;
			for (int i = 1; i <= n; i++)
				sum *= Math.pow(i, 2);
			System.out.println(sum);
			in.close();
        }
}
