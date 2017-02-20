import $ from 'jquery';

export default class SlideVierw {

  constructor(model) {
    this.model = model;
    this.el = $('<div>').addClass('slide');
  }

  render() {
    this.el.empty();
    this.el.css('background-image', `url(${this.model.largeImage().url})`);

    return this;
  }
}
