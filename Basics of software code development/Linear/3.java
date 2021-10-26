import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("x, y: ");
			double x = in.nextDouble(), y = in.nextDouble();
			System.out.println(
					(Math.sin(x) + Math.cos(y))/(Math.cos(x) - Math.sin(x)) * Math.tan(x * y)
			);
        }
}
