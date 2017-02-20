export default class Deck {
  constructor(deckId) {
    this.deckId = deckId;
    this.baseUrl = `https://deckofcardsapi.com/api/deck/${this.deckId}`;
  }

  draw(count) {
    return fetch(`${this.baseUrl}/draw/?count=${count}`)
              .then(res => res.json())
              .then(data => data.cards);
  }
}
