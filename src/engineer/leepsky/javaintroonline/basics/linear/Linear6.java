package engineer.leepsky.javaintroonline.basics.linear;

import java.util.Scanner;

public class Linear6 {

	/* Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
	   принадлежит закрашенной области, и false — в противном случае. */
	   
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("x, y: ");
			int x = in.nextInt(), y = in.nextInt();
			System.out.println(
					((x >= -2) && (x <= 2) && (y >= 0) && (y <= 4)) || ((x >= -4) && (x <= 4) && (y <= 0) && (y >= -3))
					);
			in.close();
        }
}
