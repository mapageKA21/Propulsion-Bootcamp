# Advanced Listeners

Bugs on listeners not properly set are very common. There might be a lot of causes for that and sometimes debugging is hard.

### Common Pitfalls with Listeners

When working with Javascript it's very common that we create element and append them to the DOM.

It is also very common to add event listeners to element that might not yet be in the DOM.

```Javascript
$('.book-link').on('click', function() {
  console.log('You clicked the link');
});
```

What happens if `.book-link` is added with Javascript. This might mean that when we try to select it in order to add the listener, that element might not still be there.

You will encounter this issue on your projects. You will be creating elements based on some data coming from a request and then you will want to add a listener to the element.

There are two ways to solve this problem:

- Make sure that you have the element. That the selector does not return length 0.
- Use Dynamic Listeners.

### Dynamic Listeners

This is a common practice with jQuery. It is a way to add listeners to elements that are not yet in the DOM but they will be added.

```Javascript
$('.books').on('click', '.book-link', function() {
  console.log('you clicked the link!');
});
```

We use `.on` method just like any other regular listener. However, the second parameter, instead of being the callback is another selector -a string-.

What this is doing is attaching a listener to all the `.book-link` element that will be added in `.books` element.

In this case we need to make sure that `.books` is in the DOM when we add it. But the elements with `.book-link` can be added later on. The listener will be dynamically added at the same time that they are appended in `.books`.

`.book-link` elements need to be inside the `.books` element in order for the dynamic listener to work.
