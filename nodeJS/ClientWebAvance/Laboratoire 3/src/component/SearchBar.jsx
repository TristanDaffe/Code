import React from 'react';

class SearchBar extends React.Component{

    constructor(props) {
        super();
        this.state = {
            searchValue : "",
            callback: props.callback
        }
    }

    changeSearchValue(event){
        this.setState({searchValue: event.target.value}, () => {
            this.state.callback(this.state.searchValue);
        });
    }

    render(){
        return <input
            type="text"
            onChange={
                (event) => this.changeSearchValue(event)
            }/>
    }

}

export default SearchBar;