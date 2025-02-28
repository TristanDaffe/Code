import React, {useState, useEffect} from 'react';
import { Text, View, StyleSheet, Image, ScrollView } from 'react-native';


import useFetchRecipes from '../services/recipes/useFetchRecipes'


//-----------------------------------------------------------------
export default function RecipeDetails({route}) {
  const {id} = route.params // Récupération de l'id de la recette (que RecipeItem avait passé en paramètre)
  const {getRecipeById} = useFetchRecipes () // Hook qui récupère les détails de la recette 
  const [details, setDetails] = useState(null)

  useEffect(()=>{
    getRecipeById(id).then((details)=>{setDetails(details)}); 
  }, [])

  if (!details){//Au cas où aucun détail n'est réccupéré
    return 
        <Text style={styles.title}>Problème de connexion</Text>
  }


  // On affiche différentes infos dans un ScrollView au cas où c'est trop long
  return (
    <ScrollView style={styles.container}>
        <Image style={styles.image} source={{uri: details.image}}/>
        <Text style={styles.title}>{details.title}</Text>
        <Text style={styles.timing}>Prêt en {details.readyInMinutes} minutes</Text>
        {/*Pour chaque ingrédient : */}
        <View style ={styles.subcontainer}>
          <Text style={styles.subtitle}>Ingrédients : </Text>
          {details.extendedIngredients?.map(ingredient =>(
            <Text>{"- "+ingredient.name+" : "+ ingredient.measures.metric.amount+" "+ingredient.measures.metric.unitShort}</Text>
          ))
          }
        </View>
        {/*Pour chaque étape : */}
        <View style ={styles.subcontainer}>
          <Text style={styles.subtitle}>Etapes : </Text>
          {details.steps?.map(step =>(
            <Text>{step.number+" : "+step.step}</Text>
          ))

          }
        </View>
    </ScrollView>
  );
}

//-----------------------------------------------------------------
const styles = StyleSheet.create({
  container: {
  },
  image: {
    width : '100%',
    height : 200,
    marginBottom : 10
  },
  title: {
    fontSize : 20,
    fontWeight : "bold",
    textAlign : 'center'
  },
  timing: {
    textAlign : 'center'
  },
  subcontainer: {
    padding : 5,
    marginRight : 20,
    marginVertical : 10,
    borderTopColor : 'grey',
    borderTopWidth : 1,
  },
  subtitle: {
    fontSize : 15,
    fontWeight : "bold",
  },
});
