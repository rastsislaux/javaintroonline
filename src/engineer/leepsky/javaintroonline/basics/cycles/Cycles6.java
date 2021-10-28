package engineer.leepsky.javaintroonline.basics.cycles;

import java.util.Scanner;

public class Cycles6 {

	/* Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера */

	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			for (int i = 33; i <= 126; i++)
            	System.out.format("%d - %c\n", i, i);
			in.close();
        }
}
