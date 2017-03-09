import { List } from 'material-ui';
import React from 'react';

import BlitzItem from '../../containers/BlitzItem';

export default ({ blitzs }) =>
  <List>
    {
      blitzs.map(blitz =>
        <BlitzItem key={ blitz._id } blitz={ blitz } />
      )
    }
  </List>
