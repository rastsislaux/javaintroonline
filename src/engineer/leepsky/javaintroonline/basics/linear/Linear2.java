import java.util.Scanner;

public class Linear2 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
        	System.out.print("a, b, c: ");
			double a = in.nextDouble(), b = in.nextDouble(), c = in.nextDouble();
			System.out.println(
					((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / 2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2)
			);
			in.close();
        }
}
