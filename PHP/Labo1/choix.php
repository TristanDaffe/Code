<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    
    <script>
        function commandeBut(article){
            location.href = "commande.php?article="+ article;
        }

        window.onload = () => {
            const numMax = <?php
                    $ordreCroissant = isset($_GET['ordre']) && $_GET['ordre'] == 'croissant';
                    $nbPoints = 15;
                    echo $nbPoints;
                    ?>;

            let article = document.getElementById("article");

            for(<?php
                if($ordreCroissant)
                    echo "let i = 1; i <= numMax; i++";
                else
                    echo "let i = numMax; i >= 1; i--";
            ?>){
                article.innerHTML += `<button onclick="commandeBut(${i})">${i}</button>`;
            }
        }
    </script>
</head>
<body>
    <p id="article">Article : </p>
    
</body>
</html>