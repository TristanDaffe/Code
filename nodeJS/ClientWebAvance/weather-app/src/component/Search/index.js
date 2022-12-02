import React from 'react';
import {loadData} from '../API'
import WeatherInFormation from '../WeatherInformation'

class Search extends React.Component{

    constructor(props){
        super(props);
        const state = {
            searchValue: "",
            cityName: "",
            weather: {},
            loaded: false,
            loading: false,
            error: false,
            errorMessage: "",
            temp: 0
        };
        this.state = state;
    }

    search() {
        this.setState({loading: true, error: false}, async () => {
            try{
                const result = await loadData(this.state.searchValue);
                const state = {
                    loaded: true,
                    loading: false,
                    cityName: result.cityName,
                    weather: result.weather,
                    temp: result.temp
                };
                this.setState(state);
            } catch (e) {
                this.setState({
                    error: true,
                    loading: false,
                    loaded: true,
                    errorMessage: e.message
                });
            }
        });

    }

    render() {
        let Content;
        if(this.state.loaded === false){
            Content = null;
        } else if(this.state.loading === true){
            Content =  <p>Chargement en cours</p>
        } else if(this.state.error){
            Content = <p>{this.state.errorMessage}</p>
        } else if(this.state.weather.id){
            Content = <WeatherInFormation
                cityName={this.state.cityName}
                weather={this.state.weather}
                temp={this.state.temp}
            />
        }

        return(
            <div>
                <input onChange={(e) => this.setState({searchValue: e.target.value})}/>
                <button onClick={() => this.search()}>Recherche</button>
                {Content && Content}
            </div>
        );
    }

}

export default Search;