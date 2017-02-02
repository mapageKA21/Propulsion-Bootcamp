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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for {@link Person}.
 *
 * @author Sam Brannen
 */
public class PersonTests {

	@Test
	public void test() {
		Person person = new Person("Luke", "Skywalker", 30);
		person.getPets().add(new Pet("Fido", "woof"));
		person.getPets().add(new Pet("Garfield", "meow"));

		assertEquals(2, person.getPets().size());
		assertEquals("woof", person.getPets().get(0).speak());
		assertEquals("meow", person.getPets().get(1).speak());

		// Uncomment to see results of toString() in Person.
		// System.out.println(person);
	}

}
