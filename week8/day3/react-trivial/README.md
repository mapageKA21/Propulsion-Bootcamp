# Trivial

- Material ui
  - https://github.com/callemall/material-ui
  - install npm
  - add font
  - add RaisedButton. Check the error.
  - add touchtap plugin
  ```javascript
  import injectTapEventPlugin from 'react-tap-event-plugin';

  // Needed for onTouchTap
  // http://stackoverflow.com/a/34015469/988941
  injectTapEventPlugin();
  ```
- Change title to `Trivial`, remove logo, change height. Button should start the Trivial.
- react-router
  - install npm
  - use it without adding routes
  ```javascript
  <Router history={ browserHistory }>
    <Route path="/" component={ App } />
  </Router>
  ```
- Add one route `/question`
  - create Component
  - render 'hello'
  - add Route to Router
  - http://localhost:3000/question
- Add Link when clicking RaisedButton from App
  ```javascript
  <Link to="/question">
    <RaisedButton label="Start" />
  </Link>
  ```
- Render a question with 4 choices in Question. Use Paper, List and ListItem.
- Fetch the question from the api:
  - https://opentdb.com/api.php?amount=1
  - Use the component state
  - Escape chars
  ```
  <p dangerouslySetInnerHTML={ { __html: this.state.question.question } } />
  ```
- Create `QuestionItem` component
  - props: choice + isCorrect
  - onClick: log whether it was correct or not
- Keep title in the Question component
  - Create Title component
  - Nested Route
- Add Redux and react-redux
  - fetch 10 questions
  - add them to state
  - log the reducer before returning the next state.
  - use node-uuid to create id for question: https://www.npmjs.com/package/node-uuid
  - add `order` property
- Move App to its own folder
- react-router Route `questions/:order`
  - log the order param in `Question`
- mapStateToProps in `Question`
  - remove fetching of question there and component state
  - get from redux state the question with order === this.props.params.order
  - convert the question with array of answers
  - display that question
- Move from one question to the other
  - use `withRouter`
  - pass `handleNext` to `QuestionItem`
- `Result` component
  - After Last question should redirect to `/result`
  - add route and component, hardcoded, `congratulations you finished`
- Redux state with score:
  - `score`. Will be an array of booleans.
  - create reducer + action `addScore`
  - dispatch `addScore` in `QuestionItem` passing `true` or `false`
- Connect Result to Redux
  - Get the results and display the score in `Result`
- Add `redux-thunk`
  - To fetch the questions
