const ProduitORM = require('../ORM/model/Produit');

module.exports.getProduit = async (req, res) => {
    const idTexte = req.params.id; //attention ! Il s'agit de texte !
    const id = parseInt(idTexte);
    try{
        if(isNaN(id)){
            res.sendStatus(400);
        } else {
            const produit = await ProduitORM.findOne({where: {id: id}});
            if(produit !== null){
                res.json(produit);
            } else {
                res.sendStatus(404);
            }
        }
    } catch (error){
        console.error(error);
        res.sendStatus(500);
    }
}

module.exports.postProduit = async (req, res) => {
    const body = req.body;
    const {nom, prix} = body;
    try{
        await ProduitORM.create({
            nom,
            prix
        });
        res.sendStatus(201);
    } catch (error){
        console.error(error);
        res.sendStatus(500);
    }
}

module.exports.updateProduit = async (req, res) => {
    const {id, prix} = req.body;
    try{
        await ProduitORM.update({prix}, {where: {id}});
        res.sendStatus(204);
    } catch (error){
        console.error(error);
        res.sendStatus(500);
    }
}

module.exports.deleteProduit = async (req, res) => {
    const {id} = req.body;
    try{
        await ProduitORM.destroy({where: {id}});
        res.sendStatus(204);
    } catch (error){
        console.error(error);
        res.sendStatus(500);
    }
}