# Events

Thanks to the browser and Javascript we can interact with the user. Browsers offer a wide range of events that we can act on with Javascript.

Some of these actions are triggered by the user, such as clicks or keyboard press.

Others are triggered by other sources, such as when the browser finishes to load all the html.

This actions are called Events. The browsers allow us to add *listeners* to those events.

A *listener* -or *handler*- is just a function that will be called when that event is triggered.

The events are usually associated to a specific element. For example, you are not listening for the click on the whole page. You care when a single button is clicked.

### Vocabulary

A few words regarding events and a simple explanation:

- *event*: An action occurring in the browser.
- *trigger an event*: When that action happens.
- *listener* or *handler*: The function called when the event is triggered.

### Add a listener with jQuery

```Javascript
$('.my-button').on('click', function() {
  console.log('You clicked the button!');
});
```

As you can see it is very simple to add *listeners* with jQuery.

We use the `.on` method from the jQuery object. In this case, we selected the element with the class *my-button*. When we `click` on that element, the function will be called.

The first parameter passed to the function is the event type -`click` in this case-.

The second parameter is the *listener*. The function that will be called when the event is triggered. The function can be any function. Anonymous function defined there, a method of an object or a function defined previously.

```Javascript
function doSomething() {
  console.log('You clicked the button!');
}

$('.my-button').on('click', doSomething);
```

There are some events that are general, which means that the element to call `.on` is the general `document`.

For example, to listener for keyboard events:

```Javascript
$(document).on('keypress', function() {
  console.log('You pressed some key!');
});
```

[Here](https://developer.mozilla.org/en-US/docs/Web/Events) you have a list of events in the browser.

### The Event object in the listener

How do we know from the previous example, which key was pressed?

```Javascript
$(document).on('keypress', function() {
  console.log('You pressed some key!');
});
```

We added the listener in general, not a specific key. This can also happen when we attach a listener to more than one element.

The browser calls all the *listeners* passing a specific object as parameter. What is called as an Event Object.

```Javascript
$(document).on('keypress', function(e) {
  console.log('This is the event object:');
  console.log(e); // e is the name of the argument
});
```

This Event Object has information about the event itself. It has plenty of useful information.

For example, when it's a keyboard event `e.key` will be which key was pressed.

[Here](https://developer.mozilla.org/en-US/docs/Web/Events) you have a full list of the Event Object interfaces there are according to the type of event.

A few of the most common properties are:

- `preventDefault()`. It is a method that stops whatever that event was supposed to do. For example, it can prevent a link to redirect you somewhere.
- `currentTarget`. This is what specific element triggered the event.

  Useful when you attach a *listener* to more than one element and then you want to know which element was pressed.

- `key`. Already commented above.

### On Ready

One of the most common events and listeners used is when the page has finished loading all the files and it's ready.

In order to add a listener to it with JQuery you just use `$` function and pass the function.

```Javascript
$(function() {
  console.log('Executed when the page has been loaded');
});
```

Usually this is used to initialize your Javascript. So that it runs only when the page has been loaded.

```javascript
$(function() {
  // all the initialization code goes here
});
```

Initialization code means the code that will run immediately.

- Adding listeners to buttons
- Fetching data immediately
- Creating html elements
