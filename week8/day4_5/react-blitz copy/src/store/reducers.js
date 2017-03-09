import { combineReducers } from 'redux';

import {
  ADD_BLITZ,
  ADD_BLITZS,
  ADD_USER,
  ADD_USERS,
  REMOVE_CURRENT_USER,
  SET_CURRENT_USER,
  TOGGLE_FOLLOW
} from './constants';

const currentUser = (state = {}, action) => {
  switch (action.type) {
    case SET_CURRENT_USER:
      return Object.assign({}, state, action.payload.user);
    case TOGGLE_FOLLOW:
      const newUser = { ...state };
      const toggleFollowId = action.payload.userId;
      newUser.follows = newUser.follows.indexOf(toggleFollowId) > -1
        ? newUser.follows.filter(followId => followId !== toggleFollowId)
        : [...newUser.follows, toggleFollowId];

      return newUser;
    case REMOVE_CURRENT_USER:
      return {};
    default:
      return state;
  }
}

const users = (state = {}, action) => {
  switch (action.type) {
    case ADD_USER:
      const { user } = action.payload;
      return Object.assign({}, state, {
        [user._id]: user,
      });
    case ADD_USERS:
      const { users } = action.payload;
      const newState = { ...state };
      users.forEach(user => {
        newState[user._id] = user;
      });

      return newState;
    default:
      return state;
  }
}

const blitzs = (state = {}, action) => {
  switch (action.type) {
    case ADD_BLITZS:
      const newState = action.payload.blitzs.reduce((acc, blitz) => {
        acc[blitz._id] = blitz;
        return acc;
      }, {});
      return Object.assign({}, state, newState);
    case ADD_BLITZ:
      const { blitz } = action.payload;
      return Object.assign({}, state, { [blitz._id]: blitz });
    default:
      return state;
  }
}

export default combineReducers({
  blitzs,
  currentUser,
  users,
});
