import { CircularProgress, Paper } from 'material-ui';
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { fetchFeed } from '../../store/actions/blitz';
import Container from '../../components/Container';
import BlitzList from '../../components/BlitzList';
import NewBlitzForm from '../../containers/NewBlitzForm';

class Feed extends Component {

  componentDidMount() {
    this.props.dispatch(fetchFeed());
  }

  render() {
    if (!this.props.blitzs.length) {
      return <Container><Paper><CircularProgress /></Paper></Container>;
    }

    return (
      <Container>
        <Paper>
          <NewBlitzForm />
          <BlitzList blitzs={ this.props.blitzs } />
        </Paper>
      </Container>
    )
  }
}

const mapStateToProps = (state) => {
  const currentUser = state.currentUser;
  let feed = [];
  if (currentUser) {
    const users = currentUser.follows ? currentUser.follows.concat(currentUser._id) : [];
    feed = Object.values(state.blitzs).filter(blitz => users.indexOf(blitz._user._id) > -1);
  }
  feed.sort((blitz1, blitz2) => {
    return new Date(blitz2.created_at) - new Date(blitz1.created_at);
  });

  return {
    blitzs: feed
  };
};

export default connect(mapStateToProps)(Feed);
