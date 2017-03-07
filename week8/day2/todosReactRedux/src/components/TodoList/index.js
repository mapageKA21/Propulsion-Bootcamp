import React, { Component } from 'react';
import './index.css';
import TodoItem from '../TodoItem/index.js';

class TodoList extends Component {

  render() {

    return (
      <ul>
        {
          this.props.todos.map((todo, index) => {
            return <TodoItem 
            key={index} 
            todo={todo}
            completed={this.props.completed}></TodoItem>;
          })
        }
      </ul>
    )
  }
}

TodoList.propTypes = {
  todos: React.PropTypes.array
};

export default TodoList;