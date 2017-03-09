import { Avatar, ListItem } from 'material-ui';
import FavoriteBorderIcon from 'material-ui/svg-icons/action/favorite-border';
import FavoriteIcon from 'material-ui/svg-icons/action/favorite';
import { blue500 } from 'material-ui/styles/colors';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router';

import './index.css';
import { likeBlitz } from '../../store/actions/blitz';

const iconStyles = {
  cursor: 'pointer',
  float: 'right',
};

class BlitzItem extends Component {

  handleLike = () => {
    const action = likeBlitz(this.props.blitz._id);
    this.props.dispatch(action);
  }

  render() {
    const { blitz } = this.props;
    const { _user } = blitz;

    const BlitzContent =
      <div>
        {
          blitz.isLiked
          ? <FavoriteIcon color={ blue500 } style={ iconStyles } onClick={ this.handleLike } />
          : <FavoriteBorderIcon color={ blue500 } style={ iconStyles } onClick={ this.handleLike } />
        }
        <Link to={ `/users/${_user._id}` }><p className="BlitzItem-username">{ _user.username }</p></Link>
        <p className="BlitzItem-content">{ blitz.content }</p>
      </div>;

    return (
      <ListItem
        disabled
        leftAvatar={ <Avatar src={ _user.avatar } /> }
        primaryText={ BlitzContent }
      />
    )
  }
}

export default connect()(BlitzItem);
