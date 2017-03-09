import { Avatar, RaisedButton } from 'material-ui'
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router';

import './index.css';
import { toggleFollowUser } from '../../store/actions/users';

const buttonStyle = {
  float: 'right',
};

class UserInfo extends Component {

  handleFollow = () => {
    this.props.toggleFollowUser(this.props.user._id);
  }

  render() {
    const { user } = this.props;

    return (
      <div className="UserInfo">
        <div className="UserInfo-avatar">
          <Avatar src={ user.avatar } size={ 96 } />
        </div>
        <div className="UserInfo-details">
          <Link to={ `/users/${user._id}` }>
            <h4>{ user.username }</h4>
          </Link>
          <p>{ user.email }</p>
          <p>{ `Follows: ${user.follows.length}` }</p>
        </div>
        <RaisedButton
          label={ user.isFollowed ? 'Stop following' : 'Follow' }
          primary
          onClick={ this.handleFollow }
          style={ buttonStyle }
        />
      </div>
    )
  }
}

const mapDispatchToProps = (dispatch) => ({
  toggleFollowUser: (userId) => dispatch(toggleFollowUser(userId)),
});

export default connect(null, mapDispatchToProps)(UserInfo);
