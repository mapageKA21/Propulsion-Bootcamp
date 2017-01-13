(function() {

  let App = window.App = window.App || {};

  let Ball = App.Ball = function() {
    this.radius = 0.5;
    this.position = [5, 35];
    this.velocity = [0.2, -0.25];
  }

  Ball.prototype.render = function(context) {
    context.beginPath();
    context.arc(this.position[0], this.position[1], this.radius, 0, 2 * Math.PI, false);
    context.fillStyle = 'yellow';
    context.fill();
  }

  Ball.prototype.move = function(height, width) {
    let newXpos = this.position[0] + this.velocity[0];
    if (newXpos > width - 0.5) {
      this.velocity[0] = -this.velocity[0];
    }
    if (newXpos < 0.5) {
      this.velocity[0] = -this.velocity[0];
    }
    this.position[0] = newXpos;

    let newYpos = this.position[1] + this.velocity[1];
    if (newYpos < 0.5 ) {
      this.velocity[1] = -this.velocity[1];
    }
    if (newYpos > height - 0.5) {
      clearInterval(game.gameId);
      console.log('GAME OVER!!!!!!!!');
      this.velocity[1] = -this.velocity[1];
    }
    this.position[1] = newYpos;
  }

})();