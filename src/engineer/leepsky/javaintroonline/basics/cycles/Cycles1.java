package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles1 {

	/* Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
	   все числа от 1 до введенного пользователем числа. */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("n: ");
			int n = in.nextInt(), sum = 0;
			for (int i = 1; i <= n; i++)
				sum += i;
			System.out.println(sum);
			in.close();
        }
}
