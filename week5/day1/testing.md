# Automated Testing

When talking about tests, usually people talk about automated tests.

This means a set of tests that can be run separately and automatically as many times as we want.

In every programming language there are plenty of tools and frameworks for automated tests, Javascript is no exception.

At this point of the course we are going to learn a new and very simple tool for testing. However you should know that there are plenty of other tools. Some of them much more powerful than this one.

We are going to use [tape](https://github.com/substack/tape).

### Tape - Getting started

Tape can be used as any other node package. Just install it with `npm install`, require it and use it. There is no setup involved.

1. Create a folder
2. `npm init -y`
3. `npm install --save tape`
4. Create a file `tests.js`

In this file require and use `tape`.

```javascript
var test = require('tape');

test('My first test', function(t) {
  t.true(true, 'should work easily');
  t.end();
});
```

- `test` is the function that will run the test. The first parameter is a string which will be the message. The second is the function to be executed.
- The callback passed to `test` will receive an object, we called it `t` that we can use to make assertions and close the test.
- `t.true`, expects an expression and then a string as a message. If the expression is 'truthy' the test will pass.
- `t.end` is the function we want to call to finish the tests.

Now you can run the test by simply running the file `node tests.js`.

You should get something like this.

```
TAP version 13
# My first test
ok 1 should work easily

1..1
# tests 1
# pass  1

# ok
```

If you install globally `tape` you could also run them with `tape tests.js`.

### Your first real automated test

Create a file where you are going to add and export all the exercises from your first day.

Let's start with the `isString` function.

In this file, remember to export it as explained [here](node.md).

Let's import the file and get the function we want to test. In our `tests.js`.

```javascript
var test = require('tape');
var exercises = require('./exercises.js');

test('isString function', function(t) {
  t.test('when passed a string', function(t) {
    t.true(exercises.isString('hello'), 'should return true');
    t.end();
  });

  t.test('when passed an array', function(t) {
    t.false(exercises.isString([1, 2]), 'should return false');
    t.end();
  });
});

```

It is common to nest tests. All the tests of different scenarios are in the same test function.

**Further reading**

For further information please review the documentation on the [Github page](https://github.com/substack/tape).

Check the [pretty reporters](https://github.com/substack/tape#pretty-reporters) list in order to print your tests with some colors. Red when failing and green when passing.
