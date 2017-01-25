const canvas = document.getElementById('canvas'); //

const Ball = function() {
  this.radius = 0.5;
  this.position = [5, 35];
  this.velocity = [0.1, -0.1];
}

Ball.prototype.render = function(context) {
  context.beginPath();
  context.arc(this.position[0], this.position[1], this.radius, 0, 2 * Math.PI, false);
  context.fillStyle = 'yellow';
  context.fill();
}

Ball.prototype.move = function(height, width) {
  let newXpos = this.position[0] + this.velocity[0];
  let newYpos = this.position[1] + this.velocity[1];
  
  if (newXpos > width) this.velocity[0] = -this.velocity[0];
  if (newXpos < 0) this.velocity[0] = -this.velocity[0];
  if (newYpos < 0 ) this.velocity[1] = -this.velocity[1];
  if (newYpos > height) this.velocity[1] = -this.velocity[1];

  this.position[0] = newXpos;
  this.position[1] = newYpos;
}

const Game = function(canvas) {
  this.canvas = canvas;
  this.context = canvas.getContext('2d');
  const scale = 10;
  this.context.scale(scale, scale);
  this.height = canvas.height / scale;
  this.width = canvas.width / scale;
  this.ball = new Ball();
  this.blocks = this.createBlocks();
}

Game.prototype.createBlocks = function() {
  
  let color = function() {
    const colors = ["red", "green", "pink", "blue", "brown", "grey", "orange", "purple", "lime"];
    const random = Math.floor(Math.random() * colors.length);
    return colors[random];
  }

  let posX = [5, 9, 13, 17, 21];
  let posY = [4, 5, 6, 7];
  const blocks = [];

  for (let i = 0; i < posX.length; i ++) {
    for (let y = 0; y < posY.length; y++) {
      const newBlock = new Block([posX[i], posY[y]], 4, 1, color());
      blocks.push(newBlock);
    }
  }

  return blocks;
}

Game.prototype.play = function() {
  const that = this;
  setInterval(function() {
    game.reset(); // reset canvas, which means, paint it black
    game.ball.move(that.height, that.width);
    game.ball.render(that.context);
    that.blocks.forEach(function(block){
      return block.render(that.context);
    });
  }, 10);
}

Game.prototype.reset = function() {
  this.context.fillStyle = 'black';
  this.context.fillRect(0, 0, this.width, this.height);
}

const Block = function(position, width, height, color) {
  this.position = position;
  this.width = width;
  this.height = height;
  this.color = color;
}

Block.prototype.render = function(context) {
  context.fillStyle = this.color;
  context.fillRect(this.position[0], this.position[1], this.width, this.height);
}

let game = new Game(canvas);
game.play();
