
function Animal (nom, cri) {
    this.nom = nom; 
    this.cri = cri;
}
Animal.prototype.crier = function () {
    alert(this.cri);
}

let chien = new Animal ("PPN", "Wouf");
let chat = new Animal ("BDN", "Miaou");