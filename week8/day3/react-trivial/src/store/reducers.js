import uuid from 'node-uuid';
import { combineReducers } from 'redux';

import { ADD_QUESTIONS, ADD_SCORE } from './actions';

const questions = (state = {}, action) => {
  switch (action.type) {
    case ADD_QUESTIONS: {
      const newState = { ...state };
      action.payload.forEach((question, index) => {
        question.id = uuid.v4();
        question.order = index + 1;
        newState[question.id] = question;
      });

      return newState;
    }
    default: {
      return state;
    }
  }
}

const scores = (state = [], action) => {
  switch (action.type) {
    case ADD_SCORE:
      const newState = [ ...state ];
      newState.push(action.payload);

      return newState;
    default:
      return state;
  }
}

export default combineReducers({
  questions,
  scores,
});
