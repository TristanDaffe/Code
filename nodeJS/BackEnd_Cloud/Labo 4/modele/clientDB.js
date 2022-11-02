module.exports.createClient = async (client, nom, prenom, adresse) => {
    return await client.query(`
        INSERT INTO client(nom, prenom, adresse) 
        VALUES ($1, $2, $3) RETURNING id`, [nom, prenom, adresse]
    );
}

module.exports.clientExist = async (client, idClient) => {
    const {rows} = await client.query(
        "SELECT count(id) AS nbr FROM client WHERE id = $1",
        [idClient]
    );
    return rows[0].nbr > 0;
}

module.exports.getClient = async (client, nom, password) => {
    return await client.query(`
    SELECT * FROM client WHERE nom = $1 AND password = $2 LIMIT 1;
    `, [nom, password]);
}