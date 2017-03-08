import React, { Component } from 'react';
import { connect } from 'react-redux';
import { ListItem } from 'material-ui';

import { addScore } from '../../store/actions';

class QuestionItem extends Component {

  handleClick = () => {
    const action = addScore(this.props.answer.isCorrect);
    this.props.dispatch(action);
    this.props.onNext();
  }

  render() {
    return(
      <ListItem
        onClick={ this.handleClick }
        primaryText={ <div dangerouslySetInnerHTML={ { __html: this.props.answer.content } } /> }
      />
    )
  }
}

QuestionItem.propTypes = {
  answer: React.PropTypes.shape({
    content: React.PropTypes.string,
    isCorrect: React.PropTypes.bool,
  }).isRequired,
  onNext: React.PropTypes.func.isRequired,
}



export default connect()(QuestionItem);
