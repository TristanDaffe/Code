let nombreEntree ;
        
do{
    nombreEntree = Number( prompt("Entrez un nombre") ) ;
}while( !isFinite(nombreEntree));

function afficheNombre(){
    document.write("<p class=\"nombre\">"+ nombreEntree +"</p>");
}
function afficheTable(){
    /*
    document.write("<ul>");
    for (let i = 0; i <= 10; i++) {
        document.write("<li>"+ nombreEntree +" X "+ i +" = "+ nombreEntree*i +"</li>");
    }
    document.write("</ul>");
    */
    document.write("<table>");
    document.write("<tr> <th>Nombre</th> <th>Facteur</th> <th>Resultat</th> </tr>");
    for (let i = 0; i <= 10; i++) {
        document.write("<tr><td>"+ nombreEntree +"</td> <td>"+ i +"</td> <td>"+ nombreEntree*i +"</tr>");
    }
    document.write("</table>");
}