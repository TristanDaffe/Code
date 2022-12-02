const AchatControleur = require("../controleur/achatDB");

const Router = require("express-promise-router");
const router = new Router;

router.post('/', AchatControleur.insertAchat);
router.post('/withClient', AchatControleur.insertAchatWithClient);

module.exports = router;