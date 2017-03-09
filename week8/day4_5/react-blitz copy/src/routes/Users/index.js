import { Paper } from 'material-ui';
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { fetchUsers } from '../../store/actions/users';
import Container from '../../components/Container';
import UserInfo from '../../containers/UserInfo';

class Users extends Component {
  componentDidMount() {
    this.props.fetchUsers();
  }

  render() {
    return (
      <Container>
        <Paper>
          {
            this.props.users.map(user =>
              <UserInfo key={ user._id } user={ user } />
            )
          }
        </Paper>
      </Container>
    )
  }
}

const mapStateToProps = (state) => {
  const users = Object.values(state.users);

  return { users }
};

const mapDispatchToProps = (dispatch) => ({
  fetchUsers: () => dispatch(fetchUsers()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Users);
