import React from 'react';
import WeatherImage from '../WeatherImage';

const WeatherInformation = (props) => {
    const weather = props.weather;

    return (
        <div className='flex_vertically'>
            <p className='city_name'>{props.cityName}</p>
            <WeatherImage weatherIcon={weather.icon}
                          description={weather.description}/>
            <p>{`${weather.main}: ${weather.description}`}</p>
            <p>Température: {Math.round(props.temp)}°</p>
        </div>
    );
};

export default WeatherInformation;