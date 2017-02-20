'use strict';
import $ from 'jquery';

export default class StoryModel {

  constructor(attrs) {
    this.title = attrs.title;
    this.section = attrs.section;
    this.author = attrs.byline;
    this.body = attrs.abstract;
    this.multimedia = attrs.multimedia;
    this.favorite = false;
    this.id = attrs.url;
  }

  gridImage() {
    const format = Math.random() > 0.5 ? 'Normal' : 'thumbLarge';
    return this.multimedia.filter((media) => media.format === format)[0];
  }

  hasMedia() {
    return !!this.multimedia.length;
  }

  horizontalImage() {
    return this.multimedia.filter((media) => media.format === 'mediumThreeByTwo210')[0];
  }

  largeImage() {
    return this.multimedia.sort((media1, media2) => media2.width - media1.width)[0]
  }

  toggleFavorite() {
    this.favorite = !this.favorite;
  }
}
