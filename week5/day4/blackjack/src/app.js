import Dealer from './Dealer';
import Deck from './Deck';
import Game from './Game';
import Player from './Player';

function ready(fn) {
  if (document.readyState != 'loading'){
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}

ready(function() {
  fetch('https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1')
    .then(res => res.json())
    .then(data => {
      const deck = new Deck(data.deck_id);
      const game = new Game();
      const dealer = new Dealer(deck, game.gameOver.bind(game));
      game.addDealer(dealer);
      const player = new Player(deck, dealer.play.bind(dealer));
      game.addPlayer(player);
    });
})
