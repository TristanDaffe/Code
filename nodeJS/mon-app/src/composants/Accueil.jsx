import React from 'react';

function Accueil(props) {

    const nbrConnexions = props.nbrConnexions;
    const nomUtilisateur = props.nomUtilisateur;

    const message = `Bienvenue ${nomUtilisateur} !
    Aujourd'hui, vous vous êtes connecté ${nbrConnexions} fois
    `;

  return (
      <p>{message}</p>
  );

}
export default Accueil;