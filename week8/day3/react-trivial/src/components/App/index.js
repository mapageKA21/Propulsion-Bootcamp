import React, { Component } from 'react';
import { connect } from 'react-redux';
import RaisedButton from 'material-ui/RaisedButton';
import { Link } from 'react-router';

import './index.css';
import { fetchQuestions } from '../../store/actions';

class App extends Component {

  componentDidMount() {
    this.props.dispatch(fetchQuestions());
  }

  render() {
    return (
      <div className="App-intro">
        <Link to="/questions/1">
          <RaisedButton label="Start" />
        </Link>
      </div>
    );
  }
}

export default connect()(App);
