var StoryItemView = function(model) {
  this.model = model;
  this.el = $('<div>').addClass('column col-2');
}

StoryItemView.prototype.render = function() {
  this.el.empty();

  var cardEl = $('<div>').addClass('card');
  var imageEl = this.model.image
    ? $('<img>').attr('src', this.model.image.url).addClass('img-responsive')
    : $('<img>');
  var headerEl = $('<div>').addClass('card-title').text(this.model.title)
  cardEl
    .append($('<button>Add to favourites</button>'))
    .append($('<div>').addClass('card-image').html(imageEl))
    .append($('<div>').addClass('card-header').html(headerEl))
    .append($('<div>').addClass('card-body').text(this.model.body));

  this.el.append(cardEl);

  return this;
}
