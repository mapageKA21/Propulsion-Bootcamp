package util;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DataAccessConfig.class);
		
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		
		jdbcTemplate.update("truncate table users");
		
		String sql = "select count(*) from users";
		Integer numUsers = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("Num users: " + numUsers);
		System.out.println("-----------------------");
		
		sql = "insert into users(first_name, last_name, age) values(?,?,?)";
		jdbcTemplate.update(sql, "John", "Smith JR", 35);
		jdbcTemplate.update(sql, "Luke", "Skyes SR", 45);
		jdbcTemplate.update(sql, "Tom", "Pearl GF", 55);
		jdbcTemplate.update(sql, "Ann", "Fruss", 15);
		
		sql = "select count(*) from users";
		Integer numUsers2 = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("Num users: " + numUsers2);
		System.out.println("-----------------------");
		
		jdbcTemplate.execute("SELECT * FROM users;");
		
		sql = "select last_name from users where first_name='Luke'";
		String lastName = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println("Last Name: " + lastName);
		System.out.println("-----------------------");
		
		sql = "UPDATE users SET age=? WHERE first_name=?";
		jdbcTemplate.update(sql, "100", "John");
		
		sql = "select * from users where first_name=?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, "Luke");
		System.out.println("map of column-value pairs: " + map);
		System.out.println("-----------------------");
		
		sql = "select * from users";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println("list of maps: " + list);
		System.out.println("-----------------------");
		
		sql = "select * from users where first_name=?";
		List<User> users = jdbcTemplate.query(sql, (rs, num) -> {
				return new User(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age")
				);
		}, "Luke");
		System.out.println("single domain object with RowMapper: " + users);
		System.out.println("-----------------------");
		
		sql = "select * from users";
		List<User> multipleUsers = jdbcTemplate.query(sql, (rs, num) -> {
				return new User(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age")
				);
		});
		System.out.println("list of domain objects with RowMapper: " + multipleUsers);
		System.out.println("-----------------------");
		 
	}

}
