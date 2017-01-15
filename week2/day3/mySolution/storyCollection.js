var StoryCollection  = function() {
  this.stories = [];
}

StoryCollection.prototype.fetch = function() {
  var that = this;
  return fetch('https://api.nytimes.com/svc/topstories/v2/home.json?api-key=911ec8f9483b4779a783d33a11e31574')
    .then(function(res) {
    return res.json();
    })
    .then(function(data) {
      data.results.forEach(function(result) {
        var newStory = new StoryModel(result);
        that.stories.push(newStory);
      });
    })
}
