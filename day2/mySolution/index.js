let Trivial = function() {
  this.questions = [];
  this.totalQuestions = 0;
  this.players = [];
  this.currentPlayer = 0;
  this.category;
}

Trivial.prototype.setPlayers = function() {
  let answer = prompt(`Please add the player names`, `leave it blank if you are done`);
  while (answer !== `leave it blank if you are done`) {
    let player = new Player(answer);
    this.addPlayer(player);
    answer = prompt(`Please add the player names`, `leave it blank if you are done`);
  }
}

Trivial.prototype.setCategory = function() {
  let answer = prompt(`Select CATEGORY`, `GEO or SPORT`);
  if (answer.toUpperCase() === 'GEO' || answer.toUpperCase() === 'SPORT') {
    this.category = answer.toUpperCase();
    return;
  }
  else this.setCategory();
}

Trivial.prototype.askQuestion = function(question) {
  let answer = prompt(`Question for ${this.players[this.currentPlayer].name}:  ${question.title}`, question.choices);
  if (answer.toUpperCase() === question.correctAns) {
    alert('Congratulations!');
    this.players[this.currentPlayer].score ++;
  }
  else alert('Wrong answer!');

  this.totalQuestions ++;
  this.players[this.currentPlayer].answered ++;
  if (this.currentPlayer === this.players.length - 1) this.currentPlayer = 0;
  else this.currentPlayer ++;

  if (this.totalQuestions === this.questions.length*2) {
    
    let winner = this.players.reduce(function(a, b){
      return a.answered/a.score > b.answered/b.score ? a : b;
    });
    let tieGame = [];
    tieGame.push(winner);

    console.log('FINAL SCORE:');
    for (var i = 0; i < this.players.length; i++) {
      console.log(`${this.players[i].name}: ${this.players[i].answered/this.players[i].score} points.`);
    }
    for (let y = 0; y < this.players.length; y++) {
      if(this.players[y].answered/this.players[y].score === winner.answered/winner.score &&
        this.players[y].name !== winner.name && this.players[y].score > 0) {
        tieGame.push(this.players[y]);
      }
    }
    if (tieGame.length === 1) alert(`CONGRATULATIONS TO ${winner.name}!`);
    else { 
      console.log(`TIE GAME between:`);
      for (var z = 0; z < tieGame.length; z++) {
        console.log(`${tieGame[z].name}`);
      }
    }
    
  }
}

Trivial.prototype.addQuestion = function(question) {
  this.questions.push(question);
}

let Question = function(title, choices, correctAns, category) {
  this.title = title;
  this.choices = choices;
  this.correctAns = correctAns;
  this.category = category;
}

Trivial.prototype.play = function() {
  let that = this;
  this.setPlayers();
  this.setCategory();
  let filtered = this.questions.filter(function(q) {
    return q.category === that.category;
  });
  this.questions = filtered;
  for (var i = 0; i < filtered.length; i++) {
      let randomIndex = Math.floor(Math.random() * (filtered.length));
      this.askQuestion(filtered[randomIndex]);
      this.askQuestion(filtered[randomIndex]);
  }
}

let Player = function(name) {
  this.name = name;
  this.answered = 0;
  this.score = 0;
}

Trivial.prototype.addPlayer = function(player) {
  this.players.push(player);
}

let newGame = new Trivial();
let question1 = new Question('Capital of Australia?',['A - Sydney ', 'B - Canberra ', 'C - Melbourne'], 'B', 'GEO');
let question2 = new Question('Capital of Portugal?',['A - Lisboa ', 'B - Porto ', 'C - Guimaraes'], 'A', 'GEO');
let question3 = new Question('Capital of USA?',['A - New York ', 'B - Washington DC ', 'C - Boston'], 'B', 'GEO');
let question4 = new Question('Capital of France?',['A - Paris ', 'B - Lyon ', 'C - Marseille'], 'A', 'SPORT');
let question5 = new Question('Capital of Italy?',['A - Firenze ', 'B - Milano ', 'C - Rome'], 'C', 'SPORT');
let question6 = new Question('Capital of Germany?',['A - Berlin ', 'B - Frankfurt ', 'C - Hamburg'], 'A', 'SPORT');
newGame.addQuestion(question1);
newGame.addQuestion(question2);
newGame.addQuestion(question3);
newGame.addQuestion(question4);
newGame.addQuestion(question5);
newGame.addQuestion(question6);
// let player1 = new Player('Amy');
// newGame.addPlayer(player1);
// let player2 = new Player('Bob');
// let player3 = new Player('Josh');
// newGame.addPlayer(player2);
// newGame.addPlayer(player3);
newGame.play();
