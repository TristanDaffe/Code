const {DataTypes} = require('sequelize');
const sequelize = require('../sequelize');

const Produit = sequelize.define('produit', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrementIdentity: true,
        primaryKey: true,
    },
    nom: {
        type: DataTypes.STRING
    },
    prix:{
        type: DataTypes.FLOAT
    }
}, {
    timestamps: false,
    freezeTableName: true
});

module.exports = Produit;