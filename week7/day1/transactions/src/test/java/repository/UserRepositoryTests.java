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

package repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import config.RepositoryConfig;
import config.TestDataAccessConfig;
import domain.User;

/**
 * @author Sam Brannen
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RepositoryConfig.class, TestDataAccessConfig.class })
@ActiveProfiles("dev")
@Sql("/test-data.sql")
//@Sql(scripts = "/delete-test-data.sql", executionPhase = AFTER_TEST_METHOD)
@Transactional
public class UserRepositoryTests {

	@Autowired
	UserRepository repository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void before(){
		System.out.println("before executing");
	}
	
	@BeforeTransaction
	public void beforeTransaction(){
		System.out.println("before Transaction executing");
	}
	
	@AfterTransaction
	public void afterTransaction(){
		System.out.println("after Transaction executing");
	}
	
	//	@Before
	//	public void clearUserTable() {
	//		repository.deleteAll();
	//	}

	@Test
	//@Sql(statements = "delete from users")
	public void count() {

		assertThat(numUsers()).isEqualTo(1);

		assertThat(repository.count()).isEqualTo(1);
		// assertThat(repository.count()).isEqualTo(1);
	}

	@Test
	// @Sql(statements = "insert into users(first_name, last_name, age) values('John', 'Smith', 42)")
	public void save() {
		// saveJohnSmith();
		assertThat(repository.count()).isEqualTo(1);
	}

	@Test
	public void findById() {
		// saveJohnSmith();
		User user = repository.findByFirstNameAndLastName("John", "Smith");
		user = repository.findById(user.getId());
		assertThat(user.getFirstName()).isEqualTo("John");
	}

	@Test
	public void findByFirstNameAndLastName() {
		// saveJohnSmith();
		User user = repository.findByFirstNameAndLastName("John", "Smith");
		assertThat(user.getFirstName()).isEqualTo("John");
		assertThat(user.getLastName()).isEqualTo("Smith");
	}

	@Test
	public void findAll() {
		// saveJohnSmith();
		saveJaneDoe();
		assertThat(repository.count()).isEqualTo(2);
	}

	@Test
	public void deleteById() {
		// saveJohnSmith();
		assertThat(repository.count()).isEqualTo(1);
		User user = repository.findByFirstNameAndLastName("John", "Smith");
		repository.deleteById(user.getId());
		assertThat(repository.count()).isEqualTo(0);
	}

	@SuppressWarnings("unused")
	private void saveJohnSmith() {
		repository.save(new User("John", "Smith", 42));
	}

	private void saveJaneDoe() {
		repository.save(new User("Jane", "Doe", 38));
	}

	private int numUsers() {
		return JdbcTestUtils.countRowsInTable(jdbcTemplate, "users");
	}

}
