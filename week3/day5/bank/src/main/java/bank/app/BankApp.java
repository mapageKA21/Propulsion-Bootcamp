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

package bank.app;

import java.util.List;
import java.util.Scanner;

import bank.domain.Customer;
import bank.service.BankService;

/**
 * Command-line application that serves as a facade to the {@link BankService}.
 * @author Sam Brannen
 */
public class BankApp {

	private static final BankService bankService = new BankService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			Operation operation = getOperationFromUser();

			switch (operation) {
				case EXIT: {
					banner("Exiting... 👋");
					System.exit(0);
				}
				case CUSTOMER_LIST: {
					printCustomers();
					break;
				}
				case NEW_CUSTOMER: {
					createNewCustomer();
					break;
				}
				case FIND_CUSTOMER: {
					findCustomer();
					break;
				}
				case DELETE_CUSTOMER: {
					deleteCustomer();
					break;
				}
				case CREDIT_ACCOUNT: {
					creditAccount();
					break;
				}
				case DEBIT_ACCOUNT: {
					debitAccount();
					break;
				}
				default:
					System.err.printf("Unsupported operation: %s%n%n", operation.ordinal());
					break;
			}
		}
	}

	private static void printCustomer(Customer customer) {
		System.out.println(customer.getName());
		System.out.println("\tCustomer ID:      " + customer.getId());
		System.out.println("\tAccount ID:       " + customer.getAccount().getId());
		System.out.println("\tAccount Balance:  " + customer.getAccount().getBalance());
	}

	private static void printCustomers() {
		banner("Customers");
		System.out.println();

		List<Customer> customers = bankService.findAllCustomers();
		if (customers.isEmpty()) {
			System.out.println("The bank has no customers.");
		}
		else {
			customers.forEach(BankApp::printCustomer);
		}
	}

	private static void createNewCustomer() {
		banner("Create New Customer");

		prompt("Customer name");
		String name = scanner.nextLine();

		prompt("Account balance");
		double balance = scanner.nextDouble();

		bankService.saveCustomer(new Customer(name, balance));
	}

	private static void findCustomer() {
		banner("Find Customer");

		prompt("Customer ID");
		String id = scanner.nextLine();

		System.out.println();
		Customer customer = bankService.findCustomerById(id);
		if (customer == null) {
			System.err.println("Could not find customer with ID: " + id);
		}
		else {
			printCustomer(customer);
		}
	}

	private static void deleteCustomer() {
		banner("Delete Customer");

		prompt("Customer ID");
		String id = scanner.nextLine();

		bankService.deleteCustomer(id);

		// We assume the customer got deleted, but we don't
		// actually know if the operation succeeded.
		// For example, if there is no such customer, the
		// BankService doesn't inform us of that. :(
		System.out.println("Deleted customer with ID: " + id);
	}

	private static void creditAccount() {
		banner("Credit Account");

		prompt("Customer ID");
		String id = scanner.nextLine();
		Customer customer = bankService.findCustomerById(id);

		if (customer == null) {
			System.err.println("Could not find customer with ID: " + id);
		}
		else {
			prompt("Credit amount");
			double amount = scanner.nextDouble();

			customer.getAccount().credit(amount);
			System.out.println("Credited account with: " + amount);
			printCustomer(customer);
		}
	}

	private static void debitAccount() {
		banner("Debit Account");

		prompt("Customer ID");
		String id = scanner.nextLine();
		Customer customer = bankService.findCustomerById(id);

		if (customer == null) {
			System.err.println("Could not find customer with ID: " + id);
		}
		else {
			prompt("Debit amount");
			double amount = scanner.nextDouble();

			customer.getAccount().debit(amount);
			System.out.println("Debited account by: " + amount);
			printCustomer(customer);
		}
	}

	private static Operation getOperationFromUser() {
		banner("Menu");

		while (true) {
			System.out.println();
			for (Operation current : Operation.values()) {
				System.out.println(current);
			}

			prompt("Operation");
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				scanner.nextLine();
				Operation operation = Operation.fromOrdinal(input);
				if (operation == null) {
					System.err.println("Invalid operation: " + input);
				}
				else {
					return operation;
				}
			}
			else {
				if (scanner.hasNextLine()) {
					System.err.println("Invalid operation: " + scanner.nextLine());
				}
			}
		}
	}

	private static void prompt(String label) {
		System.out.printf("%nEnter %s: ", label);
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
