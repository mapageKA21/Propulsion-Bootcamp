import React from 'react';
import Header from '../Header';

export default ({ children }) =>
  <div className="App">
    <Header />
    { children }
  </div>;
