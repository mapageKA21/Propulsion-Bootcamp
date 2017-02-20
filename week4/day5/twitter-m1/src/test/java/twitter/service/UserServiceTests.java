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

package twitter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static twitter.domain.TestUtils.createJohnSmith;

import org.junit.Test;

import twitter.domain.User;
import twitter.repository.InMemoryUserRepository;
import twitter.repository.UserRepository;

/**
 * Unit tests for the {@link DefaultUserService}.
 *
 * @author Sam Brannen
 */
public class UserServiceTests {

	// Could use Mockito to mock the repository, but our current is an
	// in-memory "fake". So it's not such a bad idea to just use the
	// in-memory implementation directly.
	private final UserRepository repository = new InMemoryUserRepository();

	private final UserService service = new DefaultUserService(repository);

	@Test
	public void registerNewUser() {
		// Given
		assertThat(service.findAllUsers()).isEmpty();

		// When
		User user = createJohnSmith();
		service.registerNewUser(user);

		// Then
		assertThat(service.findAllUsers()).containsExactly(user);
	}

	// Omitting tests for deleteUser(), findUser(), and findAllUsers(),
	// since they currently only delegate to the repository.

}
