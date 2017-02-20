import Controller from './Controller';
import './styles.css';

function onReady() {
  new Controller();
}

function ready(fn) {
  if (document.readyState != 'loading'){
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}

ready(onReady);
