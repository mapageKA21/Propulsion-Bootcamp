## Scope

This will be a friendly and short introduction to scope in javascript. For more details:

- [Javascript Scoping and Hoisting](http://www.adequatelygood.com/JavaScript-Scoping-and-Hoisting.html)
- [List of examples:](http://stackoverflow.com/questions/500431/what-is-the-scope-of-variables-in-javascript#) From beginners to advanced.

In plain words, `scope` refers to all the variables available at a current place in the code.

This means that if some variable is inside the current scope, it can be accessed. If it's outside, it can not be accessed.

```javascript
var test = 'hello';
function printTest() {
  console.log(test); // prints 'hello'
}
```

The variable `test` is accessible from inside the function.

The scope of a funcion is the union of:

- all the local variables that are defined inside the function.
- the parameters defined in the definition of the function.
- all the variables that were in the scope where the function was defined.

```javascript
function printTest() {
  var test = 'hello';
}
console.log(test); // this raises an error
```

In this example we try to access a local variable from outside. We can't do that. From inside the function you can access everything that was defined outside, but not the other way around.

There are two main types of scope. Functional and block scope.

The most important is to understand when the scrop is created.

- In functional scope, it is created when there is a function definition.
- In block scope, it is created when a new block is created. In JS, a block is created always that you use `{` and `}`.

```javascript
function printTest() {
  if (true) {
    var test = 'hello';
  }
  console.log(test);
}
printTest(); // it will print 'hello'
console.log(test); // this raises an error
```

In this example, even though the variable `test` is declared inside the `if` statement. It is accessible from outside the statement, but inside the function.

## Hoisting

Another important and simple concept is hoisting.

Before explaining Hoisting, you need to understand two smaller concepts.

- **Variable declaration**. This is when you first create the variable. Usually when you use the keyword `var`.
- **Variable assignment**. This is when you set the value of the variable. Using the keyword `=`.

Usually the variable declaration and the first assignment go together when you write code. However, that's not what happens in reality. Here comes *Hoisting*.

Hoising mean that, it does not matter where you first declare the variable. The code will be executed as if it was declared at the beginning of the scope.

Your code looks like this:

```javascript
function printTest() {
  if (true) {
    var test = 'hello';
  }
  console.log(test);
}
printTest(); // it will print 'hello'
```

But this is what gets executed.

```javascript
function printTest() {
  var test;
  if (true) {
    test = 'hello';
  }
  console.log(test);
}
printTest(); // it will print 'hello'
```

That's why we can do this:

```javascript
function printTest() {
  console.log(test); // we will get 'undefined', but not an error.
  if (true) {
    var test = 'hello';
  }
}
printTest(); // it will print 'hello'
```

Remember that trying to use undeclared variables raises an error. The previous example we are printing `test` when it has been defined, but not assigned yet. Since the assignment happens in the subsequent lines.
