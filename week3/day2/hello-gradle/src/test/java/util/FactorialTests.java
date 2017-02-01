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

import static org.junit.Assert.assertEquals;
import static util.Factorial.factorial;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Sam Brannen
 */
public class FactorialTests {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void knownValues() {
		assertEquals(1, factorial(0));
		assertEquals(1, factorial(1));
		assertEquals(2, factorial(2));
		assertEquals(6, factorial(3));
		assertEquals(24, factorial(4));
		assertEquals(120, factorial(5));
	}

	@Test
	public void negativeValue() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Only positive");

		// factorial(-1);
		factorial(Integer.MIN_VALUE);
	}

}
