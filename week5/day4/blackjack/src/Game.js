export default class Game {
  addDealer(dealer) {
    this.dealer = dealer;
  }

  addPlayer(player) {
    this.player = player;
  }

  gameOver() {
    if (this.player.score() > this.dealer.score()) {
      console.log('Player Won');
    } else if (this.player.score() < this.dealer.score()) {
      console.log('Dealer Won');
    } else {
      console.log('Tie!');
    }
  }
}
