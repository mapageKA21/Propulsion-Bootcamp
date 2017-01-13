(function() {

  let App = window.App = window.App || {};

  let Game = App.Game = function(canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext('2d');
    const scale = 10;
    this.context.scale(scale, scale);
    this.height = canvas.height / scale;
    this.width = canvas.width / scale;
    this.ball = new window.App.Ball();
    this.blocks = this.createBlocks();
    this.paddle = new window.App.Paddle();
    this.gameId;
    this.result = 0;
  }

  Game.prototype.createBlocks = function() {
    
    let color = function() {
      const colors = ["red", "green", "pink", "blue", "brown", "grey", "orange", "purple", "lime"];
      const random = Math.floor(Math.random() * colors.length);
      return colors[random];
    }

    // RANDOM DISTRIBUTION:
    let posX = [1, 5, 9, 13, 17, 21, 25, 1, 5, 9, 13, 17, 21, 25, 1, 5, 9, 13, 17, 21, 25];
    let posY = [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23];
    const blocks = [];
    
    for (let i = 0; i < 20; i ++) {
      let varX = Math.floor(Math.random() * posX.length);
      let varY = Math.floor(Math.random() * posY.length);
      const newBlock = new window.App.Block([posX[varX], posY[varY]], 4, 1, color());
      let indexX = posX.indexOf(varX);
      posX.splice(indexX, 1);
      let indexY = posY.indexOf(varY);
      posY.splice(indexY, 1);
      blocks.push(newBlock);
    }
    
    // NORMAL DISTRIBUTION:
    // let posX = [5, 9, 13, 17, 21];
    // let posY = [4, 5, 6, 7]
    // const blocks = [];
    // for (let i = 0; i < posX.length; i ++) {
    //   for (let y = 0; y < posY.length; y++) {
    //     const newBlock = new Block([posX[i], posY[y]], 4, 1, color());
    //     blocks.push(newBlock);
    //   }
    // }

    return blocks;
  }

  Game.prototype.play = function() {
    const that = this;
      game.gameId = setInterval(function() {
      game.reset(); // reset canvas, which means, paint it black
      game.checkCollisions();
      game.ball.move(that.height, that.width);
      game.ball.render(that.context);
      game.resultat(that.context);
      game.checkPaddleCollision();
      // game.isGameOver();
      game.paddle.render(that.context);
      that.blocks.forEach(function(block){
        return block.render(that.context);
      });
    }, 10);
  }

  Game.prototype.resultat = function(context) {
    let res = game.result;
    context.font = '1.5pt Calibri';
    context.fillStyle = 'white';
    context.fillText(`${res}`, 0.3, 2);
  }

  Game.prototype.checkCollisions = function() {
    let ballX = game.ball.position[0];
    let ballY = game.ball.position[1];

    for (let i = 0; i < game.blocks.length; i++) {

      if ((ballY <= game.blocks[i].position[1] + 1.5) && (ballY >= game.blocks[i].position[1] + 1.45)
         && (ballX >= game.blocks[i].position[0]) && (ballX <= game.blocks[i].position[0] + 4.5)) {
            game.ball.velocity[1] = -game.ball.velocity[1];
            game.blocks.splice(i, 1);
            game.result ++;
            if (game.blocks.length === 0) game.blocks = game.createBlocks();
            return;
      }
      else if ((ballY <= game.blocks[i].position[1] - 0.5) && (ballY >= game.blocks[i].position[1] - 0.55)
         && (ballX >= game.blocks[i].position[0]) && (ballX <= game.blocks[i].position[0] + 4.5)) {
           game.ball.velocity[1] = -game.ball.velocity[1];
           game.blocks.splice(i, 1);
           game.result ++;
           if (game.blocks.length === 0) game.blocks = game.createBlocks();
           return;
      }
      else if (((ballX <= game.blocks[i].position[0] + 4.5) && (ballX >= 17.5) &&
         (ballY >= game.blocks[i].position[1]) && (ballY <= game.blocks[i].position[1] + 1.5)) || 
         ((ballX >= game.blocks[i].position[0] - 0.5) && (ballX < 17.5) &&
         (ballY >= game.blocks[i].position[1]) && (ballY <= game.blocks[i].position[1] + 1.5))) {
           game.ball.velocity[0] = -game.ball.velocity[0];
           game.blocks.splice(i, 1);
           game.result ++;
           if (game.blocks.length === 0) game.blocks = game.createBlocks();
           return;
      }
    }
  }

  Game.prototype.checkPaddleCollision = function() {
    let ballX = game.ball.position[0];
    let ballY = game.ball.position[1];

    if ((ballY <= game.paddle.position[1] - 0.5) && 
       (ballY >= game.paddle.position[1] - 0.55) &&
       (ballX >= game.paddle.position[0]) &&
       (ballX <= game.paddle.position[0] + 4.5)) {
         game.ball.velocity[1] = -game.ball.velocity[1];
         return;
    }
  }

  // Game.prototype.isGameOver = function() {
  //   let ballY = game.ball.position[1];
  //   if (ballY >= 38.5) {
  //     // clearInterval(game.gameId);
  //     console.log('GAME OVER!!!!!!!!');
  //   }
  // }

  Game.prototype.reset = function() {
    this.context.fillStyle = 'black';
    this.context.fillRect(0, 0, this.width, this.height);
  }

  document.addEventListener('keydown', function(event) {
    if (event.keyCode === 37) game.paddle.move('left', game.width);
    if (event.keyCode === 39) game.paddle.move('right', game.width);
  });

})();

const canvas = document.getElementById('canvas'); //

let game = new window.App.Game(canvas);

const startGame = function (){
  game.play();
  let parent = document.getElementById("main");
  let child = document.getElementById("start");
  parent.removeChild(child);
}
