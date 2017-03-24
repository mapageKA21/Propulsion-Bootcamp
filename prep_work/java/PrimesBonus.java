
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

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Prints out the first 20 prime numbers.
 *
 * @author Sam Brannen
 */
public class PrimesBonus {

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		// Simplistic solution
		/*
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		*/

		// Bonus: more efficient solution
		for (int i = 2; i <= (n / 2); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// @formatter:off
		int[] primes = IntStream.iterate(1, n -> n + 1)
				.filter(PrimesBonus::isPrime)
				.limit(20)
				.toArray();
		// @formatter:on

		// [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71]
		System.out.println(Arrays.toString(primes));
	}

}
