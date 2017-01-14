# Fetch

`fetch` is a new interface that most browsers offer to make requests from the client.

It is a substitute of the `XMLHttpRequest`. This means that you either use Ajax or `fetch`. They both accomplish the same purpose.

The difference is that `fetch` is implemented in the browser, whereas the Ajax we have seen comes from jQuery. To use `fetch` we don't need any library.

Not all the browser support fetch. The main ones do though. [Here](http://caniuse.com/#search=fetch) you can check the support in the browsers.

### How to use Fetch

We are going to use `fetch` mainly for requests.

```Javascript
fetch('/books')
  .then(function(response) {
    return response.json();
  })
  .then(function(data) {
    console.log('This is our data', data); // data from `/books`
  });
```

`fetch` returns a promise. This is the most important. Which means we can use `.then` and `.catch` as well.

The value passed to the function in the  first `.then` is a `Response` object. This object has information about the response, not just the data. It has the status of the response, headers, ...

What will be more useful for us will be the data of the response. In order to get the body -or data- of the response there are different ways depending on the type of that data. Most of times it will be a JSON string. Which means that we want to parse it.

In order to parse a JSON body we call `.json()` on the response object. It's very important to notice that this returns a promise. Not the data itself.

**DO NOT DO THIS**

```Javascript
fetch('/books')
  .then(function(response) {
    var data = response.json();
    console.log('This is our data', data); // This will be a Promise
  });
```

If you remember the lesson of promises, we can chain them. This is why the next `.then` will receive the data returned from the `.json()`.

### Type of request with Fetch

In order to make another type of request when using fetch, we can create our own `Request` object.

`fetch` expects as a parameter, either a `string` or a `Request` object. If it's a string, it will be a `GET` request by default.

```Javascript
var myHeaders = new Headers();

var myInit = { method: 'POST',
               headers: myHeaders
             };

var myRequest = new Request('/books', myInit);

fetch(myRequest)
  .then(function(response) {
    return response.json();
  })
  .then(function(data) {
    console.log('This is our data', data);
  });
```

*Do not worry too much about headers for now. You will go deeper into networking in the following weeks.*

As you can see, when creating a `Request` you pass two parameters: url and options. In the options there is a property `method` where we can specify the type of request.

This example will make a `POST` request to `/books`.

For further information check the [MDN Documentation](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch) on how to use `fetch`.
