import classes from './card.css';
import Hand from './Hand';

export default class Dealer {
  constructor(deck, gameOver) {
    this.deck = deck;
    this.hand = new Hand(deck);
    this.cards = [];
    this.container = document.querySelectorAll('.js-dealer-cards')[0];
    this.gameOver = gameOver;
  }

  removeCards() {
    const elements = document.querySelectorAll(`.js-dealer-cards .${classes.card}`);
    Array.prototype.forEach.call(elements, function(el, i){
      el.parentNode.removeChild(el);
    });
  }

  hit() {
    if (this.score() < 17 && !this.hand.isBusted()) {
      this.hand
        .draw(1)
        .then(() => {
          this.renderCards();
          this.hit();
        });
    } else {
      this.gameOver();
    }
  }

  play() {
    this.start();
  }

  renderCards() {
    this.removeCards();
    this.hand.getCards().forEach((card) => {
      const cardEl = document.createElement('div');
      cardEl.classList.add(classes.card);
      cardEl.style.backgroundImage = `url(${card.image})`;
      this.container.appendChild(cardEl);
    });
  }

  score() {
    return this.hand.score();
  }

  start() {
    this.hand
      .draw(2)
      .then(() => {
        this.renderCards();
        this.hit();
      });
  }
}
