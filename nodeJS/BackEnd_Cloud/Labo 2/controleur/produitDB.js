const pool = require('../modele/database');
const ProduitModele = require("../modele/produitDB");

module.exports.getProduit = async (req, res) => {
    const client = await pool.connect();
    const idTexte = req.params.id; //attention ! Il s'agit de texte !
    const id = parseInt(idTexte);
    try{
        if(isNaN(id)){
            res.sendStatus(400);
        } 
        else {
            const {rows: produits} = await ProduitModele.getProduit(id, client);
            const produit = produits[0];
            if(produit !== undefined){
                res.json(produit);
            } 
            else {
                res.sendStatus(404);
            }
        }
    } 
    catch (error){
        console.error(error);
        res.sendStatus(500);
    } 
    finally {
        client.release();
    }
}

module.exports.postProduit = async (req, res) => {
    const body = req.body;
    const {id, nom, prix} = body;
    const client = await pool.connect();
    try{
        const {rows} = await ProduitModele.postProduit(nom, prix, client);
        res.status(201).send(rows[0].id);
    } 
    catch (error){
        console.error(error);
        res.sendStatus(500);
    } 
    finally {
        client.release();
    }
}

module.exports.updateProduit = async (req, res) => {
    const {id, prix} = req.body;
    const client = await pool.connect();
    try{
        await ProduitModele.updatePrix(id, prix, client);
        res.sendStatus(204);
    } 
    catch (error){
        console.error(error);
        res.sendStatus(500);
    } 
    finally {
        client.release();
    }
}

module.exports.deleteProduit = async (req, res) => {
    const {id} = req.body;
    const client = await pool.connect();
    try{
        await ProduitModele.deleteProduit(id, client);
        res.sendStatus(204);
    } 
    catch (error){
        console.error(error);
        res.sendStatus(500);
    } 
    finally {
        client.release();
    }
}