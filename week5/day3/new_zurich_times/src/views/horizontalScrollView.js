import $ from 'jquery';
import HorizontalItemView from './horizontalItemView';

export default class HorizontalScrollView {

  constructor(collection) {
    this.collection = collection;
    this.el = $('<div>').addClass('container-horizontal');
  }

  renderArrow(side) {
    const className = 'arrow__' + side;
    const text = side === 'left' ? '&lt' : '&gt';
    const arrowEl = $('<div>')
      .addClass('arrow ' + className)
      .html(`<span>${text}</span>`);
    arrowEl.on('click', () => {
      const left = $('.horizontal-scroll').position().left;
      const newTranslate = side === 'left' ? left - 1200 : left + 1200;
      $('.horizontal-scroll').css('transform', `translateX(${newTranslate}px)`);
    });

    return arrowEl;
  }

  render() {
    this.el.empty();

    this.el.append(this.renderArrow('left'));

    const containerEl = $('<div>').addClass('horizontal-scroll');
    const wrapperEl = $('<div>')
      .addClass('wrapper')
      .append(containerEl);
    this.el.append(wrapperEl);

    this.el.append(this.renderArrow('right'));


    this.collection.favorites().forEach((model) => {
      if (model.hasMedia()) {
        var horizontalItemView = new HorizontalItemView(model);
        containerEl.append(horizontalItemView.render().el);
      }
    });

    return this;
  }
}
