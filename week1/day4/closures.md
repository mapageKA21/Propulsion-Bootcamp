# Closures

Closures are frequently used in JavaScript for object data privacy, in event handlers and callback functions, and in partial applications, currying, and other functional programming patterns.

Closure is just a name for a specific pattern. It is nothing new. We have already used closures without realizing it.

A closure is just a function accessing the outer function lexical scope.

Let's take a look at a simple example:

```javascript
function service() {
  var token = 'secretToken';
  return {
    printToken: function() {
      console.log('The token is ' + token);
    }
  }
}

var myService = service();

myService.printToken();
```

In this example `printToken` was defined inside the `service` scope, which means that it has access to all its scope. Which includes `token`. `token` is impossible to change from outside, and you could never expose if you wanted to.

More on closures in this [great article](http://renderedtext.com/blog/2015/11/18/closures-are-not-magic/)
