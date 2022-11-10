import java.util.Scanner;

public class Umpire {
	int numFromGuesser;
	int[] numFromPlayers;

	public static void main(String[] args) {

		Umpire u = new Umpire();

		// Now Guesser guess the number
		Guesser guesser = new Guesser();
		u.numFromGuesser = guesser.getNumberFromGuesser();

		// Now Players guess the number
		System.out.println("Enter the numbers of players");
		int noOfPlayers = new Scanner(System.in).nextInt();
		Players players = new Players(noOfPlayers);
		u.numFromPlayers = players.getNumberFromPlayers();

		// Now compare the numbers
		u.compareResult();
	}

	public void compareResult() {

		boolean flag = false;
		
		for (int i = 0; i < numFromPlayers.length; i++) {
			if (numFromPlayers[i] == numFromGuesser) {
				flag = true;
				System.out.println("Players " + (i + 1) + " won the match");
			}
		}
		
		if (!flag)
			System.out.println("No player won the match");
		else
			return;
	}

}

class Guesser {
	int guesserNumber;

	public int getNumberFromGuesser() {

		System.out.println("Guesser guess any number");
		guesserNumber = new Scanner(System.in).nextInt();
		return guesserNumber;
	}

}

class Players {

	int noOfPlayers;

	public Players(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public int[] getNumberFromPlayers() {

		int[] players = new int[noOfPlayers];
		
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Players " + (i + 1) + " guess the number");
			players[i] = new Scanner(System.in).nextInt();
		}
		return players;
	}
}
