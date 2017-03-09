import { AppBar, FlatButton, IconMenu, MenuItem, IconButton } from 'material-ui';
import MoreVertIcon from 'material-ui/svg-icons/navigation/more-vert';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter, Link } from 'react-router';

import { logout } from '../../store/actions/currentUser';

class Layout extends Component {

  handleLogout = () => {
    this.props.logout();
    this.props.router.push('/');
  }

  renderLoggedMenu() {
    return (
      <IconMenu
        iconButtonElement={
          <IconButton><MoreVertIcon /></IconButton>
        }
        targetOrigin={{horizontal: 'right', vertical: 'top'}}
        anchorOrigin={{horizontal: 'right', vertical: 'top'}}
      >
        <MenuItem><Link to="/users">Users</Link></MenuItem>
        <MenuItem><Link to="/feed">Feed</Link></MenuItem>
        <MenuItem primaryText="Sign out" onTouchTap={ this.handleLogout }/>
      </IconMenu>
    )
  }

  renderLogin() {
    return (
      <FlatButton label="Login" />
    );
  }

  render() {
    return (
      <div>
        <AppBar
          title="Blitz"
          iconElementRight={ this.props.currentUser.token ? this.renderLoggedMenu() : this.renderLogin() }
        />
        { this.props.children }
      </div>
    )
  }
}

const mapStateToProps = (state) => ({
  currentUser: state.currentUser,
});

const mapDispatchToProps = (dispatch) => ({
  logout: () => dispatch(logout())
});

export default connect(mapStateToProps, mapDispatchToProps)(withRouter(Layout));
