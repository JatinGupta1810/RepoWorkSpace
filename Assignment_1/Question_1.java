
public class Question_1 {

	public static void main(String[] args) {

		int column = 194;
		int row = 11;

		for (int i = 0; i < row; i++) {

			for (int k = 0; k <= column; k++) {

				// for printing "J"
				if (k >= 0 && k < 11) {
					int j = 11;
					int median = (0 + j) / 2;
					if (i == 0 || (k == median) || (i >= row / 2 && k == (i - row / 2) && (i - (row + 1) / 2) < median))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "A"
				else if (k >= 16 && k < 27) {
					int j = 27;
					if (i != 0 && (k == 16 || k == j - 1 || i == row / 2))
						System.out.print("*");
					else if (i == 0 && (k > 16 && k < j - 1))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "T"
				else if (k >= 33 && k < 44) {
					int j = 44;
					int median = (33 + j) / 2;
					if (k == median || i == 0)
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "I"
				else if (k >= 49 && k < 60) {
					int j = 60;
					int median = (49 + j) / 2;
					if (k == median || i == 0 || i == row - 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "N"
				else if (k >= 65 && k < 76) {
					int j = 76;
					if (k == 65 || k == (j - 1) || k == (i + 65))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// Now print iNEURON

				// for printing "I"
				else if (k >= 96 && k < 97) {
					int j = 97;
					if (k == 96)
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "N"
				else if (k >= 103 && k < 114) {
					int j = 114;
					if (k == 103 || k == (j - 1) || k == (i + 103))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "E"
				else if (k >= 119 && k < 130) {
					if (k == 119 || i == 0 || i == row / 2 || i == row - 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "U"
				else if (k >= 135 && k < 146) {
					int j = 146;
					if (((k == 135 || k == j - 1) && i <= 9) || (i == row - 1 && (k > 135 && k < j - 1)))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "R"
				else if (k >= 151 && k < 162) {
					int j = 162;
					if (i <= row / 2 && (k == 151 || i == row / 2 || k == j - 1 || i == 0))
						System.out.print("*");
					else if (k == (i - row / 2 + 151) || k == 151 || (k >= 157 && i == row - 1))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "O"
				else if (k >= 167 && k < 178) {
					int j = 178;
					if ((i != 0 && i != row - 1) && (k == 167 || k == j - 1))
						System.out.print("*");
					else if ((i == 0 || i == row - 1) && (k > 167 && k < j - 1))
						System.out.print("*");
					else
						System.out.print(" ");
				}

				// for printing "N"
				else if (k >= 183 && k < 194) {
					int j = 194;
					if (k == 183 || k == (j - 1) || k == (i + 183))
						System.out.print("*");
					else
						System.out.print(" ");
				} else
					System.out.print(" ");

			}

			System.out.println();
		}

	}

}
