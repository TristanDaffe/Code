let min;
let max;
let somme = 0;
let nbNombres = 0;

document.write("<table>");
document.write("<tr> <th>No</th> <th>Nombre</th> <th>Min</th> <th>Max</th> <th>Somme</th> </tr>");

let nombre = prompt("Entrez un nombre");
min = nombre;
max = nombre;
while(isFinite(nombre) && nombre != "" && nombre != null) {
    nbNombres++;
    if(Number(nombre) < min){
        min = nombre;
    }
    if(Number(nombre) > max){
        max = nombre;
    }
    somme += Number(nombre);

    document.write("<tr>"+ caseTableau(nbNombres) + caseTableau(nombre) + caseTableau(min) + caseTableau(max) + caseTableau(somme) +"</tr>")

    nombre = prompt("Entrez un nombre");
}

document.write("</table>");

function caseTableau(nombre){
    return '<td class='+ (nombre >= 0 ? 'positif' : 'negatif') +'>'+ nombre +'</td>';
}