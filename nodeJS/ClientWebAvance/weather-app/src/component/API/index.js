import {getWeatherById} from './http';
import {convertNameToID} from '../../utils';

const loadData = async (cityName) => {
    const cityID = convertNameToID(cityName);
    if(cityID !== undefined){
        try {
            const data = await getWeatherById(cityID);
            return {
                cityName: data.name,
                weather: data.weather[0],
                temp: data.main.temp
            };
        } catch (e) {
            throw new Error("Un problème est survenu, réessayer plus tard");
        }
    } else {
        throw new Error("Cette ville est inconnue");
    }
};

export {loadData};