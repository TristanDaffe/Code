//permet de simuler une base de données
const produits = [
    {id: 1, nom:"Playstation 4", prix: 400},
    {id: 2, nom:"Xbox One", prix: 399.99},
    {id: 3, nom:"Nintendo Switch", prix: 349.99}
];

module.exports.getProduit = (id) => {
    const resultats = produits.filter(p => p.id === id);
    if(resultats.length > 0) {
        return resultats[0];
    }
    else{
        throw new Error("Aucun produit trouvé");
    }
}
