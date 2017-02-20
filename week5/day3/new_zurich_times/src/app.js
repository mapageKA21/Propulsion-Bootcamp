import Controller from './controller';
import $ from 'jquery';

import './styles/grid.css';
import './styles/horizontal.css';
import './styles/main.css';
import './styles/slider.css';

$(function () {
  'use strict';

  const container = $('.container');
  const controller = new Controller(container);

  controller.collection.fetch().then(controller.storiesIndex.bind(controller));
})
