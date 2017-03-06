import React, { Component } from 'react';
import './index.css';
import Header from '../Header/index.js';
import TodoList from '../TodoList/index.js';
import NewTodo from '../NewTodo/index.js';
import Filter from '../Filter/index.js';

class App extends Component {
  
  constructor(props) {
    super(props);

    this.state = {
      todos: [
      { id: 1, content: 'Master JS', completed: false },
      { id: 2, content: 'Learn React', completed: false },
      { id: 3, content: 'Learn Redux', completed: false }
      ],
      filter: 'all'
    };
  }

  addTodo = (newTodo) => {
    const todo = {id: this.state.todos.length + 1, content: newTodo, completed: false}
    const todos = this.state.todos.concat(todo);
    this.setState({ todos });
  }

  markAsCompleted = (todoId) => {
    const todos = this.state.todos.map((element) => {
      let obj = {id: element.id, content: element.content, completed: element.completed};
      if (element.id === todoId)  obj.completed = !obj.completed;
      return obj;
    })
    this.setState({todos})
    }

  changeFilter = (newFilter) => {
    this.setState({
      todos: this.state.todos,
      filter: newFilter
    })
  }

  filteredTodos = () => {
    return this.state.todos.filter(todo => {
      if (this.state.filter === 'all') {
        return true;
      }
      if (this.state.filter === 'completed') {
        return todo.completed;
      }
      return !todo.completed;
    })
  }

  render() {
    return (
      <div className="App">
        <Header />
        <NewTodo addTodo={ this.addTodo }/>
        <Filter filterChecked={this.state.filter} changeFilter={this.changeFilter}/>
        <TodoList todos={this.filteredTodos()} 
        completed={this.markAsCompleted}/>
      </div>
    );
  }
}

export default App;
