const ClientControleur = require("../controleur/clientDB");
const AuthMiddleware = require("../middleware/Identification.js");

const Router = require("express-promise-router");
const router = new Router;

router.patch('/', AuthMiddleware.identification, ClientControleur.updateClient);

module.exports = router;