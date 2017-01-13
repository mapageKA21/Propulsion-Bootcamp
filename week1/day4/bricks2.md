# Bricks in the wall day 2

Let's continue building our game.

If you weren't able to finish all the steps from yesterday, you have two choices:

- Keep working on yesterday's exercise. Please, ask for some assistance by an instructor to help you if you need some.
- Use the solutions from yesterday exercise as a starting point.

In the following steps we are going to add some interactivity to the game. For now we only have a bouncing ball and a bunch of blocks. They don't even interact with each other. Today will be about making the pieces in the canvas interact with each other and with the user.

### Paddle

Let's start by an easy one. Define a `Paddle` class that will render the paddle of the user. This paddle should be located at the bottom of the screen.

Implement a `render` method on the class, very similar to the previous `render` method on the `Block`. It makes sense for the paddle to be a rectangle.

For now don't worry about moving it. Let's focus on rendering it. Which means that first we need to initialized it in the `Game` constructor and then call `render` in the `setInterval`.

Once you have the paddle rendering at the bottom move on.

### Split your code

This is getting bigger. We have 4 different classes, each of them with a bunch of behaviour. The file is getting too big to handle.

We are going to move each different class to a single file. Step by step, after each small step, we shuold make sure that everything is still working.

Start by creating `ball.js` for example. Move all the code of the `Ball` class to the file -constructor and methods-. Then require it from the html. Right about the `<script>` tag that requires `app.js`.

Make sure that you remove the code for the `Ball` class from `app.js`, that you require it and that everything else keeps working as expected.

Repeat this process for `block.js` and `paddle.js`. Make sure everything else is working.

In our `app.js` you should only have the `Game` class.

*Remember that the order of the script tags matters.*

### Paddle player

Here comes one fun step. We are going to add the interactivity between the paddle and the user. This means that when the user clicks on some key, the paddle will move either left or right.

First we need to do is add a listener to the keyboard. This means that when a key is pressed, some function will be called.

*There won't be any details on how this works for now. This will be covered in week 2, during JS in the browser.*

```
document.addEventListener('keydown', function(event) {
  console.log('you pressed a key!');
});
```

After adding this piece of code, the function will be called for every key down.

`addEventListener` is a method and expects 2 parameters. The first one is the type of the event. The one that might interest you are `keypress`, `keydown` and `keyup`. The second parameter is the callback. The function that will be called when the event is triggered.

Next thing is to undestand which key was pressed. Some keys will do nothing to the paddle. You have to implement one that will move right and one that will move left. Did you realize the `event` parameter in the function? That argument will have the information on the event. Specifically, `event.keyCode` will have the code of the key that was pressed.

```
document.addEventListener('keydown', function(event) {
  console.log('you pressed the key,' event.keyCode);
});
```

This is all we need to implement the moving paddle. Recommended to set the listener in the initialization of the paddle.

There are a few steps to take into consideration:

- Identify which key triggered the event.
- Call the proper method when the desired key is pressed. As an example you could define `moveLeft` and `moveRight` methods on the `Paddle` that will change the position of the paddle.
- Know when to stop the paddle from moving. The ball never stops. However, the paddle doesn't move unless you press the key.

*Tip: play with two event types 'keydown' and 'keyup'. On 'keydown' you could make the paddle move. Then, on 'keydown' the paddle stops.*

**This was a long step, call an instructor to have some code review at this point**

### Collisions

Congratulations on making it up to this point. Now comes the real game!

First of all we are going to implement collisions between the blocks and the ball. Similar to how the ball moves, there is no magic in here. The main idea is to iterate through all the blocks, and for each of them, check whether the ball is colliding or not.

There are many approaches to this behaviour. If you think you already have an idea on how to implement this, please go ahead with your plan. The following are only *tips* on how it could be implemented.

We need to check for collisions before every render, and before we move the ball. Which means that we need to check them in the `setInterval`. Add a `checkCollisions` method in the `Game` class and call it in the `setInterval`.

`checkCollisions` should iterate through all the blocks. For each block, we should see whether there is a collision. For example, create `areColliding` method that expects a block and a ball and returns `true` or `false`.

*Before moving on, test that this is working. For example, print some message in the console when the ball collides with a block*

If the block and the ball are not colliding, there is nothing we need to do. However if they collide. We need to change the direction of the moving ball. There are two possible scenarios:

- The ball needs to switch the direction horizontally.
- The ball will switch diretion in the vertical axis.

You can handle them separately. Once you know that that block and ball are colliding, you can check whether the collision is vertical or horizontal. For vertical collision change the vertical direction, for horizontal collision, change the horizontal direction

*This step is tricky. So remember to play around and don't be afraid to write some code, print some information and run it in the browser.*

### Paddle collision

Similar to what you did with the blocks collisions, we should also add that behavior to the paddle.

Before every render, check whether the paddel is colliding with the ball and act accordingly if that's the case.

**Call an instructor for some code review at this point**

### Removing collided blocks

Until now we have a pretty boring game. There is no goal in it.

The goal of the game is to remove all the blocks by bouncing the ball on them.

When one block collides with the ball it should be removed. By being removed, it means that it should be removed from the array of blocks in the `Game` instance.

### Game Over!

Great, now you can play with the game! In games we can either lose or win, right? Let's implement that behaviour.

The player will lose when the ball touches the bottom of the canvas.

The player wins the game when there are no more blocks in the screen.

Implement `isGameOver` method on the `Game` class, and call it at the beginning in the `setInterval`, if it return `true` you should stop the `setInterval` from calling the function every period of milliseconds. In order to do that we need to clear the interval. There won't be any help fo this part. Use your google skills to search in the internet how to do that and implement it.

**Congratulations!! You created your first game!! Call an instructor so that you can get some feedback in your code**

### Apply the IIFE pattern

Apply the Immediately Invoked Function Expression pattern so that all the Classes do not pollute the `window` object.

Create a namespace for the game, such as `App` and attach it to window. Then all the classes should be attached to `window.App` from inside a IIFE function.

Also, try to hide all the properties that the user could use to cheat in the game.

By the end of this step, if you print `App` from the console, you should get:

```
{
  Game: function() { ... },
  Ball: function() { ... },
  Block: function() { ... },
  Paddle: function() { ... },
}
```

If you print `Game` in the console you should get `undefined`.

### Score

Add a Score to the Game.

Everytime you bounce on a Brick you get one point.

Print the Score in the Canvas.

### Bonus

- Do not start the game immediately after refreshing. Add some *Start* Button in the page.
- After all the Bricks are removed, insert new ones.
- Implement different brick Layouts. Use a random one every new game.
- Increate the speed of the ball after every XCseconds.
- The ball bounces different depending on where it bounces in the paddle. Check some online games to learn about this feature. Implement one you like.
