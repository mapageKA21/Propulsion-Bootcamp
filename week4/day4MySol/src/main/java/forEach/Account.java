package forEach;

import java.util.UUID;

public class Account {

	private final String id = UUID.randomUUID().toString();
	private final Customer customer;
	private double balance;

	public Account(Customer customer, double balance) {
		this.customer = customer;
		this.balance = balance;

		this.customer.setAccount(this);
	}

	public String getId() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void credit(double amount) {
		this.balance += amount;
	}

	public void debit(double amount) {
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [ID=" + this.id + ", Customer ID=" + this.customer.getId() + ", Balance=" + this.balance + "]";
	}

}
