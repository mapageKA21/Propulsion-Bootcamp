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

package bank.domain;

import java.util.UUID;

import lombok.Data;

/**
 * @author Sam Brannen
 */
@Data
public class Account {

	private final String id = UUID.randomUUID().toString();
	private final Customer customer;
	private double balance;

	public Account(Customer customer, double balance) {
		this.customer = customer;
		this.balance = balance;

		this.customer.setAccount(this);
	}

	/**
	 * @param amount the amount to credit; must be greater than 0
	 */
	public void credit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot credit a negative amount");
		}
		this.balance += amount;
	}

	/**
	 * @param amount the amount to debit; must be greater than 0
	 */
	public void debit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot debit a negative amount");
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [ID=" + this.id + ", Customer ID=" + this.customer.getId() + ", Balance=" + this.balance + "]";
	}

}
