module.exports.getManager = async (client, email, password) => {
    return await client.query(`
        SELECT * FROM manager WHERE email = $1 AND password = $2 LIMIT 1;
    `, [email, password]);
}