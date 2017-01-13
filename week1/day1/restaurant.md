# Restaurant

You are going to create a project to manage a Restaurant.

By the end of this project you will be able to manage customers bills and orders. As well as having the profit of the restaurant.

### Dish Class Setup

Everything at a restaurant starts with some dish. Customers can order them.

Let's create the `Dish` class. For now, it will only have a name.

```javascript
var pizza = new Dish('Pizza');
var salad = new Dish('Salad');
```

### Restaurant Class Setup

Now let's create a simple Restaurant class.

The only thing that the restaurant can do for now is accept orders and print all the orders.

```Javascript
// ...
restaurant.orderDish(pizza);
restaurant.orderDish(salad);
restaurant.printOrders();
```

This should print some output like:

```
Order #0: Pizza
Order #1: Salad
```

### Ingredients Class

The dishes are made of ingredients.

The ingredient have a name and a cost.

```Javascript
var cheese = new Ingredient('Cheese', 5);
```

When initializing a `Dish` we should now pass the ingredients as an array.

```Javascript
var pizza = new Dish('Pizza', [cheese, pepperoni, dough]);
var salad = new Dish('Salad', [lettuce, cheese, tomato]);
```

### Dish Cost and Profit

Since each ingredient has a cost, we can calculate the total cost of a Dish.

Create a `cost` method on the `Dish` class that returns the total cost.

The fixed cost per dish is 10. If the total cost of the ingredients is 12, then the cost of the dish is 22.

```Javascript
pizza.cost() // => 27
```

Add the price of the dish in the constructor of the `Dish`. Then implement the `profit` method.

```Javascript
var pizza = new Dish('Pizza', 35, [cheese, pepperoni, dough]);
pizza.profit() // => 8
```

### Restaurant Check

The order of the restaurant is composed with a list of dishes. Each of the dishes has now the price.

Add a method `printCheck` in the `Restaurant` that will print the check with each Dish, its price and the total price.

```Javascript
// ...
restaurant.check();
```

It should print something like:

```
Order #0: Pizza - 35
Order #1: Salad - 30
Total: 65
```

### Clients

So far the restaurant doesn't handle different customers.

Implement all the previous behavior to handle different clients.

```Javascript
var pluto = {
  name: 'Pluto',
  id: 1
};
var goofy = {
  name: 'Goofy',
  id: 2
};

// ...
restaurant.orderDish(pizza, goofy);
restaurant.printCheck(goofy);
restaurant.orderDish(pizza, pluto);
restaurant.orderDish(salad, pluto);
restaurant.printCheck(pluto);
```

The output should be something like this:

```
Goofy
Order #0: Pizza - 35
Total: 35
Pluto
Order #0: Pizza - 35
Order #1: Salad - 30
Total: 65
```

### Bonus

- Implement the `totalProfit` method to the `Restaurant`
- Implement a method to have the profit of a specific customer
