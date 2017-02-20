var leftPaddle, rightPaddle;

function moveBall(ball, canvas) {
  var newBall = Object.assign({}, ball);
  if (onSideWall(ball, canvas)) newBall.direction[0] = -newBall.direction[0];
  if (onTopBottomWall(ball, canvas)) newBall.direction[1] = -newBall.direction[1];
  if (onLeftPaddle(ball, leftPaddle)) newBall.direction[0] = -newBall.direction[0];
  if (onRightPaddle(ball, rightPaddle)) newBall.direction[0] = -newBall.direction[0];
  newBall.position = [
    newBall.position[0] + newBall.direction[0],
    newBall.position[1] + newBall.direction[1]
  ];

  return newBall;
}

function movePaddle(paddle, canvas) {
  if (paddle.position[1] + paddle.direction[1] < 0
    || paddle.position[1] + paddle.direction[1] > canvas.height - paddle.height) {
      return;
  }
  paddle.position[1] += paddle.direction[1];
  paddle.position[0] += paddle.direction[0];
}

function paddleDown(paddle) {
  paddle.direction = [0, 4];
}

function paddleStop(paddle) {
  paddle.direction = [0, 0];
}

function paddleUp(paddle) {
  paddle.direction = [0, -4];
  console.log(paddle.direction);
}

function onLeftPaddle(ball, paddle) {
  var onSide = (ball.position[0] - ball.radius) < (leftPaddle.position[0] + leftPaddle.width) ;
  var onHeight = ball.position[1] > leftPaddle.position[1] &&
           ball.position[1] < (leftPaddle.position[1] + leftPaddle.height);

  return onSide && onHeight;
}

function onRightPaddle(ball, paddle) {
  var onSide = (ball.position[0] + ball.radius) > rightPaddle.position[0];
  var onHeight = ball.position[1] > rightPaddle.position[1] &&
           ball.position[1] < (rightPaddle.position[1] + rightPaddle.height);

  return onSide && onHeight;
}

function onSideWall(ball, canvas) {
  return ball.position[0] > canvas.width - ball.radius
    || ball.position[0] < ball.radius;
}

function onTopBottomWall(ball, canvas) {
  return (ball.position[1] > canvas.height - ball.radius)
  || (ball.position[1] < ball.radius);
}

function renderBackground(canvas) {
  var context = canvas.getContext('2d');
  context.fillStyle = "black";
  context.fillRect(0, 0, canvas.width, canvas.height);
  context.beginPath();
  context.moveTo(canvas.width / 2, 0);
  context.lineTo(canvas.width / 2, canvas.height);
  context.lineWidth = 5;
  // Linedash http://www.rgraph.net/blog/2013/january/html5-canvas-dashed-lines.html
  // Not supported by all browsers. Ask for a function that creats lines with a loop
  context.setLineDash([5]);
  context.strokeStyle = "#fff";
  context.stroke();
}

function renderBall(ball, canvas) {
  var context = canvas.getContext('2d');
  context.beginPath();
  context.arc(ball.position[0],ball.position[1],ball.radius,0,2*Math.PI);
  context.fillStyle = "#fff";
  context.fill();
}

function renderPaddle(paddle, canvas) {
  var context = canvas.getContext('2d');
  context.beginPath();
  context.rect(paddle.position[0], paddle.position[1], paddle.width, paddle.height);
  context.fillStyle = '#fff';
  context.fill();
}

function render(canvas, ball) {
  var newBall = moveBall(ball, canvas);
  movePaddle(leftPaddle, canvas);
  movePaddle(rightPaddle, canvas);
  renderBackground(canvas);
  renderBall(newBall, canvas);
  renderPaddle(leftPaddle, canvas);
  renderPaddle(rightPaddle, canvas);
  setTimeout(function () {
    render(canvas, newBall);
  }, 16);
}

function play(canvas, width, height) {
  canvas.width = width;
  canvas.height = height;
  var ball = {
    direction: [3, 3],
    position: [width / 2, height /2],
    radius: 20,
  };
  leftPaddle = {
    height: 100,
    width: 20,
    position: [20, 200],
    direction: [0, 0]
  };
  rightPaddle = {
    height: 100,
    width: 20,
    position: [width - 40, 200],
    direction: [0, 0]
  };
  render(canvas, ball);
}

document.addEventListener('keydown', function(e) {
  switch (e.key) {
    case 'w':
      paddleUp(leftPaddle);
      return;
    case 's':
      paddleDown(leftPaddle);
      return;
    case 'o':
      paddleUp(rightPaddle);
      return;
    case 'l':
      paddleDown(rightPaddle);
      return;
  }
});

document.addEventListener('keyup', function(e) {
  switch (e.key) {
    case 'w':
      paddleStop(leftPaddle);
      return;
    case 's':
      paddleStop(leftPaddle);
      return;
    case 'o':
      paddleStop(rightPaddle);
      return;
    case 'l':
      paddleStop(rightPaddle);
      return;
  }
});
