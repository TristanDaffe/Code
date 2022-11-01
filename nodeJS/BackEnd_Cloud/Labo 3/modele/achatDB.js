module.exports.insertAchat = async (client, id_client, id_produit, quantite, date = new Date().toISOString()) => {
    return await client.query(`
        INSERT INTO achat(id_client, id_produit, quantite, date) VALUES
        ($1, $2, $3, $4)`, [id_client, id_produit, quantite, date]
    );
}