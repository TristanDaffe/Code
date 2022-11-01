//permets de simuler une base de données
const produits = [
    {id: 1, nom: "Playstation 4", prix:400},
    {id: 2, nom: "Xbox One", prix:399.9},
    {id: 3, nom: "Nintendo Switch", prix:349.99}
]

module.exports.getProduit = (id) => {
    const resultats = produits.filter(p => p.id === id);
    if(resultats.length > 0){
        return resultats[0];
    } else {
        throw new Error("Aucun produit trouvé");
    }
}

module.exports.postProduit = (id, nom, prix) => {
    produits.push({
        id,
        nom,
        prix
    });
    return true;
}

module.exports.updatePrix = (id, prix) => {
    for(let i = 0; i < produits.length; i++){
        if(produits[i].id === id){
            produits[i].prix = prix;
            return true;
        }
    }
    return false;
}

module.exports.deleteProduit = (id) => {
    for (let i = 0; i < produits.length; i++){
        if(produits[i].id === id){
            produits.splice(i, 1);
            return true;
        }
    }
    return true;
}