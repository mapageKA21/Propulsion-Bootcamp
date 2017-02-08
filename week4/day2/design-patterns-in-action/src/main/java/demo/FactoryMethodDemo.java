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

import domain.Account;
import domain.Customer;
import service.MessageFormatter;
import service.MessageFormatterFactory;

/**
 * @author Sam Brannen
 */
public class FactoryMethodDemo {

	public static Customer createCustomer(String name, double accountBalance) {
		Customer customer = new Customer(name);
		Account account = new Account(customer, accountBalance);
		customer.setAccount(account);

		// do TWENTY other things!
		// do TWENTY other things!
		// do TWENTY other things!
		// do TWENTY other things!

		return customer;
	}

	public static void main(String[] args) {

		// Factory method:
		// Note that Integer.valueOf() cache values in the range -128 to 127.
		Integer i1 = Integer.valueOf(42);
		Integer i3 = Integer.valueOf(42);

		// Standard constructor:
		Integer i2 = new Integer(42);

		System.out.println("i1 == i2? " + (i1 == i2));
		System.out.println("i1.equals(i2)? " + i1.equals(i2));
		System.out.println("i1 == i3? " + (i1 == i3));

		System.out.println("----------------------------------------------------");

		Customer customer = createCustomer("John Smith", 1000.00);
		System.out.println(customer);

		System.out.println("----------------------------------------------------");

		// Doesn't work, because ConsoleMessageFormatter is package private.
		// ConsoleMessageFormatter messageFormatter;
		MessageFormatter messageFormatter = MessageFormatterFactory.createConsoleFormatter();

		System.out.println(messageFormatter.format("Hello, World"));
	}

}
