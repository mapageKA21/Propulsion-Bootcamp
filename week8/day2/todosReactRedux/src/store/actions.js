export const addTodo = (text) => {
  return {
    type: 'ADD_TODO',
    todo: text
  }
}

export const changeFilter = (filter) => {
  return {
    type: 'CHANGE_FILTER',
    filter: filter
  }
}