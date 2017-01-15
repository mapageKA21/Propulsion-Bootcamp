# Model View Controller

Model View Controller or MVC is one of the most famous Design Patterns.

We will learn how to apply this pattern to our front end with Javascript.

### Design Pattern

From Wikipedia:

```
In software engineering, a software design pattern is a general reusable solution
to a commonly occurring problem within a given context in software design
```

There are several problems that occur over and over in the software world. Those problems have been faced by really smart people before. Some of those smart people shared their solutions to those same problems with other developers and created the Design Patterns.

Design Patters is a solution at a high level. They are not related to any programming language in particular.

One of the bibles of Design Patterns is [Design Patterns: Elements of Reusable Object-Oriented Software](https://en.wikipedia.org/wiki/Design_Patterns) by the Gang of Four. Totally recommended reading after the bootcamp.

### MVC - Model View Controller

Perhaps the most used pattern in web development.

The main idea is to separate the visualization from the data. Hence the Model and the View in the name. The Controller is used to glue both together.

This pattern is applied in many of the frontend frameworks such as Backbone, Ember.js and AngularJS.

To illustrate this in a specific case, we will be using a List of [Ron Swanson](https://en.wikipedia.org/wiki/Ron_Swanson) quotes.

**DO NOT follow along the example**

The example code is in this [repo]. The following snippets are just to explain the specific concepts. They do not work by themselves.

### Model

Models manage the data for an application.

Models do not care about how the data is going to be displayed. They just handle the data. They have to provide a way to read and write.

```javascript
var Quote = function(quote) {
  this.quote = content;
  this.liked = false;
}
```

This `Quote` class will also apply a method to set the Quota as liked.

```javascript
Quote.prototype.like = function() {
  this.liked = true;
}
```

This could be all is needed for the Model at this point.

Models have the responsibility to retrieve and persist the data if that applies to our app.

For example, making the request to get the information of the Quote. Also once some attribute has changed, make a request to the backend so that those changes are persisted in the data base.

```javascript
Quote.prototype.fetch = function() {
  fetch('someUrl.com')
    .then(function(res) {
      return res.json();
    })
    .then(function(quote) {
      this.quote = quote;
    });
}
```

The attributes of the Quote could be there when we create it and we could pass them in the initialization. Or they might be retrieved from backend.

### View

View handles how the data is displayed.

No data should be stored in the View. A View can be coupled with a Model. In our example, we will have that case.

```javascript
var QuoteView = function(model) {
  this.model = model;
  this.el = $('<p>').addClass('quote'); // this is where the data will be rendered
}
```

The View usually applies one method that will take care of displaying the data. In our case to render it into an HTML Element.

```javascript
QuoteView.prototype.render = function () {
  this.el.empty(); // empty the element;

  this.el.append(this.model.quote);

  return this; // for chaining purposes
}
```

This will create the element with the content information. However, this won't attach it to the DOM. This will be responsibility of the Controller.

### Controller

Controller are the glue between the View and the Model.

In this specific case the Controller will also have access to the DOM and handle user interaction. Listening for user events could make the proper changes to events or models.

```javascript
var Controller = function(container) {
  this.container = container;
  this.quotes = [ /* a bunch of Quote Models here */ ];
}
```

Let's say that we have the following HTML

```HTML
<body>
  <div id="app"></div>
</body>
```

Then in order the start the whole app we could do the following.

```javascript
$(function () {
  var container = $('#app');
  var controller = new Controller(container);

  controller.quotesIndex();
})
```

`quotesIndex` will create a view for each Quote and render it. Then it will attach the element for each view to the DOM.

```javascript
Controller.prototype.quotesIndex = function() {
  var controller = this; // Explain to yourself why I did this
  this.quotes.forEach(function (quote) {
    var view = new QuoteView(quote);
    view.render(); // calling render populates the element created in the initialization

    controller.container.append(view.el);
  });
}
```

### Collection

A Collection is a way to group models together.

Instead of having a list of models, we have a Collection.

```javascript
var QuotesCollection = function() {
  this.quotes = [];
}
```

This gives is more flexibility if we want to work with the whole list. For example, you could have a method on the collection that will return only a subset. Or the whole collection might be fetched from an API.

```javascript
QuotesCollection.prototype.liked = function() {
  return this.quotes.filter(function(quote) {
    return quote.liked;
  });
}
```

```javascript
QuotesCollection.prototype.fetch = function() {
  var collection = this;
  // we return the promise so that we can use it
  return fetch('http://ron-swanson-quotes.herokuapp.com/v2/quotes/10')
    .then(function(res) {
      return res.json();
    })
    .then(function(quotes) {
      collection.quotes = quotes.map(function(quote) {
        return new Quote(quote);
      });
    });
}
```

### Full example

As we mentioned above, the previous snippets of code do not work by themselves.

Please, review the completed [example](mvc_example/quotes.js).
