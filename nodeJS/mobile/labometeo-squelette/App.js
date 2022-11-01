import React, { useEffect, useState } from 'react';
import { Image, Text, View, StyleSheet, ActivityIndicator } from 'react-native';
import Constants from 'expo-constants';
import * as Location from 'expo-location';

// TODO : Remplir avec votre clé
const API_KEY = 'fcc16d60733e99bc6aa51a54c6282f07';
  // Pour obtenir une clé : s'inscrire sur https://openweathermap.org/
  // Une fois connecté, allez sur votre compte > My API keys, vous pourrez générer une clé
  // PS : il faut parfois un peut de temps pour rendre la clé active... patience
const API_URL = (lat, lon) =>
  `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&lang=fr&units=metric`;
  // doc : https://openweathermap.org/current#one
const getIcon = (icon)=>`http://openweathermap.org/img/wn/${icon}@4x.png`
  // doc : https://openweathermap.org/weather-conditions


//----------- Composant principal -------------
//---------------------------------------------
export default function App() {
  const [data, setData] = useState(null); // stock les données de l'API
  const [loading, setLoading] = useState(true); // dit si c'est en chargement (donc pas encore de données)

  // Il nous faudra 2 fonctions :
  //  - getCoordinate : retourne les coordonnées de l'utilisateur
  //  - getWeather : utilise getCoordinate avant de faire appel à l'API pour avoir le temps corrrespondant à ces coordonnées
  const getCoordinate = async () => {
    // 1. Demander l'autorisation
    const { status } = await Location.requestForegroundPermissionsAsync();
    if (status !== 'granted') { // refus
      console.log('getCoordinateError : refus');
      return;
    }
    // 2. Si ok : récupérer la position
    const userLocation = await Location.getCurrentPositionAsync();
    return userLocation;
    // userLocation contiendra notamment .coords qui contiendra .latitude et .longitude
    };

  const getWeather = async () => {
    try {
      // 1. TODO : récupérer les coordonnées
      const userLocation = await getCoordinate();
      // 2. TODO : contacter le serveur avec les bons paramètres (via fetch) et récupérer la réponse
      const reponse = await fetch(API_URL(userLocation.coords.latitude, userLocation.coords.longitude));
      // 3. TODO : récupérer le json
      const json = await reponse.json();
      // 4. TODO : mettre le json dans data (en utilisant le setter bien sûr)
      setData(json);
      // 5. TODO : on a fini de charger donc mettre loading à false (toujours avec le setter)
      setLoading(false);
    } catch {
      console.log('getWeatherError');
    }
  };

  //----------- useEffect -------------
  useEffect(() => {
    getWeather();
  }, []);

  //----------- Affichage -------------
  //Si pas de location : juste un message
  if (loading) {
    return (
      <View style={styles.container}>
        <ActivityIndicator />
      </View>
    );
  }
  
  //TODO : Si location : affiche les infos : 
  return (
    <View style={styles.container}>
      <Text style={styles.city}>{data.name}</Text>
      <Text>Aujourd'hui</Text>
      <Image
        source={{uri:getIcon(data.weather[0].icon)}}
        style={styles.icon}
        />
      <Text style={styles.temp}>{data.main.temp}°C</Text>
      <Text>{data.weather[0].description}</Text>
    </View>
  );
}

//----------- StyleSheet -------------
//------------------------------------
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems : 'center',
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#e2e6e1',
    padding: 8,
  },
  icon: {
    height: 150,
    width: 150,
  },
  city: {
    fontSize : 36,
  },
  temp: {
    fontSize : 60,
    fontWeight : "bold",
    color : "#545658"
  }
});
