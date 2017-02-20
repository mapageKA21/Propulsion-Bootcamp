function cardValue(card) {
  if (card.value === 'ACE') {
    return 11;
  }
  let value = parseInt(card.value);
  if (isNaN(value)) {
    value = 10;
  }

  return value;
}

export default class Hand {
  constructor(deck) {
    this.deck = deck;
    this.cards = [];
  }

  draw(num) {
    return this.deck
            .draw(num)
            .then((cards) => {
              this.cards = this.cards.concat(cards);
            });
  }

  getCards() {
    return this.cards;
  }

  isBusted() {
    return this.score() === -1;
  }

  score() {
    let numAces = this.cards.filter(card => card.value === 'ACE').length;
    let score = this.cards.reduce((acc, card) => acc + cardValue(card), 0);
    while (numAces > 0 && score > 21) {
      numAces -= 1;
      score -= 10;
    }
    if (score > 21) {
      score = -1;
    }

    return score;
  }
}
