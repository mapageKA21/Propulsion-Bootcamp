import Track from './Track';

class TrackList {
  constructor(tracks, container) {
    this.tracks = tracks.map(trackData => new Track(trackData));
    this.el = container;
  }

  render() {
    this.el.innerHTML = '';
    this.tracks.forEach(track => {
      this.el.appendChild(track.render().el);
    });

    return this;
  }
}

export default TrackList;
