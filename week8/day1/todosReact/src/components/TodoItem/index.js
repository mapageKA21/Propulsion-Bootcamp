import React, { Component } from 'react';
import './index.css';

class TodoItem extends Component {

  handleClick = () => {
    this.props.completed(this.props.todo.id)
    console.log('you clicked the element!');
  }

  render() {

    return (
      <li className={ this.props.todo.completed ? 'TodoItem-completed' : '' }
      onClick={this.handleClick}>
        {this.props.todo.content}
      </li>
    )
  }
}

TodoItem.propTypes = {
  todo: React.PropTypes.object.isRequired
};

TodoItem.defaultProps = {
  todo: 'Learn PropTypes!'
};

export default TodoItem;