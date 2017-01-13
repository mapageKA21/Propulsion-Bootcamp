## Recursion

Recursion is a fancy name for a very simple concept. It's a function that calls itself, until it doesn't. It means that inside the body of the function there is a call to the same function.

**DO NOT EXECUTE THIS FUNCTION**

```javascript
function infiniteHelloWorld() {
  console.log('hello world');
  infiniteHelloWorld();
  // we are calling the function from inside the body
}
```

In this simple example, this function would incurs in an infinite loop, since it will never stop calling itself.

When we use recursive functions we want to avoid infinite loops, since they might crash our app and even the browser sometimes.

In the most simple form, a recursive function has two separated parts. The base case -or base cases- and the recursive call.

The base case is the scenario when the function will exit the function without calling itself.

As a simple example, let's take a function that expects an integer and prints all the numbers starting from that one until 0 is reached.

```javascript
function countDown(num) {
  // this is the base case
  if (num === 0) {
    console.log(num);
    return;
  }

  console.log(num);
  // This is the recursive call
  countDown(num - 1);
}

countDown(5);
```

Let's take a look at a function that will expect a number and return the sum of all the previous integers.

```javascript
function sumNums(num) {
  // This is the base case scenario
  if (num === 0) {
    return num;
  }

  // This is the recursive call
  return num + sumNums(num - 1);
}
```

This example is slightly more complicated since we are using the return value of the recursive call.

Recursion feels weird and hard to grasp at the beginning. But also very elegant solutions sometimes.

Nice video that explains recursion [here](https://www.youtube.com/watch?v=k7-N8R0-KY4).
