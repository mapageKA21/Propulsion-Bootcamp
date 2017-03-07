import React, { Component } from 'react';
import './index.css';
import Header from '../Header/index.js';
import TodoList from '../TodoList/index.js';
import NewTodo from '../NewTodo/index.js';
import Filter from '../Filter/index.js';
import { connect } from 'react-redux';
import { changeFilter } from '../../store/actions.js';
import { addTodo } from '../../store/actions.js';


class App extends Component {

  constructor(props) {
    super(props);

    // this.state = {
    //   todos: [
    //   { id: 1, content: 'Master JS', completed: false },
    //   { id: 2, content: 'Learn React', completed: false },
    //   { id: 3, content: 'Learn Redux', completed: false }
    //   ],
    //   filter: 'all'
    // };
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
    this.props.dispatch(changeFilter(newFilter));
  }

  filteredTodos = () => {
    return this.props.todos.filter(todo => {
      if (this.props.filter === 'all') {
        return true;
      }
      if (this.props.filter === 'completed') {
        return todo.completed;
      }
      return !todo.completed;
    })
  }

  render() {
    console.log(this.props);
    console.log(this.props.todos);
    return (
      <div className="App">
        <Header />
        <NewTodo addTodo={ this.addTodo }/>
        <Filter filterChecked={this.props.filter} changeFilter={this.changeFilter}/>
        <TodoList todos={this.filteredTodos()}
        completed={this.markAsCompleted}/>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    todos: state.todos.todos,
    filter: state.filter
  }
}

export default connect(mapStateToProps)(App);
