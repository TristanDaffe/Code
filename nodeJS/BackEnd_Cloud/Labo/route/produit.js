const IdMiddleware = require("../middleware/Identification");
const AuthoMiddleware = require("../middleware/Authorization")
const ProduitControleur = require("../controleur/produitDB");
const Router = require("express-promise-router");
const router = new Router;

router.get('/:id', ProduitControleur.getProduit);
router.post('/', IdMiddleware.identificationWithAuth, AuthoMiddleware.mustBeManager, ProduitControleur.postProduit);
router.patch('/', IdMiddleware.identificationWithAuth, AuthoMiddleware.mustBeManager, ProduitControleur.updateProduit);
router.delete('/', IdMiddleware.identificationWithAuth, AuthoMiddleware.mustBeManager, ProduitControleur.deleteProduit);

module.exports = router;