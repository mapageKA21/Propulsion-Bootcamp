import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import React, { Component } from 'react';
import { Provider } from 'react-redux';
import { browserHistory, IndexRoute, Router, Route } from 'react-router';

import Home from './routes/Home';
import Feed from './routes/Feed';
import Layout from './containers/Layout';
import User from './routes/User';
import Users from './routes/Users';
import store from './store';
import { fetchLocalUser } from './store/actions/currentUser';

store.dispatch(fetchLocalUser());

class App extends Component {
  render() {
    return (
      <Provider store={ store }>
        <MuiThemeProvider>
          <Router history={ browserHistory }>
            <Route path="/" component={ Layout }>
              <IndexRoute component={ Home } />
              <Route path="/feed" component={ Feed } />
              <Route path="/users" component={ Users } />
              <Route path="/users/:userId" component={ User } />
            </Route>
          </Router>
        </MuiThemeProvider>
      </Provider>
    );
  }
}

export default App;
