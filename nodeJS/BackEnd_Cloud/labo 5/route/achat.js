const AchatControleur = require("../controleur/achatDB");
const JWTMiddleWare = require("../middleware/IdentificationJWT");


const Router = require("express-promise-router");
const router = new Router;

router.post('/', JWTMiddleWare.identification, AchatControleur.insertAchat);

module.exports = router;