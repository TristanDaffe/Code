const pg = require("pg");
const Pool = pg.Pool;

const pool = new Pool({
    user: 'john',
    host: 'localhost',
    database: 'exercices',
    password: 'password',
    port: 5432,
});

module.exports = pool;