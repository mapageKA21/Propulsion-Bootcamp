## Asynchronous vs Synchronous

As we now, the scripts are executed in order by the computer. From top to bottom, line by line.

The main difference between synchronous and asynchronous code is whether the execution of the next line of code will wait for the previous one to finish.

Javascript is asynchronous. However, that does not mean that everything in javascript is asynchronous.

The simplest async example is this:

```javascript
console.log('beginning');

setTimeout(function() {
  console.log('in da timeout');
}, 0);

console.log('end');
```

The output of the previous code is:

```
beginning
end
in da timeout
```

As you can see, the `console.log('end')` is executed before the `console.log('in da timeout')` even though the timeout is not supposed to wait.

What really happens is that the function in the `setTimeout` is sent to the [event loop](https://www.youtube.com/watch?v=8aGhZQkoFbQ). The video is a great explanation with a visualization of the event loop. For now let's say that it's like a queue that waits for some event to be triggered or order to execute the function. In this specific case, it would wait for the miliseconds in the `setTimeout` to finish in order to call the function.

When something is sent to the event loop, the code keeps executing the next line of code without waiting for whatever is in the event loop. The functions in the even loop will be executed at the end of the script and as soon as each proper action is triggered.

An example of synchronous code is `forEach`.

```javascript
console.log('beginning');

[1, 2, 3].forEach(function(num) {
  console.log('in da forEach: ' + num);
});

console.log('end');
```

This will output the following:

```
beginning
in da forEach: 1
in da forEach: 2
in da forEach: 3
end
```

As you can see in the example, the line with `console.log('end')` is executed once all `forEach` finishes looping the array of elements.
