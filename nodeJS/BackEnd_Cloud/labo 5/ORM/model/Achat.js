const {DataTypes, Sequelize, Deferrable} = require('sequelize');
const sequelize = require('../sequelize');
const Produit = require('./Produit');
const Client = require('./Client');

const Achat = sequelize.define('achat', {
    id_produit: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        references: {
            model: Produit,
            key: 'id',
            deferrable: Deferrable.INITIALLY_IMMEDIATE
        }
    },
    id_client: {
        type: DataTypes.STRING,
        primaryKey: true,
        references: {
            model: Client,
            key: 'id',
            deferrable: Deferrable.INITIALLY_IMMEDIATE
        },
    },
    quantite: {
        type: DataTypes.INTEGER
    },
    date: {
        type: DataTypes.DATE,
        defaultValue: Sequelize.NOW
    }
}, {
    timestamps: false,
    freezeTableName: true
});

module.exports = Achat;