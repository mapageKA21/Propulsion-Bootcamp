# Zurich Times

In this project you will create a page displaying stories from the New York Times using their API.

The main target of this project is the quality of the code. Not the amount of features. Concentrate in creating code that is easy to read.

Remember to follow the pattern MVC.

### HTML Setup

The HTML will be only a single empty `div` with a class or id that will be selected from the DOM.

All the page will be created dynamically with JS.

Create this simple HTML and require a javascript file and jQuery.

### List of Stories

We will start with the first View class. `StoryIndexView`. This should be in its own file.

Create this class with the following features.

- It creates an array of stories -a story is just a title or string- when it's initialized.
- The View has an element that is created in the initialization as well. `this.el`.
- Implement the render method that will populate the element. For each story in the array it should create an element and append it to `this.el`.

How to use this class? Remember that it's very important to test as soon as possible. It's a bad practice to write a lot of code without checking whether it's working or not.

Let's add another file that will initialize the file. Add a document ready listener. In the listener, create an instance of `StoryIndexView`.

```javascript
$(function() {
  var view = new StoryIndexView();

  // select the element from the current DOM
  // call render on the view
  // append the element of the view to the selected element
});
```

Select the only `div` that you added to the HTML file and append the element of the View after calling render.

Check what the controller was doing in the `quotesIndex` method in the Ron Swanson example.

### Controller

Next step is to implement the Controller.

In a different file, create the `Controller` class. The controller will have access to the DOM. For example it could expect an element in the constructor and store it in a property `this.container`.

A controller will implement a method to render the list of stories. In that method `storiesIndex` for example, it will create a new instance of the `StoryIndexView`, call render and append the element on `this.container`.

Basically, move the logic that was directly in the document ready, to a method in the Controller.

Your document ready by the end of this step should be something like this:

```javascript
$(function() {
  var container = $('#app'); // this examples assume <div id="app"></div>
  var controller = new Controller(container);

  controller.storiesIndex();
});
```

### Collection

Until now the View has an array of strings as stories. We already learned that the views should not hold data.

Instead, create a `StoriesCollection` that will have that data. For now, the collection will have an array of strings, same as the view.

However, instead of having the View the array of strings hardcoded, it should expect a Collection.

In `storyIndexView.js`:

```javascript
var StoryIndexView = function(collection) {
  this.collection = collection;
  // ...
}
```

The Collection will have the hardcoded array in its initialization.

The Collection will be initialized in the constructor of the Controller. It will be passed to the View when the View is initialized.

The View will use the collection in the render method, rather than using the previous hardcoded array of strings.

### Collection fetch

Here comes the fun part.

The stories are hardcoded. However we will fetch them from the NYT API.

First of all you need to get a token in their [website](https://developer.nytimes.com/).

You will have to choose a specific resource for the token. This project is about Top Stories, but you can choose another one. That is not a problem.

Once you have the key, play around with the urls you can use. For example go to `https://api.nytimes.com/svc/topstories/v2/home.json?api-key=YOUR_TOKEN` and check the response. You need to add your token.

Then, remove the hardcoded titles. The array in the Collection should start empty.

You will have to implement a `fetch` method in the Collection that will make the request to the URL and on success populate the array with the stories.

For now, just log that response on success of the request.

**Ask for a review from an instructor at this point**

### Render the fetched stories

You probably don't have the stories rendered in the page at this point.

Can you think of why is that? If you are not sure, ask an instructor to come over and explain it.

In order to overcome that, we need to call again `storiesIndex`, once the fetching of the Collection has finished.

How about if the `fetch` of the collection returned the Promise? We could use that in the Controller in order to call `storiesIndex` in the success of the request.

```javascript
var Controller = function() {
  this.storyCollection = new StoryCollection();
  this.storyCollection
    .fetch()
    .then(function() {
      // call `storiesIndex`
    });
  this.container = $('#app');
};
```

This code might not work exactly in your project. It's important that you understand the concept and apply the proper implementation to your own project.

### Story Model

The Stories so far are only strings.

Create the `StoryModel` that will have the data of a single Story. Check the response from the NYT API to see all the properties.

For now just implement the `title` property in the `StoryModel` if you want.

Where to create the Story Model instance? In the `fetch` method of the collection. When you receive the data from the `fetch` you should create a `new StoryModel` and push that to the array `this.stories` in the collection.

Remember that in the `render` method of the view, this array is looped in order to render each story. Until now they were only strings. However, they are now instances of `StoryModel`. Act accordingly in order to render the title of the story.

### Another View

Right now you only have one single View. In this view, you are iterating through the collection stories and appending the title to the container.

However, an even better approach is that each of this iterations should create a new View.

There will be two views:

- `StoryIndexView` that will handle the list
- `StoryItemView` that will handle each specific item in the list.

For example, let's assume the List is implemented with a `<ul>`. That would be created in the `StoryIndexView`. Then each item or `<li>` would be implemented in a `StoryItemView`.

The idea is that each of the instances of `StoryItemView` will have a `StoryModel` associated. This model will be passed and stored in the constructor, when the instance is created.

In the render method of the `StoryIndexView` you will create a `new StoryItemView`.

Then you will call render in the instance and append the element of this other view in it's `this.el`.

This might be confusing at this point. Let's recap the steps:

- Create a `StoryItemView` and expect a model in the constructor.
- In the collection loop, where each element is a model:
  - In the `render` of the `StoryIndexView`, create a new instance of `StoryItemView` for each story.
  - In the initialization, pass the model to the view
  - Call render on each view instance
  - Append the element of each view to the element of the `StoryIndexView`

So much code and we haven't still added any new functionality to our app. Only a list of titles.

In the following steps you will see how easy it is to change how the data is displayed if you have a proper MVC structure.

**Ask for a review from an instructor at this point**

### First refactor

Refactor `StoryIndexView` as a table where each row is the `StoryItemView`.

Add also the section, author and a thumbnail of each story.

In this refactor you should only change code in both Views and maybe the Model.

### Fancy Stories

Let's get fancy with the UI.

We are going to implement a simple CSS Framework. It's called Spectre. Go to the [page](https://picturepan2.github.io/spectre/) of the framework and check it out.

You will convert each the table and rows in a grid of Cards.

Check the Card Component of the Spectre Framework. Each of your stories should display one card.

In order to create the Grid of Cards, inspect the Flexbox grid in the Spectre docs.

**TIP: use the image that has more than 200 pixels width for the Cards**

For this refactor you should change only both views and maybe the Model.

### Favorites Stories

Add a button to each card that will set them as Favorites for the user.

Display the title of each favorite in another column.

In this favorites column you can implement it as an Specte table with just the Title of the story.

**TIP: After setting a story as favorite, the render or `storiesIndex` method should be called again**

### UnFav Stories

Add a button to each favorite story in order to remove them from the favorites list.

### Bonus

- Add the Layout to be responsive. If the screen is for mobile, the Favorites List shuold be on top, not in a column. Also the grid should have a maximum of 2 stories per row.
- The image and title of the cards are links to the stories in NYT
- Create another View. `StoryItemView` is two views, one for the grid, another for the Card. Separate those two responsibilities in two separate views.
