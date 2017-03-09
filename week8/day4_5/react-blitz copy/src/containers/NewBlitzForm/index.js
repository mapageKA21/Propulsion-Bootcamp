import { RaisedButton, TextField } from 'material-ui';
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { createBlitz } from '../../store/actions/blitz';
import './index.css';

class NewBlitzForm extends Component {

  constructor(props) {
    super(props);

    this.state = { content: '' };
  }

  handleContentChange = (e, content) => {
    this.setState({ content });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.createBlitz({ content: this.state.content });
    this.setState({ content: '' });
  }
  render() {
    return (
      <div className="NewBlitzForm">
        <form onSubmit={ this.handleSubmit }>
          <div>
            <TextField
              hintText="Blitz..."
              fullWidth
              onChange={ this.handleContentChange }
              value={ this.state.content }
            />
          </div>
          <div>
            <RaisedButton
              label="Blitz"
              primary
              type="submit"
            />
          </div>
        </form>
      </div>
    )
  }
}

const mapDispatchToProps = (dispatch) => ({
  createBlitz: (data) => dispatch(createBlitz(data)),
});

export default connect(null, mapDispatchToProps)(NewBlitzForm);
