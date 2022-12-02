import React from 'react';
import {
    BrowserRouter,
    Routes,
    Route
} from 'react-router-dom';

import DoubleSearch from '../pages/DoubleSearch';
import CityWeather from '../pages/CityWeather';

const Router = () => {
    return(
        <BrowserRouter>
            <Routes>
                <Route path={"/city/:name"} element={<CityWeather/>}/>
                <Route path={"/"} element={<DoubleSearch/>}/>
            </Routes>
        </BrowserRouter>
    );
};

export default Router;