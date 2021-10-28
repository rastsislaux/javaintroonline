package engineer.leepsky.javaintroonline.basics.linear;

import java.util.Scanner;

public class Linear4 {

	/* Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
	   дробную и целую части числа и вывести полученное значение числа. */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("r: ");
			double r = in.nextDouble(), x = (1000*r - 1000*Math.floor(r)) + Math.floor(r)/1000;
			System.out.println(x);
			in.close();
        }
}
