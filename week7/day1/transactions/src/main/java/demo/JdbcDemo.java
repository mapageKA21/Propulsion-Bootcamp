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

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import config.DataAccessConfig;
import domain.User;
import repository.UserMapper;

/**
 * @author Sam Brannen
 */
public class JdbcDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DataAccessConfig.class);

		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

		// Start by emptying the table; only for demo/testing purposes
		jdbcTemplate.update("truncate table users");

		String sql = "select count(*) from users";
		Integer numUsers = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("Number of users: " + numUsers);

		sql = "insert into users(first_name, last_name, age) values(?,?,?)";
		jdbcTemplate.update(sql, "Luke", "Skywalker", 25);

		sql = "insert into users(first_name, last_name, age) values(?,?,?)";
		jdbcTemplate.update(sql, "Jane", "Doe", 25);

		sql = "select count(*) from users";
		numUsers = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("Number of users: " + numUsers);

		sql = "select last_name from users where first_name='Luke'";
		String lastName = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println("Last name: " + lastName);

		sql = "select last_name from users where first_name=?";
		lastName = jdbcTemplate.queryForObject(sql, String.class, "Luke");
		System.out.println("Last name: " + lastName);

		// --- Query for Map ---------------------------------------------------
		System.out.println("\n=== Query for Map ===============================");

		sql = "select * from users where first_name=?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, "Luke");
		System.out.println(map);

		// --- Query for List --------------------------------------------------
		System.out.println("\n=== Query for List ==============================");

		sql = "select * from users";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println(list);

		// --- RowMapper -------------------------------------------------------
		System.out.println("\n=== RowMapper ===================================");

		sql = "select * from users where first_name=?";
		User user = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			// @formatter:off
			return new User(
				rs.getInt("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getInt("age")
			);
			// @formatter:on
		}, "Luke");
		System.out.println(user);

		sql = "select * from users";
		List<User> users = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			// @formatter:off
			return new User(
				rs.getInt("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getInt("age")
			);
			// @formatter:on
		});
		System.out.println(users);

		final UserMapper userMapper = new UserMapper();

		users = jdbcTemplate.query(sql, userMapper);
		System.out.println(users);
	}

}
