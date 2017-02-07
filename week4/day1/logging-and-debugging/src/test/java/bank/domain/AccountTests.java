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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Sam Brannen
 */
public class AccountTests {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private final Customer customer1 = new Customer("John Doe");

	private final Account account1 = new Account(customer1, 1000);

	@Test
	public void creditPositiveAmount() {
		account1.credit(500);
		assertThat(account1.getBalance()).isEqualTo(1500);
	}

	@Test
	public void creditNegativeAmount() {
		exception.expect(IllegalArgumentException.class);
		account1.credit(-1000);
	}

	@Test
	public void debitPositiveAmount() {
		account1.debit(500);
		assertThat(account1.getBalance()).isEqualTo(500);
	}

	@Test
	public void debitNegativeAmount() {
		exception.expect(IllegalArgumentException.class);
		account1.debit(-1000);
	}

}
