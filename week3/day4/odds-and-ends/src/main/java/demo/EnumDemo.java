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

package demo;

import java.util.Arrays;

import enums.Cardsuite;
import enums.CssColor;

/**
 * @author Sam Brannen
 */
public class EnumDemo {

	// local, private enum:
	private enum Operator {
		PLUS, MINUS
	};

	// a constant... but not as useful as an enum:
	public static final String GREEN = "#00FF00";

	public static void main(String[] args) {

		Cardsuite cardsuite = Cardsuite.SPADES;

		Cardsuite userSuite = Cardsuite.SPADES;

		if (cardsuite == userSuite) {
			System.out.println("same suite");
		}

		switch (userSuite) {
			case CLUBS:
				System.out.println("User has clubs");
				break;
			case HEARTS:
				System.out.println("User has hearts");
				break;
			case SPADES:
				System.out.println("User has spades");
				break;
			case DIAMONDS:
				System.out.println("User has diamonds");
				break;
			default:
				throw new RuntimeException("Unsupported card suite: " + userSuite);
		}

		CssColor color = CssColor.GREEN;
		System.out.println("CSS color for green is: " + color.getHexValue());

		CssColor fromUser = CssColor.valueOf("Blue ".trim().toUpperCase());
		System.out.println("From User: " + fromUser);

		System.out.println("--------------------------------------");
		System.out.println("Available CSS colors:");
		for (CssColor cssColor : CssColor.values()) {
			System.out.println(cssColor);
		}

		System.out.println("--------------------------------------");
		System.out.println("Local Operator enum values:");
		System.out.println(Arrays.toString(Operator.values()));

	}

}
