class Track {
  constructor(attrs) {
    this.el = document.createElement('li');
    this.el.classList.add('track-result')
    this.audioEl = document.getElementById('audio-element');
    this.attrs = attrs;
    this.el.addEventListener('click', this.play.bind(this));
  }

  artists() {
    return this.attrs.artists
      .map(artist => artist.name)
      .join(', ');
  }

  play() {
    this.audioEl.setAttribute('src', this.attrs.preview_url);
    this.audioEl.play();
  }

  render() {
    this.el.innerHTML = `${this.attrs.name} by ${this.artists()}`;

    return this;
  }
}

export default Track;
