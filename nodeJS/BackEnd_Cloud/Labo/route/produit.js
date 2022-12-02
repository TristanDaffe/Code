const AuthoMiddleware = require("../middleware/Authorization");
const ProduitControleur = require("../controleur/produitDB");
const Router = require("express-promise-router");
const router = new Router;
const JWTMiddleWare = require("../middleware/IdentificationJWT");

router.get('/:id', ProduitControleur.getProduit);
router.post('/', JWTMiddleWare.identification, AuthoMiddleware.mustBeManager, ProduitControleur.postProduit);
router.patch('/', JWTMiddleWare.identification, AuthoMiddleware.mustBeManager, ProduitControleur.updateProduit);
router.delete('/', JWTMiddleWare.identification, AuthoMiddleware.mustBeManager, ProduitControleur.deleteProduit);

module.exports = router;