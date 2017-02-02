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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import generics.DataHolder;

/**
 * @author Sam Brannen
 */
public class GenericsDemo {

	public static void main(String[] args) {

		DataHolder<String> dataHolder1 = new DataHolder<>("foo");

		final String data1 = dataHolder1.getData();

		//		if (data1 instanceof String) {
		//			System.out.println(((String) data1).toUpperCase());
		//		}

		System.out.println(data1.toUpperCase());

		System.out.println(data1);

		DataHolder<Integer> dataHolder2 = new DataHolder<>(new Integer(42));

		final Integer data2 = dataHolder2.getData();

		//		if (data2 instanceof String) {
		//			// do something with text
		//		}
		//		else if (data2 instanceof Number) {
		//			// do something with number
		//		}

		System.out.println(data2);

		// List<Number> numbers = new ArrayList<>();
		List<Integer> numberList = new ArrayList<>();

		numberList.add(new Integer(42));
		// numbers.add(new Double(3.14));
		numberList.add(20000);
		numberList.add(12); // auto-boxing to Integer
		numberList.add(20000);
		Collections.sort(numberList);

		System.out.println("Number List: " + numberList);
		System.out.println("1st number: " + numberList.get(0).floatValue());

		Set<Integer> numberSet = new HashSet<>();
		numberSet.add(42);
		numberSet.add(12);
		numberSet.add(20000);
		numberSet.add(20000);

		System.out.println("Number Set: " + numberSet);

		Map<String, Integer> numberMap = new HashMap<>();
		numberMap.put("one", 1);
		numberMap.put("forty-two", 42);

		System.out.println("Number Map: " + numberMap);

	}

}
