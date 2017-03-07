import React, {Component} from 'react';

class Filter extends Component {

  change = (e) => {
    this.props.changeFilter(e.currentTarget.id);
  }

  isChecked = (filter) => filter === this.props.filterChecked

  render() {
    return(
    <div>
    <input type="radio" name="filter" id="all" checked={this.isChecked('all')} onChange={this.change}/><label htmlFor="all">All</label>
    <input type="radio" name="filter" id="pending" checked={this.isChecked('pending')} onChange={this.change}/><label htmlFor="pending">Pending</label>
    <input type="radio" name="filter" id="completed" checked={this.isChecked('completed')} onChange={this.change}/><label htmlFor="completed">Completed</label>
    </div>
    )
  }
}

export default Filter;