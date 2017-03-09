import { Paper } from 'material-ui';
import { Tabs, Tab } from 'material-ui/Tabs';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router';

import Login from '../../containers/Login';
import Register from '../../containers/Register';
import Container from '../../components/Container';

class Home extends Component {

  constructor(props) {
    super(props);

    this.state = {
      activeTab: 'login'
    }
  }

  componentDidMount() {
    this.checkUser();
  }

  componentDidUpdate() {
    this.checkUser();
  }

  checkUser() {
    if (this.props.currentUser.token) {
      this.props.router.push('/feed');
    }
  }

  handleChange = (activeTab) => {
    this.setState({ activeTab });
  }

  render() {
    return (
      <Container>
        <Paper>
          <Tabs
            value={ this.state.activeTab }
            onChange={ this.handleChange }
          >
            <Tab label="Login" value="login" >
              <Login />
            </Tab>
            <Tab label="Register" value="register">
              <Register />
            </Tab>
          </Tabs>
        </Paper>
      </Container>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    currentUser: state.currentUser
  };
}

export default connect(mapStateToProps)(withRouter(Home));
