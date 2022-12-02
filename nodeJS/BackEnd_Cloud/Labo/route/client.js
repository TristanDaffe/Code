const ClientControleur = require("../controleur/clientDB");
const JWTMiddleWare = require("../middleware/IdentificationJWT");

const Router = require("express-promise-router");
const router = new Router;

router.post('/', ClientControleur.inscriptionClient);
router.patch('/', JWTMiddleWare.identification, ClientControleur.updateClient);

module.exports = router;