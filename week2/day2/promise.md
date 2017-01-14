# Getting started with Promises

Promises are a new kind of Objects in Javascript. They had been around for a while with libraries but now with ES6 they are implemented in the language.

Most of the browsers support the native `Promise`.

### Why promises?

Remember that Javascript is asynchronous.

This means that some actions that might take some time do not block the execution of the code.

Most simple example is `setTimeout`. If we want to run something after a specific period of time we use `setTimeout`.

```Javascript
function forLater() {
  console.log('I need to be executed later');
}
setTimeout(forLater, 2000); // this will call the function after 2 seconds
console.log('the last line'); // this runs before forLater is called
```

How would it be to be able to stop the execution.

```Javascript
function forLater() {
  console.log('I need to be executed later');
}
delay(2000);
forLater();
```

So that the `delay` function stops the execution.

This is more readable than having to pass what we want to do as a callback to `setTimeout`.

This is the main reason for promises. Avoiding to have to pass as callbacks what we want to do after something has finished -in this case, waiting for 2 seconds-.

### How to use promises

Most of the time, the developer is using promises, and not creating them.

As we said, `Promise` is an object. Usually returned after calling a function.

In our ideal synchronous JS example, if `delay` was returning a promise, we could do:

```Javascript
delay(2000).then(function() {
  console.log('I need to be executed later');
});
```

This is not perfect. But it's closer than passing it as a callback.

Promises have the `then` method. This method expects a function that will be called once the action finishes.

**Notice:** We will be using `Promise` today using `fetch`. Don't worry if you still don't grasp the concept. It will be clearer with the real use case.

### Is that it?

No! Here comes the coolest feature of the promises. They are chainable.

We keep chaining `then` after `then` and each of them will wait for the previous return value to finish in order to run the passed function.

```Javascript
delay(2000)
  .then(function() {
    console.log('I need to be executed later');
    return delay(3000); // I am retuning a Promise. Remember that delay creates a promise
  })
  .then(function() {
    console.log('this waited 5 seconds in total'); // 2 from first delay, 3 from second delay
  });
```

The important part is that in order for the next `then` to wait, you have to `return` the promise in the previous function.

If there is something wrong during the promise and we want to handle that error there are two ways.

- `.then` expects a second parameter, that is also a function and is called if there is an error in the previous promise.
- `.catch` is another method on the promise that expects a function as parameter. The function passed will be called if there is any error in all the chain of promises.

```Javascript
delay(2000)
  .then(function() {
    console.log('I need to be executed later');
    return delay(3000); // I am retuning a Promise. Remember that delay creates a promise
  })
  .then(function() {
    console.log('this waited 5 seconds in total'); // 2 from first delay, 3 from second delay
  })
  .catch(function() {
    console.log('Got here if something goes wrong!');
  });
```

### Bonus: How to create a Promise

Go check out [this](http://jamesknelson.com/grokking-es6-promises-the-four-functions-you-need-to-avoid-callback-hell/) great example if you want to read further about promises.

Not recommended until you have played with Promises.
