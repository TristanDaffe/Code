const {getHash} = require("../utils/utils");

module.exports.createClient = async (client, nom, prenom, adresse, password) => {
    return await client.query(`
        INSERT INTO client(nom, prenom, adresse, password) 
        VALUES ($1, $2, $3, $4)`, [nom, prenom, adresse, await getHash(password)]
    );
};

module.exports.updateClient = async (client, id, nom, prenom, adresse, password) => {
    /*
     return await client.query(`
        UPDATE client SET nom = $1, prenom = $2, adresse = $3, password = $4
        WHERE id = $5
   `, [nom, prenom, adresse, password, id]);
     */
    const params = [];
    const querySet = [];
    let query = "UPDATE client SET ";
    if(nom !== undefined){
        params.push(nom);
        querySet.push(` nom = $${params.length} `);
    }
    if(prenom !== undefined){
        params.push(prenom);
        querySet.push(` prenom = $${params.length} `);
    }
    if(adresse !== undefined){
        params.push(adresse);
        querySet.push(` adresse = $${params.length} `);
    }
    if(password !== undefined){
        params.push(await getHash(password));
        querySet.push(` password = $${params.length} `);
    }

    if(params.length > 0){
        query += querySet.join(',');
        params.push(id);
        query += ` WHERE id = $${params.length}`;

        return client.query(query, params);
    } else {
        throw new Error("No field to update");
    }


};

module.exports.getClient = async (client, email) => {
    return await client.query(`
        SELECT * FROM client WHERE email = $1;
    `, [email]);
};

module.exports.clientExist = async (client, idClient) => {
    const {rows} = await client.query(
        "SELECT count(id) AS nbr FROM client WHERE id = $1",
        [idClient]
    );
    return rows[0].nbr > 0;
};