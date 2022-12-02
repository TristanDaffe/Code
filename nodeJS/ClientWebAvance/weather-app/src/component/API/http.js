import axios from 'axios';

const URL_API = "https://api.openweathermap.org/data/2.5/weather";
const KEY = "f33a484cf794d08d0148764789aaba32";

const getWeatherById = async (id) => {
    const rep = await axios.get(URL_API, {
        params: {
            id,
            appid: KEY,
            units: 'metric',
            lang: "fr"
        }
    });
    return rep.data;
}

//vous pouvez choisir cette méthode à la place de l'autre, si vous le désirez
const getWeatherByIdFetch = async (id) => {
    const params = new URLSearchParams();
    params.append("id", id);
    params.append("appid", KEY);
    params.append("units", "metric");
    params.append("lang", "fr")
    const rep = await fetch(`${URL_API}?${params.toString()}`);
    return await rep.json();
}

export {getWeatherById, getWeatherByIdFetch};