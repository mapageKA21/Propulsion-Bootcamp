# Star Wars Book

We are going to build a project to check the Star Wars Starships by films and their Pilots! Also add your favorites pilots to a list!

All the data will be provided by [Star Wars API](https://swapi.co/).

Investigate the API first.

Try this url: `http://swapi.co/api/starships/48/?format=json` in the browser.

In order to prettify the data, you can use a Chrome Extension **JSON Formatter**. After installing the extension, visit the previous url.

Play around visiting the film url, or the person. Check what properties are in each of them.

### Setup the HTML

Create an `index.html` and add jQuery.

The main idea is that there will be 4 columns:
- First column for the list of the movies
- Second, data from the starship selected in the first column.
- In the third column there will be the data of the pilot chosen in the second column.
- Last but not least, the fourth column will be for the favorites.

Your html could look something like this

```HTML
<div class="column">
  <h2>Films:</h2>
  <div id="film-list"></div>
</div>
<div class="column" id="starship"></div>
<div class="column" id="pilot"></div>
<div class="column">
  <h2>Favorites:</h2>
  <div id="favorites"></div>
</div>
```

Add some style so that the columns are actual columns.

You are going to create elements and add them to the specific place.

### First Column

List of Start Wars Movies.

For now add the title of the movie and the description.

Your job is that as soon as the page loads, it will make a request to the API to get the list of movies.

**TIP:** url is `http://swapi.co/api/films`. The `results` property has an array of objects with the movie data.

You can use either `fetch` or jQuery's AJAX. Up to you.

The idea is that when you receive the data, you should create an element for each movie.

For example, if we have an array of movie objects I could:

```javascript
movies.forEach(function(movie) {
  var element = $('<h1>').text(movie.title); // create the element
  container.append(element); // append it to where I want, container has been previously defined.
});
```

**TIP:** Remember to put everything else in a document ready function.

```javascript
$(function() {
  // your code should go here
})
```

### Starships List

Apart from the title and the description we also want to render the list of starships in each movie.

Check the property with that information. Use that array of values to create a list.

**TIP:** When you ask for the Movie information you don't get the name of the starships. Only the Urls of them. Use that.

You will have to create the element where the list will be, as well as each list item.

**Ask for a review from an instructor at this point**

### Starship Link and Second Column

As we explained, in the second column there will be the information of the starship selected in the first column.

This means that we need to add a listener to each starship.

When we click on the link, the data from the starship will be fetched and then new elements will be created with it and them appended to the second column.

The steps after clicking in the link:

- Get the url of the clicked starship.
- Fetch the data with a request.
- Create the elements.
- Append them.

However, there is on tricky part here. How to get the url of the starship that was clicked.

A good approach is to add that information to the element that will be clicked as HTML attribute. The links should be something like this:

```html
<a href="#" data-url="http://swapi.co/api/starships/48">http://swapi.co/api/starships/48</a>
```

**TIP:** In the click event, you should prevent the link to try to go somewhere. Research about `preventDefault` to avoid that.

Now the steps for this part are:

- Add the listener
- Get the url from the element that was clicked
- Fetch the data with a request.
- Create the elements.
- Append them.

### Pilots List

Same way we had a list of Starships in the movie. You should also do the same with the pilots of the starship.

### Pilot Link and Third Column

Similar to the Starship Link.

When the user clicks on the pilot link, the data of the pilot should be fetched and shown in the third column.

**Ask for a review from an instructor at this point**

### Select your favorite Pilot

Once you get to the third column, you should be able to save your favorites pilots.

Add a button to the Pilot Column that will add the pilot to the Favorites List!

There is a simple way to save the favorites. Create a `favorites` variable. When you click on the button, add the pilot to this variable.

This variable should be in the outer scope. The same scope as the functions.

Then you can create a function `renderFavorites` that access this variable, creates an element for each pilot and appends it to the proper element.

### Do not repeat pilots

Do not allow to add twice the same pilot.

Check whether the pilot is already in the `favorites` before adding them.

### Remove Favorites

Add a button `x` beside each favorite that will remove them from your favorites list.

### Pilot names links

The lists that we have are pretty bad let's face it. We know nothing about those, we have to click even to get the pilots of the starship.

Let's change that.

The list of pilots in the Second column should display their names.

In order to do that, you should make a new request for each pilot. Once you have the starship data, you should keep fetching.

Check how `Promise.all` works. It might help you achieve this step.

Also remember that if you return a `Promise` from the `.then`, the next `.then` will wait for the previous `Promise` to finish.

**Don't worry too much about performance right now. Make it work.**

### Bonus

- Add the names of the starships in the list of movies.
- Do not show the Favorites column until you have some Favorite pilot.
- Do not show the second and third column until you have selected a starship and a pilot respectively.
- Refactor and use OOP.
