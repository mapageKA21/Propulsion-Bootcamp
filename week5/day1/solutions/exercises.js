var exercises = {};

exercises.isString = function(str) {
  return typeof str === 'string';
}

exercises.isArray = function(arr) {
  return Array.isArray(arr); // ES6 :)
}

exercises.typeOfElement = function(element) {
  if (typeof element === 'object') {
    return Array.isArray(element) ? 'array' : 'object';
  }

  return typeof element;
}

exercises.areSameType = function(elements) {
  var firstElementType = this.typeOfElement(elements[0]);

  for(var i = 1; i < elements.length; i++) {
    var currentType = this.typeOfElement(elements[i]);
    if (currentType !== firstElementType) {
      return false;
    }
  }

  return true;
}

exercises.longest = function(str1, str2) {
  var chrs = [];
  var longStr = str1 + str2;
  for (var i = 0; i < longStr.length; i++) {
    var chr = longStr[i];
    if (chrs.indexOf(chr) === -1) {
      chrs.push(chr);
    }
  }

  return chrs.sort().join('');
}

exercises.convert = function(num) {
  return num
    .toString()
    .split('')
    .map(Math.floor)
    .sort()
    .reverse()
}

exercises.countRepetitions = function(elements) {
  return elements.reduce(function(acc, el) {
    if (acc[el]) {
      acc[el] += 1;
    } else {
      acc[el] = 1;
    }

    return acc;
  }, {});
}

exercises.isCaught = function(sequence) {
  var jumpLength = 3;
  for(var i = 0; i < sequence.length; i++) {
    var chr = sequence[i];
    if (chr === 'C') {
      for (var j = i + 1; j <= i + jumpLength; j++) {
        var chr2 = sequence[j];
        if (chr2 === 'm') {
          return true;
        }
      }
    }
  }

  return false;
}

exercises.splitTheBill = function(group) {
  var avg = Object.values(group).reduce(function(acc, val, index, values) {
    return acc + (val / values.length);
  }, 0);

  return Object.keys(group).reduce(function(acc, person) {
    acc[person] = Math.round((avg - group[person]));
    return acc;
  }, {});
}

exercises.exp = function(num, base) {
  if (base === 0) {
    return 1;
  }

  return num * this.exp(num, base - 1);
}

exercises.factorial = function(num) {
  if (num === 0) {
    return 1;
  }

  return num * this.factorial(num - 1);
}

exercises.fibs = function(n) {
  if (n === 1) {
    return [0];
  }
  if (n === 2) {
    return [0, 1];
  }

  var prevFibs = this.fibs(n - 1);
  var lastIndex = prevFibs.length - 1;

  return prevFibs.concat([prevFibs[lastIndex] + prevFibs[lastIndex - 1]]);
}

exercises.zeroSum = function(nums) {
  var pairs = [];
  for (var i = 0; i < nums.length - 1; i++) {
    var firstIterationNum = nums[i];
    for (var j = i + 1; j < nums.length; j++) {
      var secondIterationNum = nums[j];
      if (firstIterationNum + secondIterationNum === 0) {
        pairs.push([i, j]);
      }
    }
  }

  return pairs;
}

module.exports = exercises;
