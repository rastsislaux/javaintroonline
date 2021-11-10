package engineer.leepsky.javaintroonline.basics.linear;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Linear5 {

	/* Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
	   данное значение длительности в часах, минутах и секундах в следующей форме:
	   ННч ММмин SSc. */

	public static void main(String[] args) {
			try {
				Scanner in = new Scanner(System.in);
				System.out.print("T: ");
				int t = in.nextInt();
				System.out.format("%02dч %02dмин %02dс\n", t / 3600, (t % 3600) / 60, (t % 3600) % 60);
				in.close();
			} catch (InputMismatchException e) {
				System.out.println("\nInput error! " + e.getMessage());
			}
        }
}
