import GridItemView from './gridItemView';
import $ from 'jquery';

export default class GridView {

  constructor(collection) {
    this.collection = collection;
    this.el = $('<div>').addClass('container-grid');
  }

  render() {
    this.el.empty();
    const gridContainer = $('<div>').addClass('grid');
    this.el.append(gridContainer);

    this.collection.forEach((model) => {
      if (model.hasMedia()) {
        const gridItemView = new GridItemView(model);
        gridContainer.append(gridItemView.render().el);
      }
    });

    return this;
  }
}
