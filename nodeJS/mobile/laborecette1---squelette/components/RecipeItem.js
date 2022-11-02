import * as React from 'react';
import { Text, View, StyleSheet, Image, Pressable } from 'react-native';

export default function RecipeItem({recipe, navigation, onDelete}) {

  // Fonction pour voir les détails d'une recette (il faudra passer l'id de la recette en paramètre)
  const goDetails = ()=>{
    navigation.navigate("Détails", {id:recipe.id})
  }

  // Fonction pour supprimer une recette
  const deleteRecipe = ()=>{
    onDelete(recipe.id)
  }


  // Un item sera composé de :
  //  - l'image et le titre "pressable" qui permettra de naviguer vers l'écran de "Détail"
  //  - la poubelle "pressable" qui permettra de supprimer l'élément
  return (
    <View style={styles.container}>
      {/* image et titre pressable */}
      <Pressable style={styles.container} onPress={goDetails}>
        <Image style={styles.image} source={{uri: recipe.image}}/>
        <View style={styles.subcontainer}>
          <Text style={styles.paragraph}>{recipe.title}</Text>
        </View>
      </Pressable>
      {/* poubelle pressable */}
      <Pressable style={{}} onPress={deleteRecipe}>
        <Image style={styles.logo} source={require('../assets/bin.png')}/>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex:1,
    flexDirection : 'row',
    alignItems: 'center',
    padding: 10,
  },
  subcontainer: {
    width : '70%',
    padding : 8
  },
  paragraph: {
    fontSize: 14,
    fontWeight: 'bold',
  },
  image: {
    height: 40,
    width: '30%',
  },
  logo: {
    height: 25,
    width: 25,
  }
});
