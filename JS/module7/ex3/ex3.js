let spanValue;
let value = 2;

window.onload = init;

function init(){
    spanValue = document.getElementById("spanVal");
    majValue();

    document.getElementById("bOppose").addEventListener("click", calcOpposite);
    document.getElementById("bCarre").addEventListener("click", calculSquare);
    document.getElementById("bFact").addEventListener("click", calcFactorielle);
    
    document.getElementById("bDecremente10").onclick = calcAjoute(-10);
    document.getElementById("bDecremente1").onclick = calcAjoute(-1);
    document.getElementById("bRAZ").addEventListener("click", reset);
    document.getElementById("bIncremente1").onclick = calcAjoute(1);
    document.getElementById("bIncremente10").onclick = calcAjoute(10);
    
    document.getElementById("bMultiplie").onclick = calcMultiplie(2);
    document.getElementById("bDeux").onclick = effetBoutonFois(2);
    document.getElementById("bCinq").onclick = effetBoutonFois(5);
    document.getElementById("bDix").onclick = effetBoutonFois(10);
}

function majValue() {
    spanValue.textContent = value;
}

function calcOpposite(){
    value = -value;
    majValue();
}
function calculSquare(){
    value *= value;
    majValue();
}
function calcFactorielle(){
    if(value > 0)
        value = factorielle(value);
    majValue();
}
function factorielle(x){
    if(x == 0){
        return 1;
    }
    return x * factorielle(x - 1);
}

function reset(){
    value = 0;
    majValue();
}
function calcAjoute(x){
    return function(){
        value += x;
        majValue();
    }
}

function calcMultiplie(x){
    return function(){
        value *= x;
        majValue();
    }
}
function effetBoutonFois(x){
    return function() {
        let butCible = document.getElementById("bMultiplie");
        butCible.onclick = calcMultiplie(x);
        butCible.textContent = "x"+ x;
    }
}

