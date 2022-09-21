const ProduitModele = require('./produit');
const express = require('express');
const app = express();
const port = 3001;

app.get('/', (req, res) => {
    res.send('Bonjour le monde!');
});

app.get ('/produit/:id', (req, res) => {
    const idTexte = req.params.id;
    const id = parseInt(idTexte);
    if(isNaN(id)){
        res.sendStatus(400);
    }
    else{
        try{
            const produit = ProduitModele.getProduit(id);
            res.json(produit);
        }
        catch (error){
            console.error(error);
            res.sendStatus(404);
        }
    }
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`);
});
