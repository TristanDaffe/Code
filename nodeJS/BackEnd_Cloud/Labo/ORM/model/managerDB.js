module.exports.getManager = async (client, nom, password) => {
    return await client.query(`
        SELECT * FROM manager WHERE nom = $1 AND password = $2 LIMIT 1;
    `, [nom, password]);
}
