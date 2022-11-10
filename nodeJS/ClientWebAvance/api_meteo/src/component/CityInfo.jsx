import React from "react";
//import { connect } from "react-redux";
import { Navigate, useParams } from "react-router-dom"; 

function withParams(Component) {
	return (props) => <Component {...props} params={useParams()} />;
}

const API_KEY = 'fcc16d60733e99bc6aa51a54c6282f07';
const API_URL = (city, apiKey) =>{
    console.log(city);
    const baseURL = new URL('/', 'https://api.openweathermap.org/data/2.5/weather');
    const urlCity = new URL(baseURL, `?q=${city}`);
    const urlComplete = new URL(urlCity, `&appid=${apiKey}&lang=fr&units=metric`);
    return urlComplete;
}
  const getIcon = (icon)=>
    `http://openweathermap.org/img/wn/${icon}@4x.png`;


class CityInfo extends React.Component {
    constructor(props) {
        console.log(props);
        super(props);
        const city = this.props.city;
        this.state ={
            city,
            cityInfos: {
                name: '',
                weather: [{
                    description: '',
                    icon: ''
                }],
                main: {
                    temp: 0,
                }
            },
            redirect: false,
        }
    }

    componentDidMount () {
        try{
            fetch(API_URL(this.state.city, API_KEY))
                .then((response) => this.setState({cityInfos : response.json()}));
            }
        catch(error){
                console.log(error);
        }
    }

    render() {
        return(
            <div>
                <label>{this.state.cityInfos.name}</label>
                <img src={{uri:getIcon(this.state.cityInfos.weather[0].icon)}} alt="icon"/>
                <label>{this.state.cityInfos.weather[0].description}</label>
                <label>Température: {this.state.cityInfos.main.temp}</label>
            </div>
        );
    }
}

export default (CityInfo);
