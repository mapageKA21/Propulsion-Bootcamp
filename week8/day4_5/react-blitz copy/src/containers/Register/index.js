import { connect } from 'react-redux';
import React, { Component } from 'react';
import { RaisedButton, TextField } from 'material-ui';

import { register } from '../../store/actions/currentUser';
import './index.css';

class Login extends Component {

  constructor(props) {
    super(props);

    this.state = {
      email: '',
      password: '',
      confirmPassword: '',
      username: '',
    };
  }

  handleEmailChange = (e, email) => {
    this.setState({ email });
  }

  handlePasswordChange = (e, password) => {
    this.setState({ password });
  }

  handleConfirmPasswordChange = (e, confirmPassword) => {
    this.setState({ confirmPassword });
  }

  handleUsernameChange = (e, username) => {
    this.setState({ username });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.register({
      email: this.state.email,
      username: this.state.username,
      password: this.state.password,
    });
  }

  render() {
    return (
      <div className="Register">
        <form onSubmit={ this.handleSubmit }>
          <div>
            <TextField
              hintText="Username"
              floatingLabelText="Username"
              fullWidth
              onChange={ this.handleUsernameChange }
              value={ this.state.username }
            />
          </div>
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
          <div>
            <TextField
              hintText="Confirm Password"
              floatingLabelText="Confirm Password"
              fullWidth
              onChange={ this.handleConfirmPasswordChange }
              type="password"
              value={ this.state.confirmPassword }
            />
          </div>
          <div className="Register-button">
            <RaisedButton
              fullWidth
              label="Register"
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
  register: (data) => dispatch(register(data))
});

export default connect(null, mapDispatchToProps)(Login);
