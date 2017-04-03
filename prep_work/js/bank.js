function Bank() {
  this.customers = {};
}

Bank.prototype.withdraw = function(customer, amount) {
  this.customers[customer] -= amount;
}

Bank.prototype.deposit = function(customer, amount) {
  this.customers[customer] += amount;
}

Bank.prototype.printAccount = function(customer) {
  console.log(`${customer} account is ${this.customers[customer]}`);
}

Bank.prototype.addCustomer = function(customer) {
  this.customers[customer] = 0;
}

var bank = new Bank();
bank.addCustomer('Sheldor');
console.log(bank);
bank.addCustomer('Raj');
console.log(bank);
bank.printAccount('Sheldor');
bank.deposit('Sheldor', 10);
bank.printAccount('Sheldor');
bank.addCustomer('Raj');
bank.printAccount('Raj');
bank.deposit('Raj', 10000);
bank.printAccount('Raj');
bank.withdraw('Raj', 100);
bank.printAccount('Sheldor');
bank.printAccount('Raj');
