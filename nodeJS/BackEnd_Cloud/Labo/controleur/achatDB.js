const pool = require('../modele/database');
const ClientModele = require("../modele/clientDB");
const AchatModele = require("../modele/achatDB");

module.exports.insertAchat = async (req, res) => {
    const client = await pool.connect();
    const {idProduit, client:clientObj, quantite} = req.body;
    try {
        await client.query("BEGIN;");
        const clientExist = await ClientModele.clientExist(client, clientObj.id);
        if (clientExist) {
            await AchatModele.insertAchat(
                client,
                clientObj.id,
                idProduit,
                quantite
            );
            await client.query("COMMIT");
            res.sendStatus(201);
        } else {
            await client.query("ROLLBACK");
            res.status(404).json({error: "l'id du client n'existe pas"});
        }
    } catch (e) {
        await client.query("ROLLBACK;");
        console.error(e);
        res.sendStatus(500);
    } finally {
        client.release();
    }
}