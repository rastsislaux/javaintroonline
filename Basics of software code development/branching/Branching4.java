import java.util.Scanner;

public class Branching4 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("a, b, x, y, z: ");
			int a = in.nextInt(), b = in.nextInt(), x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
			System.out.println((a*b > x*y) || (a*b > y*z) || (a*b > z*x));
			in.close();
        }
}
