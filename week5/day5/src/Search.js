class Search {
  searchTracks(query) {
    return fetch(`https://api.spotify.com/v1/search?q=${query}&type=track`)
      .then(res => res.json())
      .then(results => results.tracks.items);
  }
}

export default Search;
