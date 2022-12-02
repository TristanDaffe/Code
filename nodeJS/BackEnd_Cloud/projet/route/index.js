const ProduitRouter = require('./produit');
const AchatRouter = require('./achat');
const router = require("express").Router();

router.use("/produit", ProduitRouter);
router.use("/achat", AchatRouter);

module.exports = router;

