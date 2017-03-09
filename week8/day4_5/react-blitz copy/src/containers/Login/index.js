import { connect } from 'react-redux';
import React, { Component } from 'react';
import { RaisedButton, TextField } from 'material-ui';

import { login } from '../../store/actions/currentUser';
import './index.css';

class Login extends Component {

  constructor(props) {
    super(props);

    this.state = {
      email: '',
      password: '',
    };
  }

  handleEmailChange = (e, email) => {
    this.setState({ email });
  }

  handlePasswordChange = (e, password) => {
    this.setState({ password });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.login({ ...this.state });
  }

  render() {
    return (
      <div className="Login">
        <form onSubmit={ this.handleSubmit }>
          <div>
            <TextField
              hintText="Email"
              floatingLabelText="Email"
              fullWidth
              onChange={ this.handleEmailChange }
              value={ this.state.email }
            />
          </div>
          <div>
            <TextField
              hintText="Password"
              floatingLabelText="Password"
              fullWidth
              onChange={ this.handlePasswordChange }
              type="password"
              value={ this.state.password }
            />
          </div>
          <div className="Login-button">
            <RaisedButton
              fullWidth
              label="Login"
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
  login: (data) => dispatch(login(data))
});

export default connect(null, mapDispatchToProps)(Login);
