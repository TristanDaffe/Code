
let nbColonnes;
let nbLignes
let plateau;
let table;

function clic(i,j){
    return function(){
        let elem = table[i][j];
        if (elem.className == ""){
            elem.style.backgroundColor = "green";
            elem.className = "vivant";
        } else {
            elem.style.backgroundColor = "white";
            elem.className = "";
        }
    }
    
}

function changeEtat(i,j){
    let elem = table[i][j];
        if (elem.className == ""){
            elem.style.backgroundColor = "green";
            elem.className = "vivant";
        } else {
            elem.style.backgroundColor = "white";
            elem.className = "";
        }
}

function getVoisins(i,j){
    let voisins = [];
    if(i>0){
        voisins.push(table[i-1][j]);
    }
    if(i<nbLignes-1){
        voisins.push(table[i+1][j]);
    }
    if(j>0){
        voisins.push(table[i][j-1]);
    }
    if(j<nbColonnes-1){
        voisins.push(table[i][j+1]);
    }
    if(i>0 && j>0){
        voisins.push(table[i-1][j-1]);
    }
    if(i>0 && j<nbColonnes-1){
        voisins.push(table[i-1][j+1]);
    }
    if(i<nbLignes-1 && j>0){
        voisins.push(table[i+1][j-1]);
    }
    if(i<nbLignes-1 && j<nbColonnes-1){
        voisins.push(table[i+1][j+1]);
    }
    return voisins;
}

function getNbVoisinsVivants(voisins){
    let nbVoisinsVivants = 0;
    for(let i=0; i<voisins.length; i++){
        if(voisins[i].className == "vivant"){
            nbVoisinsVivants++;
        }
    }
    return nbVoisinsVivants;
}

function avancer() {
let cellule 

    for (let i = 0; i < nbLignes; i++){
        for (let j = 0; j < nbColonnes; j++){
            cellule = table[i][j];
            let voisins = getVoisins(i,j);
            cellule.nbVoisinsVivants = getNbVoisinsVivants(voisins);               
        }
    }

    for (let i = 0; i < nbLignes; i++){
        for (let j = 0; j < nbColonnes; j++){
            cellule = table[i][j];
            if (cellule.className == "vivant"){
                if (cellule.nbVoisinsVivants < 2 || cellule.nbVoisinsVivants > 3){
                    changeEtat(i,j);
                }
            } else {
                if (cellule.nbVoisinsVivants == 3){
                    changeEtat(i,j);
                }
            }
        }
    }
}

function init(){
    nbColonnes = Number(prompt("Entrez le nombre de colonnes"));
    nbLignes = Number(prompt("Entrez le nombre de lignes"));

    plateau = document.getElementById("plateau");
    document.getElementById("bAvancer").addEventListener("click", avancer);

    table = [nbLignes];
    for(let i=0; i<nbLignes; i++){
        table[i] = [nbColonnes];
    }

    for(let i = 0; i < nbColonnes; i++){
        let ligne = document.createElement("tr");
        plateau.appendChild(ligne);
        for(let j = 0; j < nbLignes; j++){
            let colonne = document.createElement("td");
            colonne.className = "";
            colonne.onclick = clic(i,j);
            ligne.appendChild(colonne);
            table[i][j] = colonne;
        }
    }

}

window.onload = init;
