<<<<<<< HEAD
const pool = require('../modele/database');
const ClientDB = require('../modele/clientDB');

module.exports.updateClient = async (req, res) => {
    if(req.session){
        const clientObj = req.session;
        const toUpdate = req.body;
        const newData = {};

        newData.adresse = toUpdate.adresse ? toUpdate.adresse : clientObj.adresse;
        newData.nom = toUpdate.nom ? toUpdate.nom : clientObj.nom;
        newData.prenom = toUpdate.prenom ? toUpdate.prenom : clientObj.prenom;
        newData.password = toUpdate.password ? toUpdate.password : clientObj.password;

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
        res.sendStatus(401);
    }
}
=======
const pool = require("../modele/database");
const ClientDB = require("../modele/clientDB");

module.exports.updateClient = async (req, res) => {
	if (req.session !== undefined) {
		const clientObj = req.session;
		const toUpdate = req.body;
		const newData = {};
		newData.adresse = toUpdate.adresse ? toUpdate.adresse : clientObj.adresse;
		newData.nom = toUpdate.nom ? toUpdate.nom : clientObj.nom;
		newData.prenom = toUpdate.prenom ? toUpdate.prenom : clientObj.prenom;
		newData.password = toUpdate.password ? toUpdate.password : clientObj.password;
		const client = await pool.connect();
		try {
			await ClientDB.updateClient(
				client,
				clientObj.id,
				newData.nom,
				newData.prenom,
				newData.adresse,
				newData.password
			);
			res.sendStatus(204);
		} catch (e) {
			console.error(e);
			res.sendStatus(500);
		} finally {
			client.release();
		}
	} else {
		res.sendStatus(401);
	}
};
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3
