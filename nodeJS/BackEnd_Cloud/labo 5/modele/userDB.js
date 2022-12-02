const {getClient} = require('./clientDB');
const {getManager} = require('./managerDB');
const {compareHash} = require('../utils/utils');

module.exports.getUser = async (client, email, password) => {
    const promises = [];
    const promiseClient = getClient(client, email);
    const promiseManager = getManager(client, email);
    promises.push(promiseClient, promiseManager);
    const values = await Promise.all(promises);
    const clientRow = values[0].rows[0];
    const managerRow = values[1].rows[0];
    if(clientRow !== undefined && await compareHash(password, clientRow.password)){
        return {userType: "client", value: clientRow};
    } else if (managerRow !== undefined && await compareHash(password, managerRow.password)){
        return {userType: "manager", value: managerRow};
    } else {
        return {userType: "inconnu", value: null}
    }
};
