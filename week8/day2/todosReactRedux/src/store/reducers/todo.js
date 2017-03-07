const initialState = {
  todos: [
  { id: 1, content: 'Master JS', completed: false },
  { id: 2, content: 'Learn React', completed: false },
  { id: 3, content: 'Learn Redux', completed: false }
  ]
};

const todoReducer = (state = initialState, action) => {
  switch (action.type) {
    case "ADD_TODO":
      return state.concat(action.todo);
    default:
      return state;
  }
}

export default todoReducer;