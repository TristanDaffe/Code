<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <?php
        $nom = "Hommer";
        $domaine = "l'énergie nucléaire";
        $etude = false;
        $salaire = 3000;

        echo "Je m'appelle $nom.\n";

        // if($etude){
        //     echo "J'étudie ";
        // }
        // else{
        //     echo "J'ai étudié ";
        // }
        echo $etude ? "J'étudie " : "J'ai étudié ";  
        echo "$domaine.\n";
        
        echo "Je voudrais gagner \$$salaire par mois c'est à dire ";
        echo "\$" . $salaire * 12 . " par an.\n";
    ?>
</body>
</html>