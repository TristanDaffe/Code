module.exports.createClient = async (client, nom, prenom, adresse) => {
    return await client.query(`
        INSERT INTO client(nom, prenom, adresse) 
        VALUES ($1, $2, $3)`, [nom, prenom, adresse]
    );
}

module.exports.updateClient = async (client, id, nom, prenom, adresse, password) => {
   return await client.query(`
        UPDATE client SET nom = $1, prenom = $2, adresse = $3, password = $4 
        WHERE id = $5
   `, [nom, prenom, adresse, password, id]);
}

module.exports.getClient = async (client, email, password) => {
    return await client.query(`
        SELECT * FROM client WHERE email = $1 AND password = $2 LIMIT 1;
    `, [email, password]);
}

module.exports.clientExist = async (client, idClient) => {
    const {rows} = await client.query(
        "SELECT count(id) AS nbr FROM client WHERE id = $1",
        [idClient]
    );
    return rows[0].nbr > 0;
}