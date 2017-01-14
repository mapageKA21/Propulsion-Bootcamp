# HTTP Requests from the browsers

We have seen some examples of requests:

- When entering the url in the browser
- The HTML requires a CSS or JS file
- The source of an image tag

However, there is another way to make a request programmatically from Javascript.

### XMLRequest from the browser

The browser gives an interface to make requests.

`XMLHttpRequest` is an API that provides client functionality for transferring data between a client and a server.

This way of making request is still widely used, but most of new projects won't use this.

To know how to use `XMLHttpRequest` check the [MDN Example](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/Using_XMLHttpRequest)

### JQuery Ajax

JQuery provides a much simpler interface to use `XMLHttpRequest`.

```Javascript
$.ajax({
  method: 'GET',
  url: '/books',
  success: function(data) {
    console.log(data);
  },
  error: function(err) {
    console.log('Some error...');
  }
});
```

`$.ajax` is a method that expects an object as a parameter. That object has the information about the request and what to do afterwards.

The main properties needed in this object are:

- `method`: This is the method of the request. Remember `GET`, `POST`, ... The default is `GET`.
- `url`: The url of the request. Duh.
- `success`: The value has to be a function that will be called if the request is successful - when status 2xx-.
- `error`: Similar to `success`, this is the function that will be called if there is any problem with the request.
- `data`: For `POST` and `PATCH` requests you sometimes want to sent data to the server, not just the request. This is the property where to add it.

### JQuery Ajax Promise Style

JQuery offers many different ways to make requests. They all do the same. The only difference is the interface.

```Javascript
$.get('/books').done(function(data) {
  console.log('in da success');
});
```

`$.get` and `$.post` are also methods to make Ajax requests with jQuery. We won't go into the details. But it's important that you know that they exist.

Check the jQuery [Documentation](https://api.jquery.com/category/ajax/) for more info.
