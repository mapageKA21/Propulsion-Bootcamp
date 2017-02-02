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

package service;

import static enums.Color.*;
import static enums.Size.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Product;

/**
 * Unit tests for {@link PriceCalculator}.
 *
 * @author Sam Brannen
 */
public class PriceCalculatorTests {

	@Test
	public void priceCalculations() {
		PriceCalculator calculator = new PriceCalculator();

		Product s = new Product("t-shirt", BLUE, S, 10);
		Product m = new Product("t-shirt", RED, M, 10);
		Product l = new Product("t-shirt", GREEN, L, 10);
		Product xl = new Product("t-shirt", BLACK, XL, 10);
		Product xxl = new Product("t-shirt", GREEN, XXL, 10);

		assertEquals(10, calculator.calculatePrice(s), 0);
		assertEquals(10, calculator.calculatePrice(m), 0);
		assertEquals(10, calculator.calculatePrice(l), 0);
		assertEquals(10.5, calculator.calculatePrice(xl), 0);
		assertEquals(11, calculator.calculatePrice(xxl), 0);
	}

}
