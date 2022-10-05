const ProduitControleur = require("../controleur/produit");
const router = require("express").Router();

router.get('/:id', ProduitControleur.getProduit);
router.post('/', ProduitControleur.postProduit);
router.patch('/', ProduitControleur.updateProduit);
router.delete('/', ProduitControleur.deleteProduit);

module.exports = router;