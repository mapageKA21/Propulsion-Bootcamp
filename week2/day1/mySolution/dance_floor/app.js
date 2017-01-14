$(function() {
  let floor = $('<div id="floor"></div>');
  $('#container').append(floor);

  for (var i = 0; i < 5; i++) {
    for (var y = 0; y < 5; y++) {
      let grid = $('<div class="grid"</div>')
        $('#floor').append(grid);
    }
  }

  function randomizeGrid() {
    setInterval(function() {
      $('.grid').each(function(i, obj) {
        let random = Math.random();
        let random2 = Math.random();
        if (random > random2) {
          $(obj).addClass('active');
        } else {
          $(obj).removeClass('active');
        }
      });
    }, 1000)
  }

  randomizeGrid();
});