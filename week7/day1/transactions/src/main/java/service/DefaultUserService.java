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

package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.User;
import repository.UserRepository;

/**
 * @author Sam Brannen
 */
@Service
@Transactional(readOnly = true)
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public DefaultUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Integer id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	@Transactional(readOnly = false)
	public void registerNewUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Integer id) {
		this.userRepository.deleteById(id);
	}

}
