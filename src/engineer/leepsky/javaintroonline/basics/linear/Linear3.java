package engineer.leepsky.javaintroonline.basics.linear;

import java.util.Scanner;

public class Linear3 {

	/* Вычислить значение выражения по формуле (все переменные принимают действительные значения):
	   ((sinx + cosx)/(cosx-siny)) * tg(x*y) */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("x, y: ");
			double x = in.nextDouble(), y = in.nextDouble();
			System.out.println(
					(Math.sin(x) + Math.cos(y))/(Math.cos(x) - Math.sin(x)) * Math.tan(x * y)
			);
			in.close();
        }
}
