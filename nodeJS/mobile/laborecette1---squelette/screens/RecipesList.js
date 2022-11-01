import React, {useState, useEffect} from 'react';
import { Text, FlatList, View, StyleSheet } from 'react-native';
import Constants from 'expo-constants';

import RecipeItem from '../components/RecipeItem';
import useFetchRecipes from '../services/recipes/useFetchRecipes'


//-----------------------------------------------------------------
export default function RecipesList({navigation}) {
  const {getRecipes} = useFetchRecipes () // Hook qui récupère les recettes
  const [recipes, setRecipes] = useState([])

  useEffect(()=>{
    getRecipes().then((recipes)=>{setRecipes(recipes)}); 
  }, [])

  // TODO : écrire le modificateur de recipes qu'il faudra passer à l'item (callback)
  const deleteRecipes = (id) =>{
    // retirer de la liste l'item dont l'id est passé en paramètre
    
    setRecipes([]);
  }


  const renderItem = ({ item }) => (
    <RecipeItem recipe={item} navigation={navigation} onDelete={deleteRecipes}/>
  );

  //FlatList pour afficher les recettes
  return (
    <View style={styles.container}>
      <FlatList
        data={recipes}
        renderItem={renderItem}
        keyExtractor={item => item.id}
      />
    </View>
  );
}

//-----------------------------------------------------------------
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
});
