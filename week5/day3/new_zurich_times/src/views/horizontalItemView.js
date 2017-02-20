import $ from 'jquery';

export default class HorizontalItemView {

  constructor(model) {
    this.model = model;
    this.el = $('<div>').addClass('item');
  }

  render() {
    this.el.empty();
    this.el.css('background-image', `url(${this.model.horizontalImage().url})`);

    return this;
  }
}
