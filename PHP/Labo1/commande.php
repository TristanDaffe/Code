<html>

<head> </head>

<body>
    <p>Votre commande :
        <?php 
            if (isset($_GET) && isset($_GET['article'])) 
                echo $_GET['article']; 
            else 
                echo 'aucun article commandé'; 
        ?>
        !!!
    </p>
</body>

</html>