## Callbacks

This concept is sometimes feared or misunderstood but it's the simplest concept of this list.

A callback is just a function passed as an argument to a function. Period. End. That's it.

You have probably already used callbacks with `forEach`.

```javascript
[1, 2, 3].forEach(function(num) {
  console.log('in da num: ' + num);
});
```

`forEach` is a built-in method in arrays that expects a function as the first argument.

In this example, we define the function when we pass it. Withuot a name. This is also called an **Anonimous Function**.

However, we could have done the following.

```javascript
function printNum(num) {
  console.log('in da num: ' + num);
}
[1, 2, 3].forEach(printNum);
```

When you define a function that expects a callback, you can use it as a function in the body.

```javascript
function doMath(num1, num2, oper) {
  return oper(num1, num2);
}

function sum(firstNum, secondNum) {
  return firstNum + secondNum;
}

doMath(1, 2, sum);
```

Here there is a contract or signature that both need to agree on. The callback needs to expect the parameters passed as arguments at the execution.

In this example, our `doMath` function will execute the callback passing it two arguments. Which means that when we define the callback, we need to expect two paraments.

When using callback is important to realize that you have to define the callback function according to how it will be called.

Sometimes you are the one using the callback. However, there will be plenty of times where you will be relaying on a library. In that case, you will need to understand how to callback will be executed.
