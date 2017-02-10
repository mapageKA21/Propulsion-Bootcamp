package forEach;

import java.util.*;

public class CustomerDemo {
	
	public static void printIn(Customer customer) {
		System.out.println("::     " + customer);
	}

	public static void main(String[] args) {

		Customer customer1 = new Customer("John");
		Customer customer2 = new Customer("Dave");
		Customer customer3 = new Customer("Matt");

		Account acount1 = new Account(customer1, 12000);
		Account acount2 = new Account(customer2, 15000);
		Account acount3 = new Account(customer3, 18000);

		List<Customer> people = Arrays.asList(customer1, customer2, customer3);

		people.forEach(customer -> System.out.println(customer));
		people.forEach(customer -> System.out.println(customer.getAccount()));

		Set<Customer> customerSet = new HashSet<Customer>();
		customerSet.add(customer1);

		customerSet.forEach(customer -> System.out.println("hello " + customer));
		customerSet.forEach(CustomerDemo::printIn);
		
		Map<String, Customer> customerMap = new HashMap<>();
		customerMap.put(customer1.getName(), customer1);
		customerMap.put(customer2.getName(), customer2);
		customerMap.put(customer3.getName(), customer3);

		customerMap.forEach((lastName, person) -> {
			System.out.println(lastName + ": " + person);
		});

		customerMap.forEach((name, customer) -> System.out.println(name + ": " + customer));

	}

}
