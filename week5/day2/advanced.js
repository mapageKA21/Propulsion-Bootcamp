

[1,2,3].forEach(function(el, i) {
  console.log("This index is: " + i + " and the value is: " + el+1);
})


/*

### Expanded Math Object

Create an expansion of the Math Object and add a method that returns
a random integer between 0 and the Max number passed as parameter

*/

var myMath = Object.create(Math);

myMath.randomInt = function(max) {
  return this.round(this.random() * max);
}

// console.log(myMath.randomInt(5));
// console.log(myMath.randomInt(10));
// console.log(myMath.random());
// console.log(myMath.round(0.5));

/*

### Add `reverse` method to `String` object

Add the `reverse` method to the String prototype

*/

String.prototype.reverse = function() {
  return this.split('').reverse().join('');
}

// console.log('hello'.reverse());

/*

### `myEach`

Define a `myEach` function that simulates the `forEach` method on `Array`

DO NOT USE `forEach` in the implementation.

*/

function myEach(collection, fn) {
  for (var i = 0; i < collection.length; i++) {
    fn(collection[i], i, collection)
  }
}

// myEach([1,2,5], function(el, index, arr) {
//   console.log(index);
//   console.log(el);
//   console.log(arr);
// });

/*

### `myMap`

Define a `myMap` function that simulates the `map` method on `Array`

DO NOT USE `map`, but you can use your own `myEach`.

*/

function myMap(collection, fn) {
  var result = [];

  myEach(collection, function(el, index, arr) {
    var newElement = fn(el, index, arr);
    result.push(newElement);
  });

  return result;
}

var numbers = myMap([2, 4, 6], function(el, index) {
  return el * index;
});

console.log(numbers);

/*

### `myFilter`

Define a myFilter function that simulates the `filter` method on `Array`.

DO NOT USE `filter`, but you can use your own `myEach`.

*/

function myFilter(collection, fn) {
  var result = [];
  myEach(collection, function(el, index, arr) {
    if (fn(el, index, arr)) {
      result.push(el);
    }
  });

  return result;
}

var filtered = myFilter([2, 8, 5, 15], function(el, index) {
  return el % index === 0;
});

// console.log(filtered);
