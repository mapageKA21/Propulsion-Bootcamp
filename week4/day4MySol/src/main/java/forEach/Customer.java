package forEach;

import java.util.UUID;


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
