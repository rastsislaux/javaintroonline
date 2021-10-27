import java.util.Scanner;

public class Linear6 {
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
