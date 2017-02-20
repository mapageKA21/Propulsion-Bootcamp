'use strict';

import StoryModel from './storyModel';
import $ from 'jquery';

export default class StoryCollection {

  constructor() {
    this.stories = [];
  }

  favorites() {
    return this.stories.filter((model) => model.favorite);
  }

  fetch() {
    return fetch('https://api.nytimes.com/svc/topstories/v2/home.json?api-key=2fb8d00df5084538b4606ee2ed89b19b')
      .then(function(res) {
        return res.json();
      })
      .then((data) => {
        data.results.forEach((storyAttrs) => {
          const story = new StoryModel(storyAttrs);
          this.stories.push(story);
        });
      });
  }

  find(modelId) {
    return this.stories.filter((model) => model.id === modelId)[0];
  }

  forEach(fn) {
    this.stories.forEach(fn);
  }
}
