module.exports.getManager = async (client, email) => {
    return await client.query(`
        SELECT * FROM manager WHERE email = $1;
    `, [email]);
}