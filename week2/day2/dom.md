# Document Object Model - DOM

What we usually call the Document Object Model or DOM is the html we currently see in the browser.

Everything we see in the browser, all the content, comes from the HTML or the DOM.

CSS is for styling that content. With it, we can change the colors, the position, style, font, etc.

Javascript is for manipulating the DOM. It was created to add interaction to the static HTML document.

### Order matters

When our browser receives the HTML page, it will start reading the file top to bottom. This means that the order matters.

```HTML
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="style.css">
    <script src="library.js" charset="utf-8"></script>
  </head>
  <body>
    <div id="app">
    </div>
  </body>
</html>
```

This is an example of some HTML file with a common structure. We won't go into the details, just an overview to help us better understand what is going on in the browser. How all this interacts with our Javascript code.

As we said, the order matters. The fist thing that the browser reads is `<!DOCTYPE html>`. This is telling the browser that this file is of type `HTML`.

Next line is the opening tag for `<html>`. In the `<html>` there are usually two tags: `<head>` and `<body>`.

`<head>` is usually for information about the content, not the content itself. It is commonly used to request other files that might be used by this html. Specifically the CSS and JS files. We can see this in the following lines:

```html
<link rel="stylesheet" href="style.css">
<script src="library.js" charset="utf-8"></script>
```

This means that this HTML is going to request two more files `style.css` and `library.js`. As soon as this files are received by the browser, they will be executed.

Order matters, which means that these files will be requested before the browser arrives to read `<body>` tag. This can introduce bugs when you interact with the DOM within your JS file.

The DOM is completed when the browser has arrived at the end of the HTML file. While the DOM is not completed, our Javascript code can't access all the HTML elements that are on the page.

This is the main reason to listen for the event `ready` or `load` on the document. Another solution is to add all the `<script>` tags at the end of the `<body>` tag.

Prefer the first solution -`ready` event-, since relying on something external -that you can't control- is not a very good practice.
