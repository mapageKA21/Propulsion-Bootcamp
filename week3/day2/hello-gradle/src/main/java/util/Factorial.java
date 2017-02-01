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

package util;

import java.util.stream.IntStream;

/**
 * @author Sam Brannen
 */
public class Factorial {

	/**
	 * Calculates factorial of {@code n}.
	 *
	 * @throws IllegalArgumentException if negative input
	 */
	static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Only positive values are permitted");
		}

		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String... args) {
		IntStream.rangeClosed(0, 5).forEach(n -> print(n));
	}

	private static void print(int n) {
		System.out.println(n + "! = " + factorial(n));
	}

}
