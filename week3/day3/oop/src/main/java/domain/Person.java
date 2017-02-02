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

package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * What are the "is a" and "has a" relationships?
 *
 * <p>is-a: A Person is an Animal.
 * <p>is-a: A Pet is an Animal.
 * <p>has-a: A Person has Pets.
 *
 * @author Sam Brannen
 */
public class Person implements Animal {

	private final String firstName;
	private final String lastName;
	private final int age;
	private final List<Pet> pets = new ArrayList<>();

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String speak() {
		return "Hi";
	}

	@Override
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getAge() {
		return this.age;
	}

	public List<Pet> getPets() {
		return this.pets;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + ", pets="
				+ this.pets + "]";
	}

}
