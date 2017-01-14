# Dancing in the Dance Floor

The Dancing Floor project was about the cells changing color randomly.

This project is about the user controlling the dance moves. Controlling which cell is `active` or dancing and move around the grid with the keyboard.

### Setup Dance Floor

First of all, setup the Grid for the dance floor. You can use the same code you used for the previous project.

*If you haven't at this point. Create the grid with Javascript instead of manually*

### Where to start dancing?

First of all we need to tell the grid which cell starts dancing.

We will start with the first cell that is clicked with the cursor.

Add a listener on `click` to the cells. You should change the color of the clicked cell, not all of them.

**Tip: Remember the `event` object passed to all the listeners.**

### Keyboard listener

Add a listener when a key is pressed. When you add a listener to the keyboard, you don't add a listener to a specific key, but to all of them at the same time.

In order to know which key was pressed try logging `keyCode` property of the `event` object passed to the listener.

At this point you should be able to select a specific cell and then log something in the console when a key is pressed.

### Move Up

Let's go step by step. Choose a key that will move the selected cell up. Recommended key is `W`. So that you can control the cell with `W`, `A`, `S` and `D`.

In the `keypress` listener, identify when you are pressing `W` and only then move the selected cell up.

What does it mean to move the selected cell up? We need to do a few steps:
- Identify which is the cell above.
- Add the proper class to the identified cell above.
- Remove the class on the current cell.

The tricky part is identifying the cell above. In order to do that you need to be able to identify all the cells. Each cell should have a specific way to tell them apart from the others. This identifier could also give us information about which column and row they are in.

As an example, the cells in the html could look something like this:

```html
...
<div class="cell" data-row="2" data-col="2"></div>
<div class="cell" data-row="2" data-col="3"></div>
<div class="cell" data-row="2" data-col="4"></div>
<div class="cell" data-row="2" data-col="5"></div>
...
```

Or using an id:

```html
...
<div class="cell" id="2-2"></div>
<div class="cell" id="2-3"></div>
<div class="cell" id="2-4"></div>
<div class="cell" id="2-5"></div>
...
```

This needs to be done when you create the grid. When creating each cell, add also some identifier that also has the information about the row and column.

Now that each row can be identified the steps to identify are:
- Get the row and column of the selected cell
- Calculate the row and column of the cell above the selected one
- Select with jQuery the row above the selected one.

Now that you have the cell above, you can easily add the class and also remove the class from the current cell.

**Ask for a review from an instructor at this point**

### More movements

Add the other movements. Left, right and down.

Now identify the rest of the keys that you want to use and move according to each key.

### Edges

What happens when you get to the edge of the grid? Do you stop going in that direction?

Implement the grid as an infinite grid. That means, when the selected cell is at the first row and you want to move up, you should select the cell at the last row. Same the other way around and the lateral edges.

The selected cell can never get stuck. It always dances!

**Ask for a review from an instructor at this point**

### Bonus: Diagonal movements

Apply the diagonal movement.

Keys `Q`, `E`, `Z`, `C` for example.

### Bonus: Refactor using OOP

Can you think of an OOP solution for this exercise?

The information of each cell was in the html. But how about if each cell was in an array and was an instance of `Cell` for example.

Also, think about a `Grid` class that has the methods `moveLeft`, `moveUp`, ... for example. It should also have the `selectedCell` stored.

Implement this solution.

When refactoring, it is very important to go step by step. The smallest the step, the better. After each small refactored step, make sure you have the same functionality and that everything is working.
