import $ from 'jquery';

export default class GridItemView {

  constructor(model) {
    this.model = model;
    this.el = $('<figure>').addClass('grid-item');
  }

  render() {
    this.el.empty();
    const image = this.model.gridImage();
    const imageEl = $('<div>')
      .addClass('grid-image')
      .css({
        'background-image': `url(${image.url})`,
        'height': image.height
      });
    this.el.append(imageEl);

    const buttonText = this.model.favorite ? 'Remove Favorite' : 'Add to Favorites';
    const buttonEl = $('<button>')
      .text(buttonText)
      .data('modelId', this.model.id)
      .addClass('js-favorite');
    this.el.append(buttonEl);

    return this;
  }
}
