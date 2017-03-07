import React, { Component } from 'react';
import logo from './logo.svg';
import './index.css';

class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      quote: "fetching..."
    }
  }

  componentDidMount() {
    fetch('http://ron-swanson-quotes.herokuapp.com/v2/quotes')
      .then(res => res.json())
      .then(quotes => {
        this.setState({ quote: quotes[0] });
      });
  }

  changeQuote = () => {
    fetch('http://ron-swanson-quotes.herokuapp.com/v2/quotes')
      .then(res => res.json())
      .then(quotes => {
        this.setState({ quote: quotes[0] });
      });
  }


  render() {
    return (
         <div className="Header">
          <img src={logo} className="Header-logo" alt="logo" />
          <h2>{this.state.quote}</h2>
          <button onClick={this.changeQuote}/>
        </div>
    );
  }
}

export default Header;