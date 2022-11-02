const ProduitRouter = require('./Produit');
const AchatRouter = require('./Achat');
const router = require("express").Router();

router.use("/produit", ProduitRouter);
router.use("/achat", AchatRouter);

module.exports = router;

