
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

/**
 * @author Sam Brannen
 */
public class HelloJUnit {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Rule
	public Timeout globalTimeout = new Timeout(20, TimeUnit.MILLISECONDS);

	@Test
	public void run1() throws InterruptedException {
		Thread.sleep(10);
	}

	@Test
	public void myFirstTest() {

		// assertEquals("1 == 2?", 1, 2);
		assertTrue(2 == 4 / 2);

		String foo = new String("foo");
		String bar = new String("foo");

		assertEquals(foo, bar);
		assertSame(foo, foo);
	}

	@Test
	public void addTwoNumbers() {
		assertEquals(5, add(2, 3));
		assertNotEquals(5, add(2, 2));
	}

	@Test
	public void divideByZero() {
		exception.expect(ArithmeticException.class);
		exception.expectMessage("/ by zero");

		blowUP();
	}

	private int blowUP() {
		return 2 / 0;
	}

	private int add(int x, int y) {
		return x + y;
	}

}
