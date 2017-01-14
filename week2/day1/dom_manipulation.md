# DOM Manipulation

As a very simplistic approach, let's say that the Document Object Model or DOM is the HTML that we currently see in one page.

That means that DOM manipulation is about changing what the user sees. This can be accomplished with Javascript.

The browsers offer some specifics objects with an API to interact with the DOM. At the beginning of internet, each browser could implement some features using different interfaces.

### JQuery

We will learn DOM manipulation using jQuery. JQuery is a library created by Google a long time ago that uses the previously mentioned objects to interact with the DOM.

JQuery was very popular from the beginning because it took care of the different browser implementations. The developer using jQuery could focus on the code and the features he/she wanted to implement, rather without taking into account what browser would use it.

JQuery is still the most widely used library nowadays. So it's very important to be comfortable with it.

When you require your library with your script tag, the library creates a global variable `$`. This is nothing special, just the name of the variable.

### Require JQuery

There are two main ways to add jQuery to our project. We can either, download the file and require it in our html, or use a link to the file.

Go [here](https://code.jquery.com/) to check the links for the different versions of jQuery.
Or [here](https://jquery.com/download/) to download the files.

### What is `$`?

It is important to understand one thing from `$`. `$` is a function.

When you call the function, it will return a jQuery object.

**Let's repeat, `$` is not a jQuery object. `$` is a function.**

### jQuery object

A jQuery object is one ore more elements of the DOM, it could be a `<p>` tag, or two `<div>` tags wrapped with some specific jQuery methods.

```Javascript
var element = $('.some-class');
```

This simple example will store the jQuery object returned by calling the function into `element` variable.

### Selecting

Selecting means to get elements that are already present in the DOM.

In my HTML file I can have something like this:

```HTML
<div class="some-class"></div>
```

```Javascript
var element = $('.some-class');
```

We just selected our element using the name of the class.

As you might have noticed, we used a CSS selector when calling `$` function. This is how Selection works. You can pass almost any CSS Selector to the `$` function and it will selected the elements that match that selector.

You can use:
- Tags selectors: `p`, `div`, `h1`, ...
- Class selectors: `.some-class`, `.container`, ...
- Id selectors: `#some-id`, `#my-id`, ...
- Attribute selectors: `[type='text']`, `[attr='val']`, ...
- Combine two selectors: `p .some-class`, `div.container`, `input[type='text']`, ...
- Some pseudo selectors: `li:first-child`, `p:not(.some-class)`, ...

[Here](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Getting_started/Selectors) you have a list of all the selector that can be used.

### Creating

Selecting is for the elements that are present in the DOM. However, a lot of times we want to create some elements with Javascript.

With JQuery that is fairly simple. Just use the tag when calling `$` function.

```Javascript
var element = $('<p>');
```

Now `element` is a `<p>` tag. However, it is not present in the DOM. It is kind of floating in our Javascript code.

**Yes, the same function is used for more than one thing**

### Adding and removing to the DOM

Sometimes we want to add an element to the DOM, or add it somewhere else in the DOM than it is now.

For that we can use some methods on the jQuery object. Remember that the jQuery object is the return value of the `$` function.

```HTML
<div class="container"></div>
```

```Javascript
var container = $('.container');
var paragraph = $('<p>');
container.append(paragraph);
```

This will add a `<p>` to the HTML

```HTML
<div class="container">
  <p></p>
</div>
```

What append is really doing is just adding whatever we pass as argument between the opening and the closing tag.

There are other methods that do something similar:
- `prepend`
- `before`
- `after`
- `html`
- `text`

Review what they do in the [jQuery Docs](http://api.jquery.com/category/manipulation/).

### Element attributes

An attribute of an html element is a key-value pair inside the opening tag.

Examples:
- `<a href="/here">Here</a>`. `href` is an attribute
- `<input type="text" />`. `type` is an attribute
- `<div class="container"></div>`. `class` is an attribute

`class` and `id` are attributes. They just happen to be used a lot for CSS and have a specific syntax to select them.

JQuery allows us to easily manipulate attributes or an element. We can add, remove, change or query the value of an attribute.

Querying:
```html
<a href="/here">Here</a>
```

```Javascript
var link = $('a').attr('href');
// link => '/here'
```

`attr` is the method on jQuery that allows us to manipulate attributes.

Setting:
```Javascript
$('a').attr('href', '/there');
```

This will change the element to `<a href="/there">Here</a>`.

If the attribute does not exist it will add it.

Check the [docs](http://api.jquery.com/attr/).

There is a similar method on jQuery called `prop` that it's almost the same as `attr`.

### Class attribute

Since the `class` attribute is so common in html. JQuery added some method to interact with it easily.

Let's see if you can guess what do each of these methods do?

- `addClass`
- `hasClass`
- `removeClass`
- `toggleClass`

The last one is probably the only one tricky.
