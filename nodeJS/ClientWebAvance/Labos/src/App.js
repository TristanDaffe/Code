import React from 'react';
import Accueil from './composants/Accueil';
import logo from './logo.svg';
import './App.css';

// const reponse = {
//   error : true, 
//   message : "L'API ne répond plus"
// }

// const produits = [
//   {
//     nom : "pomme",
//     prix : 0.5
//   },
//   {
//     nom : "Playstation 4",
//     prix : 399.99
//   },
//   {
//     nom: "Carte abonnement Spotify 12 mois",
//     prix: 30.50
//   } 
// ]


function App() {

  // let contenu;
  // if (reponse.error) {
  //   contenu = <p>Erreur : {reponse.message}</p>
  // }
  // else{
  //   contenu = <p>Hello world !</p>
  // }

  //const estConnecte = true;

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        {
        /* <ul>
          {produits.map(p => {
            const string = `${p.nom} - ${p.prix} euro(s)`;
            return (
              <li>{string}</li>
            )
          })
          }   
        </ul> */

          <Accueil nbrConnexions={5} nomUtilisateur={"Jhon"} />

        }
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
