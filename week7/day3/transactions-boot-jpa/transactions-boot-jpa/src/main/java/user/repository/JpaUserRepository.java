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

package user.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import user.domain.User;

/**
 * @author Sam Brannen
 */
@Repository
public class JpaUserRepository implements UserRepository {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public long count() {
		String query = "select count(*) from User";

		long count = this.entityManager
		  .createQuery(query, Long.class)
		  .getSingleResult();
		return count;
	}

	@Override
	public void save(User user) {
		this.entityManager.persist(user);
	}

	@Override
	public List<User> findAll() {
		List<User> users = this.entityManager
				  .createQuery("from User", User.class)
				  .getResultList();
		return users;
	}

	@Override
	public User findById(Long id) {
		User user = this.entityManager.find(User.class, id);
		return user;
	}
	
	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		String query =
		"from User user where user.firstName = :firstName and userLast_name = :lastName";
		User user = this.entityManager.createQuery(query, User.class)
				.setParameter("firstName", firstName)
				.setParameter("lastName", lastName)
				.getSingleResult();
		return user;
	}

	@Override
	public void deleteAll() {
		this.entityManager
		.createQuery("delete from User")
		.executeUpdate();
		
	}

	@Override
	public void deleteById(Long id) {
		String query = "delete from User user where user.id = :id";

		this.entityManager.createQuery(query)
		  .setParameter("id", id)
		  .executeUpdate();
		
	}

//	@Autowired
//	public JpaUserRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public long count() {
//		return jdbcTemplate.queryForObject("select count(*) from users", Long.class);
//	}
//
//	@Override
//	public void save(User user) {
//		String sql = "insert into users(first_name, last_name, age) values(?,?,?)";
//		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getAge());
//	}
//
//	@Override
//	public List<User> findAll() {
//		return jdbcTemplate.query("select * from users", userMapper);
//	}
//
//	@Override
//	public User findById(Long id) {
//		String sql = "select * from users where id=?";
//		return jdbcTemplate.queryForObject(sql, userMapper, id);
//	}
//
//	@Override
//	public User findByFirstNameAndLastName(String firstName, String lastName) {
//		String sql = "select * from users where first_name=? and last_name=?";
//		return jdbcTemplate.queryForObject(sql, userMapper, firstName, lastName);
//	}
//
//	@Override
//	public void deleteAll() {
//		jdbcTemplate.update("delete from users");
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		jdbcTemplate.update("delete from users where id=?", id);
//	}

}
