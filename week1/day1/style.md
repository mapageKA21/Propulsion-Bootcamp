## Conventions and coding style

In order to write good and clean code a developer needs to take a lot of things into account.

Conventions are non-written rules that most of the developers follow. It does not mean that if you don't follow the conventions the code won't work.

Conventions make it easier to read and understand for the future developer -it could be you- that will maintain or change the code.

There will be plenty of opportunities to talk about clean code. However, let's start with some of the most common conventions.

### Proper indentation

Indentation means adding proper spacing to the beginning of the lines. When opening a new block, for a function for example, the next line should be indented.

```javascript
if (true) {
  console.log('hello'); // this line is indented
}
```

Indentation makes the code readable and tidier. A poorly indented code is hard to read and it looks messy. The code should be easy to read and follow.

Compare these 2 examples:

```javascript
function fizzbuzz(num) {
for (var i = 1; i < num; i++) {
if (num % 15 === 0) {
      console.log('FizzBuzz');
    } else if (num % 5 === 0) {
    console.log('Buzz');
  } else if (num % 3 === 0) {
  console.log('Fizz');
  } else {
      console.log(num);
  }
}
}
```

```javascript
function fizzbuzz(num) {
  for (var i = 1; i < num; i++) {
    if (num % 15 === 0) {
      console.log('FizzBuzz');
    } else if (num % 5 === 0) {
      console.log('Buzz');
    } else if (num % 3 === 0) {
      console.log('Fizz');
    } else {
      console.log(num);
    }
  }
}
```

**Convention:**

The most popular convention in JS currently is 2 spaces as indentation.

### Proper naming

Naming is another important aspect when writing readable code. Function and variables names need to be representative and self explanatory.

Avoid single or two characters variable names.

Two examples:

```javascript
function do(a, b) {
  var r = a * b;
  return r;
}
```

```javascript
function multiply(num1, num2) {
  var result = num1 * num2;
  return result;
}
```

**Convention:**

In javascript the convention for naming is to use [camelcase](https://en.wikipedia.org/wiki/Camel_case).

**Never start with capital letters unless it is a constructor.**
