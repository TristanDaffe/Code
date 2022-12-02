const pool = require('../modele/database');
const ClientDB = require('../modele/clientDB');

module.exports.updateClient = async (req, res) => {
    if(req.session){
        const clientObj = req.session;
        const toUpdate = req.body;
        const newData = {};
        let doUpdate = false;

        if(
            toUpdate.adresse !== undefined ||
            toUpdate.nom !== undefined ||
            toUpdate.prenom !== undefined ||
            toUpdate.password !== undefined
        ){
            doUpdate = true;
        }

        if(doUpdate){
            newData.adresse = toUpdate.adresse;
            newData.nom = toUpdate.nom;
            newData.prenom = toUpdate.prenom;
            newData.password = toUpdate.password;

            const client = await pool.connect();
            try{
                await ClientDB.updateClient(
                    client,
                    clientObj.id,
                    newData.nom,
                    newData.prenom,
                    newData.adresse,
                    newData.password
                );
                res.sendStatus(204);
            }
            catch (e) {
                console.error(e);
                res.sendStatus(500);
            } finally {
                client.release();
            }
        } else {
            res.sendStatus(400);
        }

    } else {
        res.sendStatus(401);
    }
};

module.exports.inscriptionClient = async (req, res) => {
    const nom = req.body.nom;
    const prenom = req.body.prenom;
    const password = req.body.password;
    const adresse = req.body.adresse;
    if(nom === undefined || prenom === undefined || password === undefined || adresse === undefined){
        res.sendStatus(400);
    } else {
        const client = await pool.connect();
        try {
            await ClientDB.createClient(client, nom, prenom, password);
            res.sendStatus(201);
        } catch (e) {
            console.error(e);
            res.sendStatus(500);
        } finally {
            client.release();
        }
    }
};