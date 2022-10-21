
public class Question_4 {

	public static void main(String[] args) {

		int n = 15;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i >= n / 2 && i < n - 2) && (j <= (i - n / 2) || j >= ((3 * n) / 2 - i - 1)))
					System.out.print("*");
				else if (i >= n - 2)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
