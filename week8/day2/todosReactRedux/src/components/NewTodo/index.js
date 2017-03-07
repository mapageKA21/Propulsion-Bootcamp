import React, { Component } from 'react';

class NewTodo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newTodo: ""
    };
  }

  handleNewTodoChange = (e) => {
    this.setState({newTodo: e.currentTarget.value});
  }

  addNewTodo = () => {
    this.props.addTodo(this.state.newTodo);
    this.setState({ newTodo: '' });
  }

  render() {
    return(
      <div className="NewTodo">
        <input 
          type="text"
          placeholder="Add todo"
          value={ this.state.newTodo.content }
          onChange={ this.handleNewTodoChange } 
        />
        <button onClick={ this.addNewTodo }> Add todo </button>
      </div>
      );
  }
}

export default NewTodo;
