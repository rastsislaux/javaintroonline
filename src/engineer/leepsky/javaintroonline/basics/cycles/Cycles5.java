package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cycles5 {

	/* Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
	   заданному е. Общий член ряда имеет вид:
	   a_n-1/2^n +1/3^n */

	public static void main(String[] args) {
			try {
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
			} catch (InputMismatchException e) {
				System.out.println("\nInput error! " + e.getMessage());
			}
        }
}
