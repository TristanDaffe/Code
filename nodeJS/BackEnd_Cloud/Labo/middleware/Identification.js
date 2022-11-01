<<<<<<< HEAD
const ClientDB = require('../modele/clientDB');
const ManagerDB = require('../modele/managerDB');
const pool = require('../modele/database');

module.exports.identification = async (req, res, next) => {
    const headerAuth = req.get('authorization');
    if(headerAuth && headerAuth.includes("Basic")){
        const base64Login =  headerAuth.split(' ')[1];
        const login = Buffer.from(base64Login, 'base64').toString('utf-8');
        const [nom, password] = login.split(':');
        const client = await pool.connect();
        try{
            const {rows} = await ClientDB.getClient(client, nom, password);
            const utilisateur = rows[0];
            if(utilisateur){
                req.session = utilisateur;
                next();
            } else {
                res.sendStatus(401);
            }
        } catch (e) {
            console.error(e);
            res.sendStatus(500);
        } finally {
            client.release();
        }
    } else {
        res.sendStatus(401);
    }
}

module.exports.identificationWithAuth = async (req, res, next) => {
    const headerAuth = req.get('authorization');
    if(headerAuth && headerAuth.includes("Basic")){
        const base64Login =  headerAuth.split(' ')[1];
        const login = Buffer.from(base64Login, 'base64').toString('utf-8');
        const [nom, password] = login.split(':');
        const client = await pool.connect();
        try{
            const {rows: rowsManager} = await ManagerDB.getManager(client, nom, password);
            const {rows: rowsClient} = await ClientDB.getClient(client, nom, password);
            const manager = rowsManager[0];
            const utilisateur = rowsClient[0];
            if(manager){
                req.session = manager;
                req.session.authLevel = "manager";
                next();
            }
            else if(utilisateur){
                req.session = utilisateur;
                req.session.authLevel = "utilisateur";
                next();
            } else {
                res.sendStatus(401);
            }
        } catch (e) {
            console.error(e);
            res.sendStatus(500);
        } finally {
            client.release();
        }
    } else {
        res.sendStatus(401);
    }
}
=======
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
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3
