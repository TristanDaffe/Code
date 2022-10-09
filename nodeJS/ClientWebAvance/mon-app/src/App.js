import React from 'react';
import Accueil from './composants/Accueil';

function App() {
  return (
    <div className="App">
      <Accueil nbrConnexions={5} nomUtilisateur={"John"}/>
    </div>
  );
}

export default App;




