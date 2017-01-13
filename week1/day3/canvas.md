# Canvas

The Canvas is an html element just like `<div>` or `<p>`. The Canvas is `<canvas>`.

The element was originally introduced by Apple for the OS X Dashboard and Safari, nowadays all the main browsers support it.

The `canvas` allows to draw shapes on it. Rather than adding content as you would in any other element, `canvas` exposes a context that has an API to draw almost any shape you want.

We are going to use the `canvas` to create cool games in the browser. The canvas is accessible with javascript to write on it. It is the perfect environment to learn javascript, since it will allow us to focus on the language.

## Getting Started

Create a folder. In the folder we are going to add an `index.html` and `app.js`.

In the `index.html` add the regular html tags, DOCTYPE and so on. Now, add the `<canvas>` element inside the body. Give it an `id`, a `height` and a `width` attributes.

Then require `app.js` in `index.html` with a `<script>` tag **at the end of the `<body>` tag**. Make sure that it is properly loaded adding a `console.log('hello world')` in `app.js` and opening the console to check for the log.

## Painting

Now we are going to paint a simple rectangle. Add the following code to `app.js`.

```javascript
var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

ctx.fillStyle = 'green';
ctx.fillRect(10, 10, 100, 100);
```

You should have a green rectangle if you reload `index.html`. Remember that after every change in `app.js` you need to reload the page in order to have the updated javascript file.

We are not going to go into details now. But you should now that you can paint in the canvas using the canvas' context -`ctx`-. Which is what you get when calling `getContext('2d')`.

[Here](http://www.html5canvastutorials.com/) you have a nice resource on how to draw almost any shape.

**Exercise: Try to draw a circle with the documentation**
