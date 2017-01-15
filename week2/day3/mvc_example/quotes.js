$(function () {
  var container = $('#app');
  var controller = new Controller(container);

  controller.collection.fetch().then(function() {
    controller.quotesIndex();
  });
});

// Model Quote, just data.
var Quote = function(quote) {
  this.quote = quote;
  this.liked = false;
}

// Collection Quotes. List of Model Quotes
var QuotesCollection = function() {
  this.quotes = [];
}

QuotesCollection.prototype.fetch = function() {
  var collection = this;
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

// Each of the small <p> tags rendered is a View
var QuoteView = function(model) {
  this.model = model;
  this.el = $('<p>').addClass('quote'); // this is where the data will be rendered
}

QuoteView.prototype.render = function () {
  this.el.empty(); // empty the element;

  this.el.append(this.model.quote);

  return this; // for chaining purposes
}

// Putting together the Collection and the Views
var Controller = function(container) {
  this.container = container;
  this.collection = new QuotesCollection();
}

Controller.prototype.quotesIndex = function() {
  var controller = this; // Explain to yourself why I did this
  this.collection.quotes.forEach(function (quote) {
    var view = new QuoteView(quote);
    view.render(); // calling render populates the element created in the initialization

    controller.container.append(view.el);
  });
}
