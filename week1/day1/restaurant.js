var pluto = {
  name: 'Pluto',
  id: 1
};
var goofy = {
  name: 'Goofy',
  id: 2
};

let Ingredient = function(name, cost) {
  this.name = name;
  this.cost = cost;
}

let Dish = function(name, ingredientsArray, price) {
  this.name = name;
  this.ingredients = ingredientsArray;
  this.price = price;
}

let Restaurant = function() {
  this.orders = {};
}

Dish.prototype.cost = function() {
  return this.ingredients.reduce(function(a, b){
    return a + b.cost;
  }, 10)
}

Dish.prototype.profit = function() {
  return this.price - this.cost();
}

Restaurant.prototype.orderDish = function(dish, client) {
  if (!this.orders[client.id]) {
    this.orders[client.id] = [dish];
    return;
  }
  this.orders[client.id].push(dish);
}

Restaurant.prototype.printOrders = function(client) {
  // this.orders[client.id] //array
  console.log(client.name);
  for (var i = 0; i < this.orders[client.id].length; i++) {
    console.log(`Order #${i}: ${this.orders[client.id][i].name}`);
  }
}

Restaurant.prototype.printCheck = function(client) {
  console.log(client.name);
  let total = 0;
    for (var i = 0; i < this.orders[client.id].length; i++) {
      total += this.orders[client.id][i].price;
      console.log(`Order #${i}: ${this.orders[client.id][i].name} - ${this.orders[client.id][i].price}`);
  }
    console.log(`Total: ${total}`);
}

Restaurant.prototype.globalProfit = function() {
  let totalProfit = 0;
  for (var i in this.orders) {
    for (var x = 0; x < this.orders[i].length; x++) {
      totalProfit += this.orders[i][x].profit();
    }
  }
  return totalProfit;
}

Restaurant.prototype.clientProfit = function(client) {
  let totalProfit = 0;
  if (this.orders[client.id]){
    for (var x = 0; x < this.orders[client.id].length; x++) {
      totalProfit += this.orders[client.id][x].profit();
    }
  }
  return totalProfit;
}

var cheese = new Ingredient('Cheese', 5);
var pepperoni = new Ingredient('Pepperoni', 8);
var pizza = new Dish('Pizza', [cheese, pepperoni], 40);
var salad = new Dish('Salad', [cheese, pepperoni], 30);
let restaurant = new Restaurant;
restaurant.orderDish(pizza, goofy);
restaurant.printCheck(goofy);
restaurant.orderDish(pizza, pluto);
restaurant.orderDish(salad, pluto);
restaurant.printCheck(pluto);
console.log(restaurant.clientProfit(goofy));
