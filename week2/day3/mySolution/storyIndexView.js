var StoryIndexView = function(collection) {
  this.collection = collection; //array de objectes amb title prop
  this.el = $('<div>').addClass('story');
}

StoryIndexView.prototype.render = function() {
  this.el.empty();
  var headerEl = $('<h2>').text('Stories');
  this.el.append(headerEl);
  var storiesEl = $('<div>').addClass('columns');

  this.collection.stories.forEach(function(story) {
    var storyView = new StoryItemView(story);
    storiesEl.append(storyView.render().el);
  })

  this.el.append(storiesEl);

  return this;
}
