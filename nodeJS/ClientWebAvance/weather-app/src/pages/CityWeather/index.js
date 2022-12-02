import React from 'react';
import {loadData} from '../../component/API'
import WeatherInFormation from '../../component/WeatherInformation'
import {useParams} from 'react-router-dom'

function withParams(Component){
    return props => <Component {...props} params={useParams()}/>
}

class CityWeather extends React.Component{

    constructor(props){
        super(props);
        const state = {
            cityName: props.params.name,
            weather: {},
            loading: true,
            error: false,
            errorMessage: "",
            temp: 0
        };
        this.state = state;
    }

    componentDidMount() {
        this.search();
    }

    search() {
        this.setState({loading: true, error: false}, async () => {
            try{
                const result = await loadData(this.state.cityName);
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
        if(this.state.loading === true){
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
            <>
                {Content}
            </>
        );
    }

}

export default withParams(CityWeather);