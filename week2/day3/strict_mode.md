# Strict Mode

Strict Mode is a way to *opt in* to a restricted variant of JavaScript.

Strict Mode changes Javascript slightly.

- Some silent errors are thrown. Easier to find bugs that way.
- It increases engine performance. The engine can make some assumptions that increase the performance.

### Invoking Strict Mode

Strict Mode can be either invoked in the scope of a function or in the whole file.

For the whole file, just add `'use strict';` at the beginning of the file.

To apply Strict Mode in only a function, add the previous expression at the top of the function.

```Javascript
function strictedFn() {
  'use strict';
  // code
}
```

### Most useful limitations for beginner

These are the most useful feature of using Strict Mode.

- It doesn't allow to create global variables by forgetting to use `var`;

  ```javascript
  'use strict';

  myGlobalVar = 10; // this will raise an error if `myGlobalVar` is not previously defined
  ```

- Any assignment that silently fails in normal code will throw in strict mode. Such as assigning to `NaN`.

  ```Javascript
  'use strict';

  NaN = 'hello'; // raises an error in Strict Mode
  ```

- Forces function parameter names to be unique

  ```Javascript
  'use strict';

  function sum(a, a, b) { // raises an error
    // code
  }
  ```

For a complete set of the changes, check [MDN Article](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode) on Strict Mode.
