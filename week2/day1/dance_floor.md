# Dance Floor

In this project you are going to create a "Dance Floor" or grid of tales that will change the colors randomly. Just like a any cool dance floor would if they could!

We will be using jQuery, so remember to download and add the script tag.

### Dance Floor setup

Before changing any colors, we need to first have a dance floor.

Let's create a 5x5 grid. This means 25 squares -or cells- in total. Hopefully aligned in the middle of the page.

**Pro Tip: You can create directly the grid with JS**

With CSS there are usually more than one way to accomplish the same result. Same as with any programming language.

A few tips you should consider to accomplish this:
- Use a div parent for all the cells. Give it a width.
- To center that div set margin left and right `auto`.
- `float: left` for the cells
- Give also some width and height to the cells. And a Background color.

### Change color of one cell

The main idea behind of changing the color is that you will add or remove a class for example.

```html
<div class="cell"></div>
```

If we want to change the color, we could for example:

```html
<div class="cell active"></div>
```

Then, in CSS we select the `active` class to set a different background color.

Try this with just a few cells in the html file directly.

### Add behavior with Javascript!

Create an `app.js` for example and require it from your html. Remember to require it at the end of the `<body>` tag for now.

You have been able to change the color of some cells manually. Now it's time to do that with Javascript.

In your javascript code we want to change the class of some cells. But not all of them.

Create a function that when called, will change the color of some random cells. `randomizeGrid` for example.

**Tips**

- Remember that when you select an element with `$` you not only get one single element. But an array of them.

  That means you can iterate through them: `$('.cell').each`. Check the documentation for `each` [here](https://api.jquery.com/each/)

- Use `Math.random` to randomize whether to toggle the class or not.

### Dance, Dance, Dance

Use `setInterval` to call your function `randomizeGrid` every second for example.

### Create the grid with Javascript

You probably created 25 `div`s manually. This is not a proper practice. Developer are lazy and are always looking for ways to avoid doing repetitive tasks.

Probably you realized that all the `div` for each cell is exactly the same.

With Javascript you can create `<div>` easily. You can also add the class and append them to the parent easily.

Create a function that when called creates 25 cells and appends them to the parent. Call that function immediately after defining it.

Your `<body>` in the html after this step should look like:

```html
<body>
  <div class="container"</div>
  <script ...></script>
</body>
```

**Ask for a review from an instructor at this point**
