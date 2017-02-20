import Search from './Search';
import TrackList from './TrackList';

class Controller {
  constructor() {
    this.search = new Search();
    var formEl = document.getElementById('search');
    formEl.addEventListener('submit', this.searchTracks.bind(this));
    this.resultsContainer = document.getElementById('results');
  }

  searchTracks(e) {
    e.preventDefault();
    const query = e.target.query.value;

    this.search
      .searchTracks(query)
      .then(tracks => {
        e.target.query.value = '';
        var list = new TrackList(tracks, this.resultsContainer);
        list.render();
      })
      .catch(err => {
        console.log('in da error');
        console.log(err);
      });
  }
}

export default Controller;
