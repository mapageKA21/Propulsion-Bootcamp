import { List, Paper} from 'material-ui';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router';

import QuestionItem from '../QuestionItem';
import mapStateToProps from './mapStateToProps';

const paperStyle = {
  margin: '50px auto',
  padding: '30px 30px 10px 30px',
  width: '50%',
};

class Question extends Component {

  handleNext = () => {
    if (this.props.isLast) {
      this.props.router.push('/result');
      return;
    }
    this.props.router.push(`/questions/${this.props.question.order + 1}`);
  }

  render() {
    if (!this.props.question) {
      return <Paper />
    }

    return (
      <Paper style={ paperStyle }>
        <p dangerouslySetInnerHTML={ { __html: this.props.question.question } } />
        <List>
          {
            this.props.question.answers.map((answer, index) =>
              <QuestionItem
                key={ index }
                answer={ answer }
                onNext={ this.handleNext }/>
            )
          }
        </List>
      </Paper>
    )
  }
}

export default connect(mapStateToProps)(withRouter(Question));
