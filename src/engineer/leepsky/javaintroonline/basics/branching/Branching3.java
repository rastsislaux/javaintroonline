package engineer.leepsky.javaintroonline.basics.branching;

import java.util.Scanner;

public class Branching3 
{

	/* Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой. */

	public static boolean isEqual(double x, double y){
        return Math.abs(x-y) < 0.001;
    }

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("(x, y) * 3: ");
			double x1 = in.nextDouble(),
				y1 = in.nextDouble(),
				x2 = in.nextDouble(),
				y2 = in.nextDouble(),
				x3 = in.nextDouble(),
				y3 = in.nextDouble(),
				k = (y1 - y2) / (x1 - x2),
				b = y1 - k * x1;
			System.out.println(isEqual(y3, k*x3+b) ? "На одной прямой." : "На разных прямых.");
			in.close();
        }
}
