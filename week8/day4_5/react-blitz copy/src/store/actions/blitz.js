import {
  ADD_BLITZ,
  ADD_BLITZS,
  API,
  urlBase
} from '../constants';

export const addBlitzs = (blitzs) => ({
  type: ADD_BLITZS,
  payload: { blitzs }
});

const addBlitz = (blitz) => ({
  type: ADD_BLITZ,
  payload: { blitz }
});

// Example using the custom api middlware
export const fetchFeed = () => ({
  type: API,
  url: '/api/feed',
  method: 'GET',
  success: addBlitzs,
});

export const likeBlitz = (blitzId) => (dispatch, getState) => {
  const user = getState().currentUser;
  const myHeaders = new Headers({
    Authorization: `Bearer ${user.token}`
  });
  const config = {
    method: 'POST',
    headers: myHeaders,
  };

  return fetch(`${urlBase}/api/blitzs/${blitzId}/like`, config)
    .then(res => res.json())
    .then(blitz => {
      const addBlitzAction = addBlitz(blitz);
      dispatch(addBlitzAction);
    })
}

export const createBlitz = (data) => ({
  type: API,
  url: '/api/blitzs',
  method: 'POST',
  data,
  success: addBlitz,
});
