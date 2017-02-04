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

/**
 * @author Sam Brannen
 */
enum Operation {

	EXIT("Exit"),

	CUSTOMER_LIST("Print all customers"),

	NEW_CUSTOMER("Create a new customer"),

	FIND_CUSTOMER("Find a customer"),

	DELETE_CUSTOMER("Delete a customer"),

	CREDIT_ACCOUNT("Credit an account"),

	DEBIT_ACCOUNT("Debit an account");

	private final String displayText;

	private Operation(String displayText) {
		this.displayText = displayText;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", ordinal(), this.displayText);
	}

	static Operation fromOrdinal(int ordinal) {
		for (Operation operation : values()) {
			if (operation.ordinal() == ordinal) {
				return operation;
			}
		}
		return null;
	}

}