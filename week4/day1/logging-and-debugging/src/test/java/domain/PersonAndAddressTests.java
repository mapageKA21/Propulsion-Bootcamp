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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author Sam Brannen
 */
public class PersonAndAddressTests {

	private final Address address1 = new Address("Hauptstrasse 1", 8001, "Zurich");
	private final Address address2 = new Address("Hauptstrasse 1", 8001, "Zurich");
	private final Address address3 = new Address("Hauptstrasse 33", 8001, "Zurich");

	private final Person person1 = new Person("John", "smith", address1);
	private final Person person2 = new Person("John", "smith", address2);
	private final Person person3 = new Person("Jane", "Doe", address3);

	@Test
	public void person() {
		// getters
		assertThat(person1.getFirstName()).isEqualTo("John");
		assertThat(person1.getAddress()).isEqualTo(address1);

		// equals()
		assertThat(person1).isEqualTo(person2);
		assertThat(person1).isNotEqualTo(person3);

		// hashCode()
		assertThat(person1.hashCode()).isEqualTo(person2.hashCode());

		// toString()
		assertThat(person1.toString()).isEqualTo(person2.toString());
	}

	@Test
	public void address() {
		// getters
		assertThat(address1.getCity()).isEqualTo("Zurich");

		// equals()
		assertThat(address1).isEqualTo(address2);
		assertThat(address1).isNotEqualTo(address3);

		// hashCode()
		assertThat(address1.hashCode()).isEqualTo(address2.hashCode());

		// toString()
		assertThat(address1.toString()).isEqualTo(address2.toString());
	}

}
