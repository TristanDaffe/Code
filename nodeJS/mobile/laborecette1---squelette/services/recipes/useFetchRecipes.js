import axios from "axios";
// Pour cet exercice, nous utiliserons axios.
// Ca vous permettra d'avoir testé les deux possibilités vues en cours et axios simplifie tout de même les choses lorsqu'il s'agit d'ajouter une charge utile

// Nous allons utiliser l'API spoonacular. Pour obtenir une clé, il suffit de vous y inscrire puis de vous rendre sur votre profile
const BASE_URL_API = "https://api.spoonacular.com/recipes";
// 0. TODO : indiquer votre clé
const API_KEY = "d8b2f51a66a64befb70a6792dd939ab4";
  // /!\ Très mauvaise pratique niveau sécurité !
  //  --> une clé ne doit JAMAIS se retrouver sur un repo
  //  --> idéalmt : utiliser .env (qui n'est jamais commit) -> plus d'information : https://github.com/goatandsheep/react-native-dotenv
const MAX_RESULTS = 20;

export default function useFetchMovies () {

  const getRecipes = async () =>{ //https://spoonacular.com/food-api/docs#Search-Recipes-Complex
    try{
      // 1. TODO : récupérer dans "response" ce qu'un GET sur /complexSearch va nous renvoyer
      //    /!\ une charge utile est nécessaire. Avec axios, il s'agit d'un objet contenant l'attribut "params" qui est lui-même un objet.
      //        Dans ce cas, params contiendra 2 attributs : apiKey (votre clé) et number (le nombre de résultats souhaités) 
       
      // 2. TODO : changer le retour pour retourner ce qu'on a récupérer du serveur :
      //        à savoir ce qui se trouve dans les données (data) de la réponse
      //        puis ce qui se trouve dans "results"
      const reponse = axios.get(BASE_URL_API +"/complexSearch", {
        params: {
          apiKey: API_KEY,
          number: MAX_RESULTS
        }
      });
      const data = await (await reponse).data;
      return data.results;
     /* return [
        {
            "id": 1,
            "title": "Pasta",
            "image": "https://spoonacular.com/recipeImages/716429-312x231.jpg",
        },
        {
            "id": 2,
            "title": "Bruschetta",
            "image": "https://spoonacular.com/recipeImages/715538-312x231.jpg",
        }
    ]
    */
    } catch(e){
      console.error("getRecipesError ", e)
    }
  }
  
  const getRecipeById = async (id) =>{
    try{
      // Pour avoir les détails complets d'une recette, il y a 2 choses à faire : récupérer les infos puis les étapes à suivres
      // https://spoonacular.com/food-api/docs#Get-Recipe-Information
      // https://spoonacular.com/food-api/docs#Get-Analyzed-Recipe-Instructions
      // (lire les doc correspondantes peut être utile)

      // 3. TODO : récupérer dans "détails" ce qu'un GET sur /ID/information va renvoyer (changer ID par l'id de la recette)
      //            /!\ une charge utile avec la clé est nécessaire
      const details = await axios.get(BASE_URL_API +"/"+id+"/information", {
        params: {
          apiKey: API_KEY,
        }
      });
      // 4. TODO : récupérer dans "steps" ce qu'un GET sur /ID/analyzedInstructions va renvoyer (changer ID par l'id de la recette)
      //            /!\ une charge utile avec la clé est nécessaire
      const steps = await raxios.get(BASE_URL_API +"/"+id+"/analyzedInstructions", {
        params: {
          apiKey: API_KEY
        }
      });
      // 5. TODO : changez le retour. La réponse sera constituée des données de details et steps (attention : steps est un tableau dont seul le 1er élément nous intéresse)
      //          PS : ça donne ça : {...details.data, ...steps.data[0]};
      return {...details.data, ...steps.data[0]};

    } catch(e){
      console.error("getRecipeByIdError ", e)
    }
  }

  return{
    getRecipes,
    getRecipeById,
  }


}