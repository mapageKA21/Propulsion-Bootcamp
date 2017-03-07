var INCR = 'increment';
var DECR = 'decrement'

var reducer = function(state = 0, action) {
  switch (action.type) {
    case INCR:
      return state + 1;
    case DECR:
      return state - 1;
    default:
      return state;
  }
}

var store = Redux.createStore(reducer);
store.subscribe(render);

function render() {
  var el = document.getElementById('counter');
  el.innerHTML = store.getState();
}

document
  .getElementById('increment')
  .addEventListener('click', function() {
    store.dispatch({ type: INCR });
  });

document
  .getElementById('decrement')
  .addEventListener('click', function() {
    store.dispatch({ type: DECR });
  });

render();