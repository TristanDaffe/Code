const { DataTypes } = require("sequelize");
const sequelize = require("../sequelize");

const Client = sequelize.define(
	"client",
	{
		id: {
			type: DataTypes.INTEGER,
			autoIncrementIdentity: true,
			primaryKey: true,
		},
		nom: {
			type: DataTypes.STRING,
		},
		prenom: { type: DataTypes.STRING },
		adresse: {
			type: DataTypes.STRING,
		},
	},
	{
		timestamps: false,
		freezeTableName: true,
	}
);

module.exports = Client;
