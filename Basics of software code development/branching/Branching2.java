import java.util.Scanner;

public class Branching2 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("a, b, c, d: ");
			int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();
			System.out.println(Math.max(Math.min(a, b), Math.min(c, d)));
        }
}
