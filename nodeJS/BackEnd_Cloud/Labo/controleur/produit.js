const ProduitModele = require("../modele/produit");

module.exports.getProduit = (req, res) => {
    const idTexte = req.params.id; //attention ! Il s'agit de texte !
    const id = parseInt(idTexte);
    if(isNaN(id)){
        res.sendStatus(400);
    } else {
        try{
            const produit = ProduitModele.getProduit(id);
            res.json(produit);
        } catch (error){

                        console.error(error);
            res.sendStatus(404);
        }
    }
}

module.exports.postProduit = (req, res) => {
    const body = req.body;
    const {id, nom, prix} = body;
    const reponse = ProduitModele.postProduit(id, nom, prix);
    if(reponse){
        res.sendStatus(201);
    } else {
        res.sendStatus(500);
    }
}

module.exports.updateProduit = (req, res) => {
    const {id, prix} = req.body;
    const reponse = ProduitModele.updatePrix(id, prix);
    if(reponse){
        res.sendStatus(204);
    } else {
        res.sendStatus(404);
    }
}

module.exports.deleteProduit = (req, res) => {
    const {id} = req.body;
    const reponse = ProduitModele.deleteProduit(id);
    if(reponse){
        res.sendStatus(204);
    } else {
        res.sendStatus(500);
    }
}