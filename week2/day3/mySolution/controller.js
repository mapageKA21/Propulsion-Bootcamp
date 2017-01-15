var Controller = function(container) {
  this.container = container;
  this.collection = new StoryCollection();
  var that = this;
    this.collection
      .fetch()
      .then(function() {
        that.storiesIndex();
      });
}

Controller.prototype.storiesIndex = function() {
  var storyIndexView = new StoryIndexView(this.collection);
  this.container.append(storyIndexView.render().el);
}


