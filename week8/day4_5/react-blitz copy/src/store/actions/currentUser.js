import {
  API,
  urlBase,
  REMOVE_CURRENT_USER,
  SET_CURRENT_USER,
  TOGGLE_FOLLOW
} from '../constants';

const setCurrentUser = (user) => ({
  type: SET_CURRENT_USER,
  payload: { user }
});

const removeCurrentUser = () => ({
  type: REMOVE_CURRENT_USER,
})

export const login = (data) => (dispatch) => {
  const myHeaders = new Headers({
    'Content-Type': 'application/json'
  });
  const config = {
    method: 'POST',
    headers: myHeaders,
    body: JSON.stringify(data),
  };

  return fetch(`${urlBase}/api/login`, config)
    .then(res => res.json())
    .then(user => {
      const action = setCurrentUser(user);
      dispatch(action);
      localStorage.setItem('userToken', JSON.stringify(user.token));
    })
    .catch(err => {
      console.log(err);
    })
}

const registerUser = (user) => (dispatch) => {
  const action = setCurrentUser(user);
  dispatch(action);
  localStorage.setItem('userToken', JSON.stringify(user.token));
}

export const register = (data) => ({
  type: API,
  url: '/api/users',
  method: 'POST',
  success: registerUser,
  data,
});

export const logout = () => (dispatch) => {
  const action = removeCurrentUser();
  dispatch(action);
  localStorage.clear();
}

export const fetchCurrentUser = () => ({
  type: API,
  url: '/api/me',
  success: setCurrentUser,
});

export const fetchLocalUser = () => (dispatch) => {
  const userToken = JSON.parse(localStorage.getItem('userToken'));
  if (userToken) {
    dispatch(setCurrentUser({ token: userToken }));
    dispatch(fetchCurrentUser());
  }
}

export const toggleFollow = (userId) => ({
  type: TOGGLE_FOLLOW,
  payload: { userId }
});
