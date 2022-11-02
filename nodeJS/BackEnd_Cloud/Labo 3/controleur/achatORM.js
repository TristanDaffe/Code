const ClientORM = require("../ORM/model/Client");
const AchatORM = require("../ORM/model/Achat");
const ProduitORM = require("../ORM/model/Produit");
const sequelize = require("../ORM/sequelize");
const { Sequelize } = require("sequelize");

module.exports.insertAchat = async (req, res) => {
	const { idProduit, quantite } = req.body;
	let { client } = req.body;
	try {
		await sequelize.transaction(
			{
				deferrable: Sequelize.Deferrable.SET_DEFERRED,
			},
			async (t) => {
				const clientDB = await ClientORM.findOne({
					where: { nom: client.nom },
				});
				if (clientDB === null) {
					client = await ClientORM.create(
						{
							nom: client.nom,
							prenom: client.prenom,
							adresse: client.adresse,
						},
						{ transaction: t }
					);
				} else {
					client = clientDB;
				}
				const produitDB = await ProduitORM.findOne({
					where: { id: idProduit },
				});
				if (produitDB === null) {
					throw new Error("ID produit non valide");
				}
				await AchatORM.create(
					{
						id_produit: idProduit,
						id_client: client.id,
						quantite,
					},
					{ transaction: t }
				);
			}
		);
		res.sendStatus(201);
	} catch (e) {
		if (e.message === "ID produit non valide") {
			res.status(404).json({ error: "L'ID du produit n'est pas valide" });
		} else {
			console.error(e);
			res.sendStatus(500);
		}
	}
};
