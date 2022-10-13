const ProduitRouter = require('./produit');
const router = require("express").Router();

router.use("/produit", ProduitRouter);

module.exports = router;