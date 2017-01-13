# Bricks In The Wall Day 1

We are going to build the backbone of our Arkanoid game today!

Let's go step by step.

### Canvas

First of all, let's create the canvas in the html and fill it with a background. Recommended height of 400 and width of 300.

Then create an `app.js` file that will hold all of our code for today. Require that file at the bottom of the `<body>` tag.

```
<script src="app.js" charset="utf-8"></script>
```

Remember to get the `context` and use `fillStyle` to draw a rectangle starting from the top left and covering the whole height and width.

### Ball

Let's create our first class. The `Ball` class. Define a constructor that will set a radius and the initial position of the ball.

The position will be an array of 2 numbers. First number will be the horizontal axis and the second one will be the vertical axis.

In order to draw a circle in a canvas we use a few methods. Try to draw with the following. This should render a white ball:

```
...
// remember to get the context first
context.beginPath();
context.arc(10, 10, 10, 0, 2 * Math.PI, false);
context.fillStyle = '#fff';
context.fill();
```

Investigate what are the parameters that `arc` accepts in order to customize your ball.

Create the `render` method on the `Ball` class. It should accept one parameter, the `context` and render the ball after being called.

Also, check what happens when you use the `scale` method on the context at the beginning of everything.

```
context.scale(10, 10);
```

After this step you should be able to:

```
...
var ball = new Ball();
ball.render(context);
```

### Moving Ball

Here comes the fun part when we make the ball move in the canvas. Although it might seem magic to have a ball moving and very complicated, it is actually very simple.

What you will do is move the ball to a new position, clear the canvas, and render the ball again. You will do this operation every 10 milliseconds or so.

**setInterval**

First you need to understand how `setInterval` works.

```
setInterval(callMeMaybe, 100);
```

This will call the function `callMeMaybe` once, every 100 miliseconds.

Now we need to apply this to our ball.

Define a method `move` that will move the ball everytime is called. By moving, it means to change the values of the position property. Remember that the position property was set in the constructor and it was an array of 2 values: `[horizontal, vertical]`.

*Tip: use a velocity vector to increase your position vector everytime `move` is called*

Now, let's put everything together in a `setInterval`:

```
setInterval(function() {
  // reset canvas, which means, paint it black
  ball.move();
  ball.render(context);
}, 10);
```

### Game class

Let's refactor a little bit. Define a class `Game` that when initialized will get the `canvas` from the DOM, as well as getting the context. It should also initialize a ball.

It should also have a `resetCanvas` method that will paint the canvas black. Which will be used inside our `setInterval`.

Also move the `setInterval` into the `play` method. Which, once called will set the interval.

```
...
var game = new Game();
game.play();
```

After theses two lines of code the ball should appear in the canvas and be moving around.

We didn't add any functionality, but it's always important to try to clean up our code from time to time.

**Once you get here, call an Instructor for some code review**

### Bouncing Ball

You should have a moving ball by now. However, it disappears when reaches the edges of the canvas. It doesn't bounce. You should fix that.

There are 2 main aspects of it:

- Horizontal bounce. If the horizontal position of the ball is less than 0 or greater than the width, then the next `move` call should move the ball in the other direction horizontally.
- Vertical bounce. Same idea, when less than 0 or greater than the heigth, the next `move` call should change the direction in the vertical axis.

*Tip: how about passing the `canvas` or the `height` and `width` of it to the `move` method?*

By now you shold have an endless bouncing ball. Congratulations!!

### Our first Block

Still plenty of work to do.

Define a `Block` class. When initialized it should set some properties: position, height, width and color.

Add also a `render` method that will expect a parameter, the `context`. Similar to the `render` method on the `Ball`. It should render the block in the canvas.

For now let's create an instance of `Block` in the initializer of the `Game` and call `render` on it inside the `setInterval`.

You should now have a block in the canvas. Play with different widths, heights until you fill you have a nice block.

### Blocks, Blocks, Blocks everywhere

With only one block it will be too easy to play. Which means that now we should, somehow add more blocks.

The current block is created in the `Game` constructor. Try having an array of blocks instead of just one block. Then, in the `setInterval` instead of rendering the single block, you should iterate the array and render every one of them.

Make it more fun with different colors or borders. For example, when creating a block, pick somehow a random color.

**Congratulations you have made your first step towards building an amazing Game!**

**Call an instructor to give you feedback on the code at this point**

### Bonus

Keep adding the functionality of the game.

If you feel you need some guidance, go ahead to the [project](../day4/bricks2.md) of day 4.
