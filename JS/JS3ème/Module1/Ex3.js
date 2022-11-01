
let nombre;
do{

    nombre = Number(prompt("Entrez un nombre"));
}while(!isFinite(nombre));

function showNumber(){
    document.write("<p class='nombre'>"+ nombre +"</p>");
}
function showTAble(){
    document.write("<table>");
    document.write("<tr><th>Nombre</th><th>Facteur</th><th>Résultat</th></tr>");
    for(let i = 1; i <= 10; i++){
        document.write("<tr><td>"+ nombre +"</td><td>"+ i +"</td><td>"+ nombre*i +"</td></tr>");
    }

    document.write("</table>");
}