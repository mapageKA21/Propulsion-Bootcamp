import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random(System.currentTimeMillis());
		int number = random.nextInt(10) + 1;
		int guesses = 1;
		
		System.out.println("I'm thinking of a random number from 1 to 10.");
		
		Scanner scanner = new Scanner(System.in);
		
		while (number > 0) {
			System.out.println("Guess what it is");
			int userGuess = scanner.nextInt();
			if (userGuess == number) {
				System.out.println("Congrats! You guessed in "+ guesses + " tries!");
				number = 0;
				System.exit(0);
			}
			else if (userGuess < number) {
				System.out.println("Nope. It's higher than that. Try again.");
				guesses++;
			}
			else {
				System.out.println("Nope. It's lower than that. Try again.");
				guesses++;
			}
		}
	}
}
