import React from "react";

import List from "components/List";
import listMovies from "movies.json";
import './App.css';

export default class App extends React.Component{
  state = {
    favItems: [],
    del: "Delete",
    isActive: false,
  };

  handleDeleteButtonFav = (deleteItem) => {
    this.setState({
      favItems: deleteItem,
    }, () => {console.log(this.state.favItems)});
    this.setState({isActive: false});
  };


  handleItemClickforFav = (item) => {
    //Immutability
    const newItems = [ ...this.state.favItems];
    const newItem = { ...item };
    //Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);

    if(targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1); //Delete 1 item at index targetInd

    //Trigger set state
    this.setState({ favItems: newItems });
  };

  handleItemClick = (item) =>{
    //Immutability
    const newItems = [ ...this.state.favItems];
    const newItem = { ...item };
    //Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);

    if(targetInd < 0) newItems.push(newItem);

    this.setState({isActive: true});
    //Trigger set state
    this.setState({ favItems: newItems });
  }

  render(){
    const { favItems } = this.state;

    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a  <strong>class-based</strong> application)
        </p>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemClick} 
              />
            </div>
            <div className="col-sm">
              <List
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleItemClickforFav }
              />
            </div>
          </div>
        </div>
        <div className="text-center">
          {this.state.isActive? (
            <button onClick={() => {this.handleDeleteButtonFav([])}}>{this.state.del}</button>
          ) : (
            null
          )}
        </div>
      </div>
    );
  }
}