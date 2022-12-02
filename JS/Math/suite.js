// variables qui vont contenire les rèf vers les champs de saisie
let aField, mField,cField, x0Field, output;
let validityTest;
// contient la suite aléatoire avec les valeurs pour chaque colonne
let suite;
let suiteValide = false;

window.onload = init;
function init(){
    // réupère les références vers les champs de saisie
    aField = document.getElementById("a");
    mField = document.getElementById("m");
    cField = document.getElementById("c");
    x0Field = document.getElementById("X0");

    // réupère la référence vers la zone de sortie pour le tableau
    periode = document.getElementById("periode");
    table = document.getElementById("resultTable");
    output = document.getElementById("output");

    // récupère la référence vers la zone de sortie pour les tests de validité
    validityTest = document.getElementById("validityTest");
}

// fonction pour les boutons (ne génère pas de test si la suite est invalide)
// fonction pour les boutons
function generateTest(fun){
    if(suiteValide){
        fun();
    }
}

// partie 0 : fonction de création d'un tableau avec un id
// array est un tableau d'objet avec les clés et valeur (les valeurs des clés sont utilisés pour la génération des titres)
function createTalbe(array, id){
    let output = "";

    output += '<div class="scrollTable">';
    output += `<table id="${id}" >`;
    // génère les titres des colonnes via les clés des éléments du tableau
    output += generateTopRow(array[0]);

    // ajoute dans le tableau chaque valeur pour chaque ligne
    let i = 1;
    for(let x of array){
        output += generateRow(x);
        i++;
    }

    output += "</table></div>";
    return output;
}
function generateTopRow(sequence){
    
    // génère les titres des colonnes via les clés des éléments du tableau
    let output = "<tr>";
    for(let x in sequence){
        output += "<th>" + x + "</th>";
    }
    output += "</tr>";
    return output;
}
function generateRow(row){
    // génère les valeurs de chaque ligne
    let output = "<tr>";

    for(let x in row){
        output += "<td>" + row[x] + "</td>";
    }
    output += "</tr>";
    return output;
}

// partie 1 : génération de la suite aléatoire + les valeurs pour chaque colonne
function generateSequence(){
    // réupère les valeurs saisies !! mettre Number(...) pour convertir en nombre
    let a = Number(aField.value);
    let m = Number(mField.value);
    let c = Number(cField.value);
    let x0 = Number(x0Field.value);
    
    let xn = x0;
    let i = 0;
    // reset la suite
    suite = [];
    // save le dernier xn
    let lastXn ;

// ajouter ici toute nouvelle ligne.
// sera automatiquement ajoutée dans le tableau avec comme libéllé la clé de l'objet dans le dictionnaire
    do{
        lastXn = xn;
        
        xn = (a * xn + c) % m;
        let Un = xn / m;
        let yn = Math.floor(Un * 10);
        suite.push({
            "Index" : i+1,
            "Xn" : xn,
            "Un" : Un.toFixed(3),
            "Yn" : yn,
        });
        i++;
    }while(xn !== x0 && xn !== lastXn);
    if(xn === lastXn ){
        showError();
        suiteValide = false;
    }
    else{
        output.innerHTML = '<h2> Période : ' + suite.length + '</h2>';
        output.innerHTML += createTalbe(suite, "suiteTable");
        validityTest.innerHTML = "";
        suiteValide = true;
    }
}

function showError(){
    // met un message d'erreur et enlève les ancienne sortie
    output.innerHTML = "Erreur : les valeurs saisies ne sont pas valides";
    validityTest.innerHTML = "";
}

// partie 2 : les test de validités statistiques
function testFrequence(taille = suite.length / 2){

    validityTest.innerHTML = "Test de fréquence : ";
    validityTest.innerHTML += `<p> 1 <input type="range" min="1" max="${suite.length}" value="${taille}" class="slider" oninput="updateTestFrequence()"/>${suite.length}</p>`;
    validityTest.innerHTML += `<p id='sliderValue'> Value : ${taille}</p>`;
    
    let frequence = generateFrequenceTable(taille);

    validityTest.innerHTML += createTalbe(frequence, "frequenceTable");
}
function generateFrequenceTable(taille){
        // parcour la suite pour compter le nombre de fois que chaque valeur apparait dans la colonne Yn
        let frequence = [];

        for(let i = 0; i < 10; i++){
            frequence[i] = {
                "Xi" : i,
                "Ri" : 0,
                "Pi" : 1 / 10,
            };
        }
    
        for(let i = 0; i < taille; i++){
            frequence[suite[i]["Yn"]]["Ri"]++;
        }
    
        // colonne n * pi et (n * pi - ri)² / (n * pi)
        frequence.forEach(x => {
            x["nPi"] = x["Pi"] * taille;
            x["(nPi - Ri)² / nPi"] = Math.pow(x["nPi"] - x["Ri"], 2) / x["nPi"];
        });
        return frequence;
}
function updateTestFrequence(){
    let taille = document.querySelector(".slider").value;
    document.getElementById("sliderValue").innerHTML = "Value : " + taille;
    document.getElementById("validityTest").getElementsByClassName("scrollTable")[0].innerHTML = createTalbe(generateFrequenceTable(taille), "frequenceTable");
}

function testSeries(){
    let serie = [];

    for(let i = 0; i < 10; i++){
        for(let j = 0; j < 10; j++){
            serie.push({
                "Xi,Xi+1" : `(${i},${j})`,
                "Ri" : 0,
                "Pi" : 1 / 100,
            });
        }
    }

    for(let i = 0; i < suite.length; i += 2){
        let binome = `(${suite[i]["Yn"]},${suite[i+1]["Yn"]})`;
        let index = serie.findIndex(x => x["Xi,Xi+1"] === binome);
        serie[index]["Ri"]++;
    }
    serie.forEach(x => {
        x["nPi"] = x["Pi"] * suite.length;
        x["(nPi - Ri)² / nPi"] = Math.pow(x["nPi"] - x["Ri"], 2) / x["nPi"];
    });

    serie = serie.filter(x => x["Ri"] !== 0);

    validityTest.innerHTML = "Test des séries : ";
    validityTest.innerHTML += createTalbe(serie, "serieTable");
}

function testSauts(){
    let sauts = [];

    // calcul du nombre max de ligne (pour n * pi => 5)
    let nbLignes = Math.ceil((Math.log(5 / suite.length) / Math.log(0.9))); 

    let piTot = 0;
    let i;
    for(i = 0; i < nbLignes -1 ; i++){
        sauts.push({
            "Saut" : i,
            "Ri" : 0,
            "Pi" : Math.pow(0.9, i) * 0.1,
        });
        piTot += sauts[i]["Pi"];
    }
    // dernière ligne pour les autres sauts
    sauts.push({
        "Saut" : i + " à " + suite.length,
        "Ri" : 0,
        "Pi" : 1 - piTot,
    });

    i = 0;
    while(i < suite.length){
        let jumpSize = 0;
        let number = suite[i]["Yn"];

        // indice pour check les chiffres suivants pour trouver le même chiffre
        // skip un nombre pour éviter le couplage entre les Q-uples
        let j = i + 1;
        while(j < suite.length && suite[j]["Yn"] !== number){
            jumpSize++;
            j++;
        }
        // si on a trouvé un chiffre identique
        if(j !== suite.length){
            if(jumpSize < nbLignes){
                sauts[jumpSize]["Ri"]++;
            }
            else{
                sauts[nbLignes-1]["Ri"]++;
            }
        }

        i++;
    }
    sauts.forEach(x => {
        x["nPi"] = x["Pi"] * suite.length;
        x["(nPi - Ri)² / nPi"] = Math.pow(x["nPi"] - x["Ri"], 2) / x["nPi"];
    });

    validityTest.innerHTML = "Test des Sauts : ";
    validityTest.innerHTML += createTalbe(sauts, "jumptable");
}

function testCourse(){
    let course = [];

    // prépare course pour compter la taille des courses
    for(let i = 1; i < suite.length; i++){
        course.push({
            "Course" : i,
            "Ri" : 0,
            "Pi" : 1 / (i + 1),
        });
    }

    //compte la taille de course
    let jumpSize = 1;
    for(let i = 1; i < suite.length; i++){
        if(suite[i]["Xn"] > suite[i-1]["Xn"]){
            jumpSize++;
        }
        else{
            course[jumpSize-1]["Ri"]++;
            jumpSize = 1;
            // passe un nombre pour éviter le couplage entre les courses
            i++;
        }
    }
    course.forEach(x => {
        x["nPi"] = x["Pi"] * suite.length;
        x["(nPi - Ri)² / nPi"] = Math.pow(x["nPi"] - x["Ri"], 2) / x["nPi"];
    });
    course = course.filter(x => x["Ri"] !== 0);

    validityTest.innerHTML = "Test de course : ";
    validityTest.innerHTML += createTalbe(course, "courseTable");
}
// reste test du poker et test du carré unité
