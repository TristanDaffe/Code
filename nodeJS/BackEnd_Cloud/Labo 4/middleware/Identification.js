const ClientDB = require('../modele/clientDB');
const pool = require('../modele/database');

module.exports.identification = async (req, res, next) => {    
    const headerAuth = req.get('authorization');
    if(headerAuth && headerAuth.includes('basic')) {

    }
    // try{
    //     const headerClear = Buffer.from(headerBase64, 'base64').toString('utf-8');
    //     if(headerClear !== undefined){
    //         const client = await pool.connect();
    //         const [nom, password] = headerClear.split(':');
            
    //         const clientDB = await ClientDB.getClient(client , nom, password);
    //         if(clientDB.rowCount > 0){
    //             //client connecté
    //         }
    //     }
    // }      
    // catch{
    //     res.sendStatus();
    // }
}