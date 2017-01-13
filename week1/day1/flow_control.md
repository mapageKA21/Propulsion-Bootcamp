## Flow Control

Scripts are read by the computer from top to bottom. Line by line.

However, sometimes we want to skip a line or sometimes we want to do the same action over and over. This is conditionals and loops come into play.

**Conditionals**

```javascript
if (writer === 'fante') {
  console.log('Great writer!');
} else {
  console.log('booohhhh');
}
```

With conditions we can skip lines. In this specific case we have a variable named `writer`. We want to do something different depending on the value of that value.

Remember that more conditions can be added using `else if`.

**Loops**

```javascript
var numbers = [1, 2, 3];
for (var i = 0; i < numbers.length; i++) {
  console.log('Current number is ' + numbers[i]);
}
```

There are many ways to loop. The main idea is that you execute the same lines of code a specific number of times.

In this specific case, the `console.log` would be executed 3 times.

Loops are mainly used to iterate through collections. Arrays or objects.

Other ways to loop are `while`, `for (... in ...)`. You can take a look at the complete list in [here](https://developer.mozilla.org/ca/docs/Web/JavaScript/Guide/Loops_and_iteration)

There is another way to loop through collections. Using built-in methods such as `map` or `forEach`.
