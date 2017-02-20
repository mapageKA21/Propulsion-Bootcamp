/*

### `myBind`

Define a `myBind` function that simulates the `bind` method on `Function`.

Remember that `bind` creates a new function, that when called, calls the
passed function with the keyword `this` set to the object passed when binding.

*DO NOT WORRY ABOUT PARAMETERS FOR NOW*

*/
var obj = {
  name: 'Markov'
}

function printName() {
  console.log('This name is: ' + this.name);
}

function myBindCurrying(fn) {
  return function(ctx) {
    fn.call(ctx);
  }
}

function myBind(fn, ctx) {
  return function() {
    fn.call(ctx);
  }
}

console.log('Print name function:');
printName();
console.log('Print name function binded to object using closure:');
var boundPrint = myBind(printName, obj);
boundPrint(obj);
console.log('Print name function binded to object using currying:');
var boundPrintCurrying = myBindCurrying(printName);
boundPrintCurrying(obj);
console.log('Using just call:');
printName.call(obj);
console.log("Using regular bind:");
var newFunctionBinded = printName.bind(obj);
newFunctionBinded();
/*

### Improve `myBind`

Improve your `myBind` to accept parameters just like `bind` does
https://developer.mozilla.org/ca/docs/Web/JavaScript/Reference/Global_Objects/Function/bind

First when binding the function. Also when calling the function returned by `bind`.

```javascript
```

*/

function myBindImproved(fn, ctx) {
  var args = Array.prototype.slice.call(arguments, 2);
  return function() {
    var otherArgs = Array.prototype.slice.call(arguments);
    var totalArgs = args.concat(otherArgs);
    fn.apply(ctx, totalArgs);
  }
}


multipliByFive = function(num2) {
  return 5 * num2;
}

var obj = {
  name: 'Markov'
}
//
function greetingsTo(name) {
  console.log('Hello ' + name + ', my name is: ' + this.name);
}
// greetingsTo('Fante');
// var boundGreeting = myBindImproved(greetingsTo, obj);
// boundGreeting('Fante');

function greetingsToAll(name, name2) {
  console.log('Hello ' + name + ' and ' + name2 + ', my name is: ' + this.name);
}
// greetingsToAll('Fante', 'Hornby');
// var boundToAll = myBindImproved(greetingsToAll, obj);
// boundToAll('Fante', 'Hornby');
//
// var boundAndFirst = myBindImproved(greetingsToAll, obj, 'Fante');
// boundAndFirst('Hornby');

/*

### Currying Calculator

Define a function that returns a currying calculator.

The currying calculator will keep returning a function until 5 parameters are passed in total.

Then it returns the sum of all 5 params.

*/

function createCurryCalc() {
  var args = [];
  return function calc() {
    var newArgs = Array.prototype.slice.call(arguments);
    args = args.concat(newArgs);
    if (args.length >= 5) {
      return args.reduce(function(acc, el) {
        return acc + el;
      }, 0);
    }
    return calc;
  }
}

var curryCalc = createCurryCalc();
var partial = curryCalc(2, 3, 4);
// console.log(partial(1, 3));

var curryCalc2 = createCurryCalc();
var partial2 = curryCalc2(2);
partial2 = partial2(4, 5)
// console.log(partial2(1, 3));

/*

# `curry`

Define your `curry` function implementation.

`curry` expects a function, any function, and returns a curried version of it

**Tip: Remember what is the 'arity' of a function**

*/

function calc(num1, num2, num3, num4, num5) {
  return num1 + num2 + num3 + num4 + num5;
}

function curry(fn) {
  var arity = fn.length;

  function helper(args) {
    return function() {
      var newArgs =  Array.prototype.slice.call(arguments);
      var totalArgs = args.concat(newArgs);
      if (totalArgs.length >= arity) {
        return fn.apply(this, totalArgs);
      }
      return helper(totalArgs);
    }
  }

  return helper([]);
}


var curriedCalc = curry(calc);
// console.log(curriedCalc(4, 5)(3, 4)(4));

/*

### `myNew`

Define `myNew` function that simulates the `new` keyword.

You already saw an implementation of this in the notes. However, that implementation does not handle parameters.

Add the possibility to pass parameters to your `myNew`. As many as the constructor needs.
*/

function myNew(fn) {
  var args = Array.prototype.slice.call(arguments, 1);
  var obj = {};
  fn.applyf(obj, args);
  Object.setPrototypeOf(obj, fn.prototype);

  return obj;
}

function Cat(name) {
  this.name = name;
  this.legs = 4;
}

var markov = myNew(Cat, 'Markov')
// console.log(markov);
