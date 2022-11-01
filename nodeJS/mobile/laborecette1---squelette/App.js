import React, {useState} from 'react';
import { FlatList, View, StyleSheet, StatusBar } from 'react-native';
import Constants from 'expo-constants';

// L'application possède 2 écrans différents
import RecipesList from './screens/RecipesList';
import RecipeDetails from './screens/RecipeDetails';

// Pour cet exercice, nous avons besoin d'un peu de navigation en stack.
// Nous devons importer ceci (pensez à ajouter les dépendances ou à les installer !)
import {NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
const Stack = createNativeStackNavigator()


export default function App() {


  // Nous avons un container de navigation qui contient une navigation par stack
  //      dans laquelle nous avons définis les écrans atteignables.
  // Dès lors, chaque composant indiqué dans la stack reçois automatiquement en paramètre
  //      l'objet "navigation" qui permettra de naviguer entre ces écrans     ==> voir RecipeItem
  //      et l'objet "route" qui permet de "savoir d'où l'on vient et avec quoi" (notamment si des paramètres sont transmis) ==> voir RecipeDetails
  return (
    <View style={styles.container}>
        <StatusBar style="auto" />

        <NavigationContainer>
          <Stack.Navigator>
            <Stack.Screen name="Liste des recettes" component={RecipesList} />
            <Stack.Screen name="Détails" component={RecipeDetails} />
          </Stack.Navigator>
        </NavigationContainer>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
});
