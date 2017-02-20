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

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter.domain.User;
import twitter.repository.UserRepository;

/**
 * Default implementation of the {@link UserService} API.
 *
 * @author Sam Brannen
 */
public class DefaultUserService implements UserService {

	private static final Logger logger = LogManager.getLogger(DefaultUserService.class);

	private final UserRepository repository;

	public DefaultUserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void registerNewUser(User user) {
		logger.debug(() -> "Registering new user: " + user);
		this.repository.save(user, user.getId());
	}

	@Override
	public void deleteUser(String userId) {
		logger.debug(() -> "Deleting user with ID: " + userId);
		this.repository.deleteById(userId);
	}

	@Override
	public User findUser(String userId) {
		logger.debug(() -> "Finding user with ID: " + userId);
		return this.repository.findById(userId);
	}

	@Override
	public List<User> findAllUsers() {
		logger.debug("Finding all users");
		return this.repository.findAll();
	}

}
