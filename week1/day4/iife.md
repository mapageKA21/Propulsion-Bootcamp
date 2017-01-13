# Immediately Invoked Function Expression

IIFE (Immediately Invoked Function Expression) is a JavaScript function that runs as soon as it is defined.

```javascript
(function() {
  console.log('hello world');
})();
```

If you run this code, you will see printed `hello world`.

### Why use this pattern?

That is all there is. However, this "pattern" uses closures to create objects or modules with private data.

This "pattern" can be very useful when working in the browser, in order to hide or lock specific values to the end user.

Let's imagine we have this as part of the JS code in our asteroids game.

```javascript
var Ball = function() {
  this.vel = [1, 1];
}

Ball.prototype.move = function() {
  this.pos[0] += this.vel[0];
  this.pos[1] += this.vel[1];
}

var ball = new Ball();
```

First of all, there is the problem that if you open de console in the DevTools, the user has access to the `ball` instance. Which means that he could cheat the game.

He could execute this code in the console, and the speed of the ball would be reduced. Therefore the game would be much easier.

```javascript
ball.vel = [0.5, 0.5];
```

### How to use the pattern?

How can we avoid that? We can use an IIFE to create a closure so that we can hide the `vel` value.

```javascript
(function() {
  var vel = [1, 1];
  // `window` is the global object in the browser. We are attaching the class to the `window` object to make it accessible from everywhere
  window.Ball = function() {}

  Ball.prototype.move = function() {
    this.pos[0] += vel[0];
    this.pos[1] += vel[1];
  }
})();
```

As you can see, now `move` does not use the property of `Ball` but the variable `vel` which is in the scope when the method is created.

From outside the IIFE it is impossible for the user to change the value of that variable. Also to access it. The value is hidden and locked. Unless we change the value from another method that has access to it.

```javascript
(function() {
  var vel = [1, 1];
  // `window` is the global object in the browser. We are attaching the class to the `window` object to make it accessible from everywhere
  window.Ball = function() {}

  Ball.prototype.move = function() {
    this.pos[0] += vel[0];
    this.pos[1] += vel[1];
  }

  Ball.prototype.speedUp = function() {
    vel[0] += 1;
    vel[1] += 1;
  }
})();
```

### Putting it together

We might have `Game`, `Ball` and `Paddle` classes for example.

Each of this classes will be in it's own file. `app.js`, `ball.js` and `paddle.js`.

However, in our `app.js` inside the `Game` class we are using the `Ball` and `Paddle` classes. How do we have access to it?

If you attack the `Ball` class to `window` then you can have access from anywhere with `window.Ball`.

In our `app.js` if we want to create a new instance of `Ball` we can do the following:

```javascript
//...
var ball = new window.Ball();
//...
```

Don't forget to add the script tags to the HTML:

```HTML
<script src="ball.js" charset="utf-8"></script>
<script src="paddle.js" charset="utf-8"></script>
<script src="app.js" charset="utf-8"></script>
```

**Remember that order matters.**

For more on IIFE and closures you can read this [article](http://benalman.com/news/2010/11/immediately-invoked-function-expression/)
