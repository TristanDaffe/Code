module.exports.getProduit = async (id, client) => {
    return await client.query("SELECT * FROM produit WHERE id = $1", [id]);
};

module.exports.postProduit = async (nom, prix, client) => {
    return await client.query("INSERT INTO produit (nom, prix) VALUES ($1, $2) RETURNING id", [nom, prix]);
};

module.exports.updatePrix = async (id, prix, client) => {
    return await client.query("UPDATE produit SET prix = $1 WHERE id = $2", [id, prix]);
};

module.exports.deleteProduit = async (id, client) => {
    return await client.query("DELETE FROM produit WHERE id = $1", [id]);
};