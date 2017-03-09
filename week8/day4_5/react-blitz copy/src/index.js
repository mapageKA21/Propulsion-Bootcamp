import React from 'react';
import ReactDOM from 'react-dom';
import injectTapEventPlugin from 'react-tap-event-plugin';

import App from './App';
import './index.css';

// Needed for onTouchTap
// http://stackoverflow.com/a/34015469/988941
injectTapEventPlugin();

ReactDOM.render(
  <App />,
  document.getElementById('root')
);

const myHeaders = new Headers({
	'Content-Type':'application/json'
})

const user = {
	email: 'ake0@email.com',
	password: 'password'
}

const config = {
	method: 'POST',
	headers: myHeaders,
	body: JSON.stringify(data)
}

fetch('https://propulsion-blitz.herokuapp.com/api/login', config)
	.then(res => res.json())
	.then(user => console.log(user));
