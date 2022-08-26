let grandActuel = 0;
let maxWidht = 500;
let minWidth = 20;
let cadre;

window.onload = function(){
    cadre = document.getElementById("cadre");
}

function clic(numBloc){
    if(numBloc != grandActuel){
        modif(numBloc, grandActuel, maxWidht, minWidth);
        grandActuel = numBloc;
    }
}


function modWidth(x, width){
    cadre.children[x].style.width = width+"px";
}

function modif(growBloc, shrinkBloc, widthGrow, widthShrink){
    modWidth(growBloc, widthShrink-10);
    modWidth(shrinkBloc, widthGrow+10);
    if(widthGrow >= minWidth)
        setTimeout(modif, 10, growBloc, shrinkBloc, widthGrow-10, widthShrink+10);
}