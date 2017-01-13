# Old plain trivial

In this project we are going to build a Trivial Game!

There will be multiple choice questions, players and a winner. We will be using javascript in the browser. And the `prompt` to ask for the user input.

### Setup

Create an `index.html`, no need to add anything in the `<body>` tag. It needs all the HTML structure with `DOCTYPE`, `<head>`, ...

Just add a `script` tag that requires your `trivial.js`. Make sure you get the javascript file by adding a `console.log('hello world')` and opening the `index.html` in the browser with the developer tools open with the console.

### Our first question

Define a `Trivial` class. For now, it doesn't need any other attributes.

Define `askQuestion` method that will ask the user a question. Check [how](https://developer.mozilla.org/en-US/docs/Web/API/Window/prompt) `prompt` works.

The prompt should also print multiple choices. If the answer from the user is correct, then you should print 'Congratulaitons' or something similar. Otherwise, just print 'wrong answer'.

```
Capital of France
A - Paris
B - Rome
```

### Add more questions

For now, our `Trivial` is just one question. Not fancy at all.

Define a `Question` class. It shuold have a `title`, `choices`, and `correctAns`. Those properties will be defined in the initialization of the instance.

```javascript
var question = new Question('Capital of France', ['A - Paris', 'B - Rome'], 'A');
```

Then we need to add the `question` to our `Trivial` instance. For example, define `addQuestion` on the `Trivial` class. Store all the questions in a property of the `Trivial`.

Change the implementation of the `askQuestion` to use the `question` that you just added. For now, just use the first `question` from the `questions` stored in the `Trivial`.

By the end of this step you should be able to:

```javascript
...
var question = new Question('Capital of France', ['A - Paris', 'B - Rome'], 'A');
trivial.addQuestion(question);
trivial.askQuestion() // you should get a prompt with 'Capital of France' and its choices.
```

### Handle all the questions

The trivial is still showing only one question. That's not cool. There should be question after question until you run out of questions.

Implement a `play` method on the trivial, that keeps asking questions as long as there are questions.

You should keep calling `askQuestion` until you reach the last question. Keep track of the question to be shown with a new property on trivial, something like `currentQuestionIndex`.

```javascript
// ... add more than one question to test this
trivial.play(); // it should show all the questions in order
```

### How about score and solutions??

We show all the questions, that's great, but how about keeping score?

We already added the `correctAns` to the question. However, we need use that when receiving the answer from the user.

Everytime you get the answer in `askQuestion` use the user input to compare it to the correct answer in the `Question` instance and store whether it was correct or wrong.

At the end of all the questions, show the score of the user. The score should show how many questions there were, and how many he got right.

**At this point, call your instructor for some code review**

### Add more players

So long only one player can play our trivial. We are going to add more playeres in the following steps.

Each question will be directed to one specific player. We can show that on the prompt message. For example: `Question for Amy`. Then we will assume that the answer comes from `Amy` and store wheter `Amy` answered correctly or not.

By the end we should be able to show the score of each of the players.

Let's go step by step to implement the new feature.

### Define `Player` class

Define a `Player` class. For now we will only store the name of the player.

Also, implement an `addPlayer` method on the `Trivial` class to add players to the game.

By the end of this small step you should be able to:

```javascript
...
var player1 = new Player('Amy');
trivial.addPlayer(player1);
var player2 = new Player('Bob');
trivial.addPlayer(player2);
```

### Each question for each player

In this specific feature, each question is for only one player. This means that the questions won't be repeated.

We want to show who should take the specific question. Which means adding some sentence in the prompt with the user name.

In order to do that we need to keep track of who's turn is. Similar as keeping the current question index, we could store `currentPlayerIndex`.

The difference between this and the index for the question is that, when we get to the last player, we want to start again.

The trivial doesn't stop when every player has finished responding one question.

*Tip: Remember to move to the next player after asking the question*

### Keep track of each user score

This is great, we ask questions to different players. However we need to keep track of the score so that we know who won.

The tricky part is that each correct or wrong answer is related to one specific player. As an example, you could have the answers in the `Player` class. Implement a `addAnswer` method on the `Player` class that will store the answer.

Once you have each answer properly stored you want to show the score of each player.

When the trivial finishes, print the result of each player. Similar to what you were doing before, but now for each player you should print how many questions they answers and how many they got correct.

Finally, congratulate the winner of the trivial. The one with the best ratio.

*Tip: Handle the scenario when two or more players tie*

**At this point, call your instructor for some code review**

### Trivial adds for players at the beginning

Use prompt at the beginning of the Game to create the Players.

For example: implement a `setPlayers` method on Trivial that will keep prompting for user names until the prompt is left blank.

### Bonus 

If you have finished and got the review from an instructor, try to implement the next features to complete your Trivial project.

- Add shuffle feature of the questions every time you start a new round
- Add categories of questions. Each question should have a category, and when starting
a trivial you should be able to select a specific category
- Add a new mode of playing, so that each question is repeated for each player

**Congratulations! You finished your first big project! Play a little bit with it and make sure you don't have any bug**

