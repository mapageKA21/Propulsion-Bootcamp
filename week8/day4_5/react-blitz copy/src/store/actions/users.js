import {
  urlBase,
  API,
  ADD_USER,
  ADD_USERS
} from '../constants';
import { addBlitzs } from './blitz';
import { toggleFollow } from './currentUser';

const addUser = (user) => ({
  type: ADD_USER,
  payload: { user }
});

const addUsers = (users) => ({
  type: ADD_USERS,
  payload: { users },
});

export const fetchUsers = () => ({
  type: API,
  url: '/api/users',
  success: addUsers
})

export const fetchUser = (userId) => (dispatch, getState) => {
  const user = getState().currentUser;
  const myHeaders = new Headers({
    Authorization: `Bearer ${user.token}`
  });
  const config = {
    method: 'GET',
    headers: myHeaders,
  };

  return fetch(`${urlBase}/api/users/${userId}`, config)
    .then(res => res.json())
    .then(user => {
      const { blitzs } = user;
      const blitzsAction = addBlitzs(blitzs);
      dispatch(blitzsAction);
      delete user.blitzs;
      const userAction = addUser(user);
      dispatch(userAction);
    })
    .catch(err => {
      console.log('in da fetchUser error');
      console.log(err);
    })
}

export const toggleFollowUser = (userId) => (dispatch, getState) => {
  const { currentUser } = getState();
  const myHeaders = new Headers({
    Authorization: `Bearer ${currentUser.token}`
  });
  const config = {
    method: 'POST',
    headers: myHeaders,
  };

  return fetch(`${urlBase}/api/users/${userId}/follow`, config)
    .then(res => res.json())
    .then(user => {
      const addUserAction = addUser(user);
      dispatch(addUserAction);
      const toggleFollowAction = toggleFollow(user._id);
      dispatch(toggleFollowAction);
    })
}
