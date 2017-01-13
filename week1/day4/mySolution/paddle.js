(function() {

  let App = window.App = window.App || {};

  let Paddle = App.Paddle = function() {
    this.position = [5, 38.5];
    this.width = 4;
    this.height = 1;
    this.color = "white";
  }

  Paddle.prototype.render = function(context) {
    context.fillStyle = this.color;
    context.fillRect(this.position[0], this.position[1], this.width, this.height);
  }

  Paddle.prototype.move = function(direction, width) {
    if (direction === 'left') {
      if (this.position[0] <= 0) return;
      this.position[0] = this.position[0] - 2;
    }
    if (direction === 'right') {
      if (this.position[0] > 25.7) return;
      this.position[0] = this.position[0] + 2;
    }
  }

})();
