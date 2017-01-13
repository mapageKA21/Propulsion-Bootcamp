# Parameters and `arguments` of a function

We know that when we define a function, we also define the expected parameters.

Javascript is very flexible, and it allow us to either, do not set any of those expected parameters when we call the function. Or pass more parameters than the expected in the definition of the function.

Most of other languages raise an error when the parameters on the definition don't match with the arguments passed in the invocation.

As an example:

```javascript
function printCapitalized(str) {
  console.log(str.toUpperCase());
}

printCapitalized('hello'); // prints 'HELLO'
```

However we could call it without any argument
```javascript
printCapitalized();
```

This will raise an error. But not because we didn't pass an argument, but because the argument is `undefined` and we are trying to call `.toUpperCase` on `undefined`. We can handle that option.

```javascript
function printCapitalized(str) {
  if (typeof str === 'undefined') {
    console.log('You didn\'t pass any argument!!!');
    return; // we want to exit the execution here
  }
  console.log(str.toUpperCase());
}

printCapitalized('hello'); // prints 'HELLO'
printCapitalized(); // prints 'You didn't pass any argument!!!'
```

Similarly, we could pass more than the expected arguments.
```javascript
printCapitalized('hello', 'mad', 'world'); // prints 'HELLO'
```

No error is raised. There is no change in the behavior. However, where do the extra arguments? The answer is the `arguments` keyword.

The `arguments` object is a local variable available within all functions. It looks like an array, since each extra argument is in a number key, just like in the arrays. But you can't use `forEach` or `map` or anything like that.

```javascript
printCapitalized('hello', 'mad', 'world');
// arguments[0] is 'hello'
// arguments[1] is 'mad'
// arguments[2] is 'world'
```

If we want to handle and also print all those, we can use the `arguments` keyword inside the definition of the function.

```javascript
function printCapitalized(str) {
  if (typeof str === 'undefined') {
    console.log('You didn\'t pass any argument!!!');
    return;
  }
  var args = Array.from(arguments); // ES6
  // var args = Array.prototype.slice.call(arguments); // ES5
  args.forEach(function(arg) {
    console.log(arg.toUpperCase());
  });
}

printCapitalized('hello', 'mad', 'world');
// prints:
// 'HELLO'
// 'MAD'
// 'WORLD'
```

We can now stop using the expected parameter:

```javascript
function printCapitalized() {
  if (arguments.length === 0) {
    console.log('You didn\'t pass any argument!!!');
    return;
  }
  var args = Array.from(arguments);
  args.forEach(function(arg) {
    console.log(arg.toUpperCase());
  });
}
```

We just created a function that will print and capitalize all the arguments passed. No matter how many we pass.

Read the full MDN [article](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/arguments) for more about `arguments`.
