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

import java.util.Arrays;
import java.util.Random;

/**
 * @author Sam Brannen
 */
public class NeedleInHaystack {

	private static final int NEEDLE = 4000; // 42;
	private static final int HAYSTACK_SIZE = 100; // 10;

	private static final Random random = new Random(System.currentTimeMillis());

	private static int numStepsInAlgorithm = 0;

	public static void main(String[] args) throws Exception {
		int[] haystack = new int[HAYSTACK_SIZE];

		// Add needle to haystack
		haystack[0] = NEEDLE;

		// Add random numbers to haystack
		for (int i = 1; i < haystack.length; i++) {
			haystack[i] = random.nextInt(HAYSTACK_SIZE * HAYSTACK_SIZE) + 1;
		}

		Arrays.sort(haystack);

		System.out.println("Needle:   " + NEEDLE);
		System.out.println("Haystack: " + Arrays.toString(haystack));
		System.out.println();

		final int index = findNeedleInHaystack(NEEDLE, haystack);
		if (haystack[index] != NEEDLE) {
			System.out.println("ERROR: Needle is NOT at index: " + index);
		}
		else {
			System.out.println("Found needle at index: " + index);
		}

		System.out.println();
		System.out.println("Algorithm took " + numStepsInAlgorithm + " steps.");
	}

	/**
	 * Finds the index of the needle in the haystack.
	 */
	public static int findNeedleInHaystack(int needle, int[] haystack) {
		// return findNeedleInHaystackUsingBruteForce(needle, haystack);
		return findNeedleInHaystackUsingDivideAndConquer(needle, haystack);
	}

	public static int findNeedleInHaystackUsingBruteForce(int needle, int[] haystack) {
		for (int i = 0; i < haystack.length; i++) {
			numStepsInAlgorithm++;
			if (haystack[i] == needle) {
				return i;
			}
		}

		throw new IllegalArgumentException("Supplied haystack does not contain needle");
	}

	public static int findNeedleInHaystackUsingDivideAndConquer(int needle, int[] haystack) {

		int lowIndex = 0;
		int highIndex = haystack.length - 1;

		while (lowIndex <= highIndex) {
			numStepsInAlgorithm++;
			int middleIndex = (lowIndex + highIndex) / 2;
			int current = haystack[middleIndex];
			if (needle == current) {
				return middleIndex;
			}
			else if (needle < current) {
				highIndex = middleIndex - 1;
			}
			else {
				lowIndex = middleIndex + 1;
			}
		}

		throw new IllegalArgumentException("Supplied haystack does not contain needle");
	}

}
