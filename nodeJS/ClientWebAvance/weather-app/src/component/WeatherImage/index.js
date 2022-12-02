import React from 'react';

const WeatherImage = (props) => {
    return <img
        src={`http://openweathermap.org/img/wn/${props.weatherIcon}@2x.png`}
        alt={props.description}/>
};

export default WeatherImage;