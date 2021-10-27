import java.util.Scanner;

public class Linear5 {
	public static void main(String[] args) {
        	Scanner in = new Scanner(System.in);
			System.out.print("T: ");
			int t = in.nextInt();
			System.out.format("%02dч %02dмин %02dс\n", t / 3600, (t % 3600) / 60, (t % 3600) % 60);
			in.close();
        }
}
