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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Address;
import domain.Person;

/**
 * @author Sam Brannen
 */
public class PersonDemo {

	public static void main(String[] args) {

		Address address1 = new Address("Hauptstrasse 1", 8001, "Zurich");
		Address address2 = new Address("Hauptstrasse 1", 8001, "Zurich");
		Address address3 = new Address("Hauptstrasse 33", 8001, "Winterthur");

		Person person1 = new Person("John", "Smith", address1);
		Person person2 = new Person("John", "Smith", address2);
		Person person3 = new Person("Jane", "Doe", address3);

		// ---------------------------------------------------------------------
		banner("List");
		List<Person> peopleList = Arrays.asList(person1, person2, person3);

		// peopleList.forEach(person -> System.out.println(person));
		peopleList.forEach(System.out::println);
		peopleList.forEach(person -> System.out.println(person.getAddress().getStreet()));

		// ---------------------------------------------------------------------
		banner("Set");

		Set<Person> peopleSet = new HashSet<>();
		peopleSet.add(person1);
		peopleSet.add(person2);
		peopleSet.add(person3);

		peopleSet.forEach(person -> System.out.println(person));

		// ---------------------------------------------------------------------
		banner("Map");

		Map<String, Person> peopleMap = new HashMap<>();
		peopleMap.put(person1.getLastName(), person1);
		peopleMap.put(person2.getLastName(), person2);
		peopleMap.put(person3.getLastName(), person3);

		//		peopleMap.forEach((lastName, person) -> {
		//			System.out.println(lastName + ": " + person);
		//		});
		peopleMap.forEach((lastName, person) -> System.out.println(lastName + ": " + person));

		// ---------------------------------------------------------------------
		banner("Mapping and Filtering");

		// @formatter:off
		Stream.of(person1, person2, person3)
			.map(p -> p.getAddress())
			.filter(a -> a.getCity().equals("Zurich"))
			.limit(10)
			.forEach(System.out::println);
		// @formatter:on

		// ---------------------------------------------------------------------
		banner("Collecting");

		// @formatter:off
		List<Address> addressesInZurich =
				Stream.of(person1, person2, person3)
					.map(p -> p.getAddress())
					.filter(a -> a.getCity().equals("Zurich"))
					.collect(Collectors.toList());
		System.out.println(addressesInZurich);
		// @formatter:on

		// ---------------------------------------------------------------------
		banner("Grouping");

		// @formatter:off
		Map<String, List<Person>> peopleByCity =
			peopleList.stream()
				.collect(Collectors.groupingBy(p -> p.getAddress().getCity()));
		// @formatter:on

		peopleByCity.forEach((city, person) -> System.out.println(city + ": " + person));
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
