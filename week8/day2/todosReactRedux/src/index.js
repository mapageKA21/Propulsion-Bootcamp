import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App/index.js'
import './index.css';
import { Provider } from 'react-redux';
import store from './store';

ReactDOM.render(
  <Provider store={ store }>
  <App />
  </Provider>,
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