# Exercises

Remember to implement these exercises using TDD.

For each exercise:

1. Write first the test using [tape](https://github.com/substack/tape).
2. Run the tests to make sure they fail.
3. Implement the solution.
4. Run the tests until they all pass.
5. Refactor your code.
6. Run your tests again.

---

### isAnagram

Write a function that takes two words as an argument and returns true if they are anagrams (contain the exact same letters) and false otherwise.

```javascript
isAnagram('hello', 'ollhe'); // => true
isAnagram('world', 'ordly'); // => false
isAnagram('fante', 'tenaff'); // => false
```

---

### Box Volume

Write a function that takes three measurements in centimeters as input and returns a the volume over a liter.

It should return the liters with up to 4 decimals.

```javascript
boxVolume(10, 10, 10); // => 1
boxVolume(5, 5, 5); // => 0,125
boxVolume(5, 5, 5.1); // => 0,1275
```

---

### Rectangle intersection

Write a function that expects two rectangles and returns the intersected rectangle if any.

Each rectangle is represented by two points in a two dimensional space.

For example: [1, 1] and [4, 3]. Is the rectangle with point the corners at [1, 1], [4, 1], [1, 3] and [4, 3].

```javascript
intersect([[1, 1], [4, 3]], [[2, 2], [6, 7]]); // => [2, 2], [4, 3]
intersect([[2, 1], [4, 4]], [[1, 1], [8, 8]]); // => [4, 4], [2, 1]
```

---
