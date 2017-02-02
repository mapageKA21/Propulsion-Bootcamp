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

/**
 * @author Sam Brannen
 */
public class NumberDemo {

	public static void main(String[] args) {

		Number x = new Integer(5);
		Number y = new Double(2.4);

		System.out.println(x.toString());

		//		if (x instanceof Object) {
		//			System.out.println("Object!");
		//		}
		//
		//		if (x instanceof Number) {
		//			System.out.println("Number!");
		//		}

		if (x instanceof Integer) {
			System.out.println("Integer!");

			Integer i = (Integer) x;
			i.shortValue();

		}

		// Throws:
		// java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
		//
		// Double d = (Double) x;

		x.doubleValue();
		y.doubleValue();

	}
}
