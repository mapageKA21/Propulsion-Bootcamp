import React, { Component } from 'react';
import { connect } from 'react-redux';
import './index.css';

class Result extends Component {
  render() {
    return(
      <div className="Result">
        <h4>Game finished!</h4>
        <p>{ `Your score is ${this.props.score}`}</p>
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  score: state.scores.filter(score => score).length,
});

export default connect(mapStateToProps)(Result);
