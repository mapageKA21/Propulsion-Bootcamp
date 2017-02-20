import classes from './card.css';
import Hand from './Hand';

export default class Player {
  constructor(deck, playDealer) {
    this.container = document.querySelectorAll('.js-player-cards')[0];
    this.hand = new Hand(deck);
    this.playDealer = playDealer;
    Array.prototype.forEach.call(document.querySelectorAll('.js-start'), (startButton) => {
      startButton.addEventListener('click', this.start.bind(this));
    });
    Array.prototype.forEach.call(document.querySelectorAll('.js-hit'), (hitButton) => {
      hitButton.addEventListener('click', this.hit.bind(this));
    });
    Array.prototype.forEach.call(document.querySelectorAll('.js-stand'), (standButton) => {
      standButton.addEventListener('click', this.stand.bind(this));
    });
  }

  removeCards() {
    const elements = document.querySelectorAll(`.js-player-cards .${classes.card}`);
    Array.prototype.forEach.call(elements, function(el, i){
      el.parentNode.removeChild(el);
    });
  }

  hit() {
    this.hand
      .draw(1)
      .then(() => {
        if (this.hand.isBusted()) {
          this.renderBusted()
        } else {
          this.renderCards();
        }
      })
  }

  renderBusted() {
    this.removeCards();
    const bustedElement = document.createElement('h3');
    bustedElement.classList.add('title');
    bustedElement.textContent = 'Busted!';
    this.container.append(bustedElement);
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

  stand() {
    this.playDealer();
  }

  start() {
    this.hand
      .draw(2)
      .then(() => {
        this.renderCards();
      });
  }
}
