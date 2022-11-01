const { Sequelize } = require('sequelize');
const sequelize = new Sequelize('exercices', 'john', 'password', {
    host: 'localhost',
    port: '3000',
    dialect: 'postgres',
    omitNull: true
});

module.exports = sequelize;