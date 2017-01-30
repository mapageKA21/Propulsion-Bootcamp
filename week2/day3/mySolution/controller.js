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

$(function(){
  var container = $('#app');
  var controller = new Controller(container);
  controller.storiesIndex();

$('#app').on('click', '.fav', function(e) {
  console.log($(e.currentTarget.parentElement.children[2].childNodes[0]).text());
  console.log('clicked');
})

});


    // $('#film-list').on('click', '.starships', function(data) {
    //   let link = $(data.target).text();
    //   fetchStarship(link);
    // });
