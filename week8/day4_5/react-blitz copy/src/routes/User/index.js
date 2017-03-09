import { CircularProgress, Paper } from 'material-ui';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router';

import Container from '../../components/Container';
import BlitzList from '../../components/BlitzList';
import UserInfo from '../../containers/UserInfo';
import { fetchUser } from '../../store/actions/users';

class User extends Component {

  componentDidMount() {
    this.props.fetchUser(this.props.router.params.userId)
  }

  render() {
    if (!this.props.user) {
      return <Container><Paper><CircularProgress /></Paper></Container>;
    }

    return (
      <Container>
        <Paper>
          <UserInfo user={ this.props.user } />
          <BlitzList blitzs={ this.props.blitzs } />
        </Paper>
      </Container>
    )
  }
}

const mapStateToProps = (state, props) => {
  const user = state.users[props.router.params.userId];
  let blitzs;
  if (user) {
    blitzs = Object.values(state.blitzs).filter(blitz => blitz._user._id === user._id);
  }

  return {
    user,
    blitzs,
  };
}

const mapDispatchToProps = (dispatch) => ({
  fetchUser: (userId) => dispatch(fetchUser(userId)),
});

export default connect(mapStateToProps, mapDispatchToProps)(withRouter(User));
