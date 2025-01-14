const pool = require('../modele/database');
const ClientModele = require("../modele/clientDB");
const AchatModele = require("../modele/achatDB");

module.exports.insertAchat = async (req, res) => {
    const client = await pool.connect();
    const {idProduit, client:clientObj, quantite} = req.body;
    try {
        const clientExist = await ClientModele.clientExist(client, clientObj.id);
        if (clientExist) {
            await AchatModele.insertAchat(client, clientObj.id, idProduit, quantite);
            res.sendStatus(201);
        } else {
            res.status(404).send("ID client introuvable");
        }
    } catch (e) {
        console.error(e);
        res.sendStatus(500);
    } finally {
        client.release();
    }
}

module.exports.insertAchatWithClient = async (req, res) => {
    const client = await pool.connect();
    const {idProduit, client:clientObj, quantite} = req.body;
    try {
        await client.query("BEGIN");
        const {rows} = await ClientModele.createClient(client, clientObj.nom, clientObj.prenom, clientObj.addresse);
        await AchatModele.insertAchat(client, rows[0].id, idProduit, quantite);
        await client.query("COMMIT")
        res.sendStatus(201);
    } catch (e) {
        await client.query("ROLLBACK");
        console.error(e);
        res.sendStatus(500);
    } finally {
        client.release();
    }
}