import Routes from "./routes/Routes";


const API_KEY = 'fcc16d60733e99bc6aa51a54c6282f07';
const API_URL = (city, apyKey) =>
  new URL(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apyKey}`);

const getIcon = (icon)=>`http://openweathermap.org/img/wn/${icon}@4x.png`;


function App() {
  return (
    <div className="App">
      <Routes />
      <p>{(API_URL('Namur', API_KEY).search)}</p>
    </div>
  );
}

export default App;
