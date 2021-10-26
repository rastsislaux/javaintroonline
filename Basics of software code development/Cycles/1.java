import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("n: ");
			int n = in.nextInt(), sum = 0;
			for (int i = 1; i <= n; i++)
				sum += i;
			System.out.println(sum);
        }
}
