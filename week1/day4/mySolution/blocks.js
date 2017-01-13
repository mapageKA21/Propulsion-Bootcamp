(function() {

  let App = window.App = window.App || {};

  let Block = App.Block = function(position, width, height, color) {
    this.position = position;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  Block.prototype.render = function(context) {
    context.fillStyle = this.color;
    context.fillRect(this.position[0], this.position[1], this.width, this.height);
  }

})();