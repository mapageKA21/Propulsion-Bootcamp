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

import java.util.HashSet;
import java.util.Set;

import domain.Animal;
import domain.Bird;
import domain.Cat;
import domain.Dog;

/**
 * @author Sam Brannen
 */
public class AnimalsDemo {

	public static void main(String[] args) {
		// List<Animal> animals = new ArrayList<>();
		Set<Animal> animals = new HashSet<>();

		animals.add(new Dog("Sparky"));
		animals.add(new Cat("Garfield"));
		animals.add(new Bird("Tweetie"));
		animals.add(new Dog("Sparky"));

		System.out.println("Animals: " + animals);

	}
}
