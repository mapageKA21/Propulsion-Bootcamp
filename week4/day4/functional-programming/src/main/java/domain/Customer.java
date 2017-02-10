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

package domain;

import java.util.UUID;

/**
 * @author Sam Brannen
 */
public class Customer {

	private final String id = UUID.randomUUID().toString();
	private final String name;
	private Account account;

	/**
	 * Create a new {@code Customer} without an {@link Account}.
	 */
	public Customer(String name) {
		this.name = name;
	}

	/**
	 * Create a new {@code Customer} with an {@link Account}
	 * with the supplied initial balance.
	 */
	public Customer(String name, double accountBalance) {
		this(name);
		this.account = new Account(this, accountBalance);
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [id=" + this.id + ", name=" + this.name + ", account=" + this.account + "]";
	}

}
