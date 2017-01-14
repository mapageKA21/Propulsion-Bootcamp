$(function() {
  let floor = $('<div id="floor"></div>');
  $('#container').append(floor);

  for (var i = 0; i < 5; i++) {
    for (var y = 0; y < 5; y++) {
      let grid = $('<div class="grid"</div>');
        $('#floor').append(grid);
    }
  }

  //$x('//*');  ????
  let childs;
  let currentTarget;
  $('.grid').on('click', function(e) {
    console.log(e);
    childs = e.currentTarget.parentElement.childNodes;
    e.currentTarget.parentElement.childNodes.forEach(function(node) {
      if ($(node).hasClass('active')) $(node).removeClass('active');
    })
    $(e.currentTarget).addClass('active');
    currentTarget = $(e.currentTarget);
  });

  const matrix = [
  [0,1,2,3,4], 
  [5,6,7,8,9], 
  [10,11,12,13,14], 
  [15,16,17,18,19], 
  [20,21,22,23,24]
  ];

  checkPosition = function(num) {
    let position = [];
    for (let i = 0; i < matrix.length; i++) {
      let arrayRow = matrix[i];
      for (j = 0; j < arrayRow.length; j++) {
        if (matrix[i][j] === num) {
          position.push(i);
          position.push(j);
        }
      }
    }
    return position;
  }

  $(document).on('keypress',(function(e) {

    if (e.key === 'x') {
      for (var i = 0; i < childs.length; i++) {
        if ($(childs[i]).hasClass('active')) {
          let position = checkPosition(i);
          if (position[0] === 4) {
            $(childs[i]).removeClass('active');
            $(childs[matrix[0][position[1]]]).addClass('active');
            return;
          }
          else 
            $(childs[i]).removeClass('active');
            $(childs[matrix[position[0]+1][position[1]]]).addClass('active');
            return;
        }
      }
    }

    if (e.key === 'w') {
      for (var i = 0; i < childs.length; i++) {
        if ($(childs[i]).hasClass('active')) {
          let position = checkPosition(i);
          if (position[0] === 0) {
            $(childs[i]).removeClass('active');
            $(childs[matrix[4][position[1]]]).addClass('active');
            return;
          }
          else 
            $(childs[i]).removeClass('active');
            $(childs[matrix[position[0]-1][position[1]]]).addClass('active');
            return;
        }
      }
    }

    if (e.key === 'a') {
      for (var i = 0; i < childs.length; i++) {
        if ($(childs[i]).hasClass('active')) {
          let position = checkPosition(i);
          if (position[1] === 0) {
            $(childs[i]).removeClass('active');
            $(childs[matrix[position[0]][4]]).addClass('active');
            return;
          }
          else 
            $(childs[i]).removeClass('active');
            $(childs[matrix[position[0]][position[1]-1]]).addClass('active');
            return;
        }
      }
    }

    if (e.key === 'd') {
      for (var i = 0; i < childs.length; i++) {
        if ($(childs[i]).hasClass('active')) {
          let position = checkPosition(i);
          if (position[1] === 4) {
            $(childs[i]).removeClass('active');
            $(childs[matrix[position[0]][0]]).addClass('active');
            return;
          }
          else 
            $(childs[i]).removeClass('active');
            $(childs[matrix[position[0]][position[1]+1]]).addClass('active');
            return;
        }
      }
    }
  }));

});
