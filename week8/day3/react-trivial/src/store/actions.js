export const ADD_QUESTIONS = 'addQuestions';
export const ADD_SCORE = 'addScore';

export const addQuestions = (questions) => ({
  type: ADD_QUESTIONS,
  payload: questions,
});

export const addScore = (score) => ({
  type: ADD_SCORE,
  payload: score
});

export const fetchQuestions = () => (dispatch, getState) => {
  return fetch('https://opentdb.com/api.php?amount=3')
    .then(res => res.json())
    .then(data => {
      const action = addQuestions(data.results);
      dispatch(action);
    });
}
