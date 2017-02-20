import SlideView from './slideView';
import $ from 'jquery';

export default class SliderView {

  constructor(collection) {
    this.collection = collection;
    this.el = $('<div>').addClass('container-slider');
  }

  renderArrow(side) {
    const className = 'arrow__' + side;
    const text = side === 'left' ? '&lt' : '&gt';
    const arrowEl = $('<div>')
      .addClass(`arrow ${className}`)
      .html(`<span>${text}</span>`);
    arrowEl.on('click', () => {
      const firstSlide = $('.slide:first-child');
      const left = firstSlide.position().left
      const newTranslate = side === 'left' ? left - 1200 : left + 1200;
      $('.slide').css('transform', `translateX(${newTranslate}px)`);
    });

    return arrowEl;
  }

  render() {
    this.el.empty();

    this.el.append(this.renderArrow('left'));

    const containerEl = $('<div>')
      .addClass('holder')
      .css('width', `${this.collection.stories.length}00%`);
    const wrapperEl = $('<div>')
      .addClass('slider')
      .append(containerEl);
    this.el.append(wrapperEl);

    this.el.append(this.renderArrow('right'));

    this.collection.forEach((model) => {
      if (model.hasMedia()) {
        const slideView = new SlideView(model);
        containerEl.append(slideView.render().el);
      }
    });

    return this;
  }
}
