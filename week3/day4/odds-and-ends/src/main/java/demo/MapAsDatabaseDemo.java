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

import java.util.HashMap;
import java.util.Map;

import domain.Product;
import enums.Color;
import enums.Size;

/**
 * @author Sam Brannen
 */
public class MapAsDatabaseDemo {

	public static void main(String[] args) {

		Map<String, Product> productDatabase = new HashMap<>();

		System.out.println("1) " + productDatabase);

		Product p1 = new Product("t-shirt", Color.BLUE, Size.M, 15.50);
		Product p2 = new Product("jeans", Color.BLUE, Size.L, 95.50);

		// CREATE / SAVE
		productDatabase.put(p1.getName(), p1);
		productDatabase.put(p2.getName(), p2);

		System.out.println("2) " + productDatabase);

		// READ / find by ID
		Product retrievedJeans = productDatabase.get("jeans");

		// UPDATE
		// retrieve it first, then update.
		retrievedJeans.setColor(Color.GREEN);

		System.out.println("3) " + productDatabase);

		// DELETE
		productDatabase.remove("jeans");

		System.out.println("4) " + productDatabase);
	}

}
