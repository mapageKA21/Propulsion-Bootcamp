import SliderView from './views/sliderView';
import HorizontalScrollView from './views/horizontalScrollView';
import GridView from './views/gridView';
import StoryCollection from './storyCollection';
import $ from 'jquery';

export default class Controller {

  constructor(container) {
    this.collection = new StoryCollection();
    this.container = container;

    container.on('click', '.js-favorite', (e) => {
      const currentEl = $(e.currentTarget);
      const modelId = currentEl.data('modelId');
      const model = this.collection.find(modelId);
      model.toggleFavorite();
      this.storiesIndex();
    });
  }

  storiesIndex() {
    this.container.empty();

    const sliderView = new SliderView(this.collection);
    this.container.append(sliderView.render().el);

    const horizontalView = new HorizontalScrollView(this.collection);
    this.container.append(horizontalView.render().el);

    const gridView = new GridView(this.collection);
    this.container.append(gridView.render().el);
  }
}
