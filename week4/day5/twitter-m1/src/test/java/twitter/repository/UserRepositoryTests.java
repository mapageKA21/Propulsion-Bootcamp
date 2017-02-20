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

package twitter.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static twitter.domain.TestUtils.createJaneDoe;
import static twitter.domain.TestUtils.createJohnSmith;

import org.junit.Test;

import twitter.domain.User;

/**
 * @author Sam Brannen
 */
public class UserRepositoryTests {

	private final UserRepository repository = new InMemoryUserRepository();

	@Test
	public void save() {
		// Given
		assertThat(repository.findAll()).isEmpty();

		// When
		User user = createJohnSmith();
		repository.save(user, user.getId());

		// Then
		assertThat(repository.findAll()).containsExactly(user);
	}

	@Test
	public void findById() {
		// Given
		User user = createJohnSmith();
		assertThat(repository.findById(user.getId())).isNull();

		// When
		repository.save(user, user.getId());

		// Then
		assertThat(repository.findById(user.getId())).isEqualTo(user);
	}

	@Test
	public void findAll() {
		// Given
		User user1 = createJohnSmith();
		User user2 = createJaneDoe();

		// When
		repository.save(user1, user1.getId());
		repository.save(user2, user2.getId());

		// Then
		assertThat(repository.findAll()).containsExactlyInAnyOrder(user1, user2);
	}

	@Test
	public void deleteById() {
		// Given
		User user = createJohnSmith();
		repository.save(user, user.getId());
		assertThat(repository.findAll().size()).isEqualTo(1);

		// When
		repository.deleteById(user.getId());

		// Then
		assertThat(repository.findAll()).isEmpty();
	}

	@Test
	public void deleteAll() {
		// Given
		User user1 = createJohnSmith();
		User user2 = createJaneDoe();
		repository.save(user1, user1.getId());
		repository.save(user2, user2.getId());
		assertThat(repository.findAll().size()).isEqualTo(2);

		// When
		repository.deleteAll();

		// Then
		assertThat(repository.findAll()).isEmpty();
	}

}
