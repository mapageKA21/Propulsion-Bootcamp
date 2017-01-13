## Functions

Functions are a way to put toghether a set of instruction, so that they can be executed whenever we want.

The main idea is that, instead of copy-pasting the instructions, you can just wrap them in a function and use them.

There are a few key concepts for functions:

- **Definition**: When we create the functon with the set of instructions that will be executed everytime we call the function.

```javascript
function isBiggerThanTen(num) {
  var result = num1 > 10;
  return result;
}
```

- **Body**: the set of instructions that will be executed

```javascript
...
var result = num1 > 10;
return result;
...
```

- **Parameters**: names listed in the function definition. Ex: `(num)`
- **Call or execution**: using the set of instructions.

```javascript
isBiggerThanTen(5);
```

- **Arguments**: the real values passed to (and received by) the function. Ex: `(5)`

```javascript
function biggerThan(num1, num2) {
  var result = num1 > num2
  return result;
}
```

### Built-in methods

Remember that in javascript everything is an object. Which means that everything has methods on it that can be used.

**Methods are just functions that are attached to an object.**

You have already used plenty of built-in methods probably. Some of the most common are `.push` or `.join` on arrays. Or `.split` and `.toLowerCase` in strings.

There is a list of all the built-in methods in JS Objects. Each in its section in the [MDN Docs](https://developer.mozilla.org/en-US/docs/MDN).

For example, built-in methods for *String* are listed in the [String Article](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String) under `String.prototype` namespace. *We'll talk later in the course what `prototype` is.*
