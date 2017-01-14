$(function() {

  createGrid = function(num) {
    // create the grid on the screen numXnum
    let floor = $('<div id="floor"></div>');
    $('#container').append(floor);

    for (var i = 0; i < num; i++) {
      for (var y = 0; y < num; y++) {
        let grid = $('<div class="grid"</div>');
          $('#floor').append(grid);
      }
    }

    // create the 2dmatrix for example: [[0,1,2], [0,1,2], [0,1,2]]
    // no actually needed
    let row = [];
    for(let i = 0; i < num; i++) {
      row.push(i);
    }
    let matrix = [];
    for(let j = 0; j < num; j++) {
      matrix.push(row);
    }
    return matrix;

  }
  
  let matrix = createGrid(10);
  let a;
  let b;
  let c;
  let d;
  let childs = $('#floor')[0].childNodes;
  let intervalId;

  createSnake = function(posA, posB, posC, posD) {
    let oldTail = $('#floor')[0].childNodes[d];
    $(oldTail).removeClass('active');

    let head = $('#floor')[0].childNodes[posA];
    $(head).addClass('head');
    let node1 = $('#floor')[0].childNodes[posB];
    $(node1).removeClass('head');
    $(node1).addClass('active');
    let node2 = $('#floor')[0].childNodes[posC];
    $(node2).addClass('active');
    let tail = $('#floor')[0].childNodes[posD];
    $(tail).addClass('active');

    b = posB;
    c = posC;
    d = posD;
  }

  checkHeadPosition = function() {
    let index;
    for (var i = 0; i < childs.length; i++) {
      if ($(childs[i]).hasClass('head')) {
        index = i;
      }
    }
    return index;
  }

  moveSnake = function(where) {
    intervalId = setInterval(function() {
      move(where);
    }, 150)
  }

  move = function(where) {
    if (where === 'down') {
      let position = checkHeadPosition();
        if (position > 89) {
          createSnake(position - 90, position, b, c);
          return;
        }
        else if ($(childs[position + 10]).hasClass('active')) {
          return;
        }
        else 
          createSnake(position + 10, position, b, c);
          return;
    }
    if (where === 'up') {
      let position = checkHeadPosition();
        if (position < 10) {
          createSnake(position + 90, position, b, c);
          return;
        }
        else if ($(childs[position - 10]).hasClass('active')) {
          return;
        }
        else 
          createSnake(position - 10, position, b, c);
          return;
    }
    if (where === 'left') {
      let position = checkHeadPosition();
        if (position % 10 === 0) {
          createSnake(position + 9 , position, b, c);
          return;
        }
        else if ($(childs[position - 1]).hasClass('active')) {
          return;
        }
        else 
          createSnake(position - 1, position, b, c);
          return;
    }
    if (where === 'right') {
      let position = checkHeadPosition();
        if (position % 10 === 9) {
          createSnake(position - 9 , position, b, c);
          return;
        }
        else if ($(childs[position + 1]).hasClass('active')) {
          return;
        }
        else 
          createSnake(position + 1, position, b, c);
          return;
    }
  }

  $(document).on('keypress',(function(e) {
    let position = checkHeadPosition();
    if (e.key === 'x' && !$(childs[position + 10]).hasClass('active')) {
      clearInterval(intervalId);
      moveSnake('down');
    }
    if (e.key === 'w' && !$(childs[position - 10]).hasClass('active')) {
      clearInterval(intervalId);
      moveSnake('up');
    }
    if (e.key === 'a' && !$(childs[position - 1]).hasClass('active')) {
      clearInterval(intervalId);
      moveSnake('left');
    }
    if (e.key === 'd' && !$(childs[position + 1]).hasClass('active')) {
      clearInterval(intervalId);
      moveSnake('right');
    }  }));

  createSnake(08, 07, 06, 05);

});
