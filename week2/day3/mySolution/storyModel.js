var StoryModel = function(fetchObject) {
  this.title = fetchObject.title;
  this.section = fetchObject.section;
  this.author = fetchObject.byline;
  this.body = fetchObject.abstract;
  this.image = fetchObject.multimedia.filter(function(media) {
    return media.width > 200;
  })[0];
}

// (function () {
//   'use strict';

//   var App = window.App = window.App || {};

//   var StoryModel = App.StoryModel = function(attrs) {
//     this.title = attrs.title;
//     this.section = attrs.section;
//     this.author = attrs.byline;
//     this.body = attrs.abstract;
//   }
// })();
