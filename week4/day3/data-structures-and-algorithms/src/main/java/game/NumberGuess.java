/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package game;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Sam Brannen
 */
public class NumberGuess {

	public static void main(String[] args) throws Exception {

		Random random = new Random(System.currentTimeMillis());
		int number = random.nextInt(10) + 1;
		int count = 0;

		System.out.println("I'm thinking of a random number from 1 to 10.");

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				count++;

				System.out.print("Guess what it is: ");

				int guess = scanner.nextInt();
				scanner.nextLine();
				System.out.println();
				if (guess == number) {
					System.out.format("Congratulations! You guessed it in %d tries.", count);
					System.exit(0);
				}
				else if (number < guess) {
					System.out.println("Nope. It's lower than that. Try again.");
				}
				else {
					System.out.println("Nope. It's higher than that. Try again.");
				}
			}
		}
	}

}
