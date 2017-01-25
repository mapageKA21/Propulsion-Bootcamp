$(function() {
 
  var favorites = [];

  fetch('http://swapi.co/api/films')
    .then(function(response) {
      return response.json();
    })
    .then(function(data) {
      data.results.forEach(function(movie) {

        var filmDiv = $('<div>').addClass('film');
        var filmTitle = $('<h3>').text(movie.title);
        var starShipsElement = $('<ul>').addClass('starships');
        
        movie.starships.forEach(function(ship) {
          var link = $('<a>')
                  .addClass('starship-link')
                  .text(ship)
                  .data('url', ship)
                  .attr('href', '#');
          var li = $('<li>').append(link);
          starShipsElement.append(li);
          
          $('#film-list').append(filmDiv).append(filmTitle).append(starShipsElement);
        });
      });
    })

    $('#film-list').on('click', '.starships', function(data) {
      let link = $(data.target).text();
      fetchStarship(link);
    });

    var currentStarship;

    fetchStarship = function(url) {
      fetch(url)
      .then(function(response) {
        return response.json();
      })
      .then(function(data) {
        currentStarship = data;
        var pilotLinks = data.pilots;
        var promises = pilotLinks.map(link => fetch(link));
        return Promise.all(promises);
      })
      .then(function(responses) {
        return Promise.all(responses.map(res => res.json()))
      })
      .then(function(pilots) {
        currentStarship.currentPilots = pilots;
        renderShip();
      })
    }

    renderShip = function() {
      $( "#starship" ).empty();
      var shipDiv = $('<div>').addClass('ship');
      var shipTitle = $('<h5>').text(currentStarship.name);
      var pilotsElement = $('<ul>').addClass('pilots');
      currentStarship.currentPilots.forEach(function(pilot) {
        var link = $('<a>')
                  .addClass('pilot-link')
                  .text(pilot.name)
                  // .data('url', pilot.url) not expected
                  .attr('href', '#')
                  .attr('link', pilot.url);
        var li = $('<li>').append(link);
        pilotsElement.append(li);
        
        $('#starship').append(shipDiv).append(shipTitle).append(pilotsElement);
      });

      if (currentStarship.pilots.length === 0) 
        $('#starship').append(shipDiv).append(shipTitle).append(`<p>No pilots</p>`);
    
    }


    $('#starship').on('click', '.pilot-link', function(data) {
      let link = $(data.target).attr('link');
      fetchPilots(link);
    });

    fetchPilots = function(url) {
      fetch(url)
      .then(function(response) {
        return response.json();
      })
      .then(function(data) {
        renderPilot(data);
      })
    }

    renderPilot = function(pilot) {
      let button = $('<button class="fav">Add to favorites</button>');
      $("#pilot").empty();
      var pilotDiv = $('<div>').addClass('pilot');
      var pilotTitle = $('<h5>').text(pilot.name);
      $('#pilot').append(pilotDiv).append(pilotTitle);
      $('#pilot').append(button);
    }

    $('#pilot').on('click', '.fav', function(data) {
      let name = $("div#pilot h5").text();
      if (favorites.indexOf(name) < 0) {
        favorites.push(name);
        renderFavs(favorites);
      }
    });

    $('#favorites').on('click', '.remove', function(data) {
      let name = $(this).siblings('h5').text();
      let index = favorites.indexOf(name);
      favorites.splice(index, 1);
      renderFavs(favorites);
    });

    renderFavs = function(favoritesArray) {
      $("#favorites").empty();
      var favsDiv = $('<ul>').addClass('favs');

      favoritesArray.forEach(function(name) {
        let button = $('<button class="remove">Remove</button>');
        var favsTitle = $('<h5>').text(name);
        var item = $('<li>').append(favsTitle).append(button);
        favsDiv.append(item);
        $('#favorites').append(favsDiv);
      });
    }
})
