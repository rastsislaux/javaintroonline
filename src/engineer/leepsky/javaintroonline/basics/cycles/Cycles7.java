package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles7 {

	/* Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
	   m и n вводятся с клавиатуры. */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("m, n: ");
			int m = in.nextInt(), n = in.nextInt();
			for(int i = m; i <= n; i++)
				for (int j = 2; j < i; j++)
					if ((i % j) == 0) System.out.format("Делитель %d - %d\n", i, j);
			in.close();
        }
}
