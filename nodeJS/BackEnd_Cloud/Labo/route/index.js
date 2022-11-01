const ProduitRouter = require('./produit');
const AchatRouter = require('./achat');
const ClientRouter = require('./client');
const router = require("express").Router();

router.use("/produit", ProduitRouter);
router.use("/achat", AchatRouter);
router.use("/client", ClientRouter);

module.exports = router;

