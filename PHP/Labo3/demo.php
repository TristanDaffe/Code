<html>
<head>

    <style>
        #pop {
            font-family: "comic sans ms";
            border: 2px solid gray;
            border-collapse: collapse;
        }
        #pop tr:last-child {
            background-color: beige;
            border-top: 1px solid gray;
        }
        #pop th {
            border-bottom: 2px solid gray;
        }
        #pop th, #pop td {
            padding: 4px;
        }
        #pop tr td:nth-child(2) {
            color: blue;
        }
        #pop tr td:nth-child(3) {
            color: red;
        }
    </style>    

    <?php
    $coulH = "blue";
    $coulF = "red";

    function pourcents($val1, $val2){
        return round($val1 / $val2 * 100, 2) ."%";
    }

    function repete($nb, $txt = "$"){
        $res = "";
        for($i = 0; $i < $nb; $i++){
            $res += $txt;
        }
        return $res;
    }

    function barre($val1,$val2,$coul1,$coul2,$taille = 20){
        $nb1 = pourcent($val1,$val2) * $taille / 100;
        $nb2 = $taille - $nb1;

    }

    function ligne($ctg,$val1,$val2) {
        $pourc1 = pourcents($val1, $val1+ $val2);
        $pourc2 = pourcents($val2, $val1+ $val2);
        echo "<tr><td>$ctg</td>
            <td>$val1 ( $pourc1 ) </td>
            <td>$val2 ( $pourc2 ) </td>
            <td>.</td></tr>";
    }
    
    require_once("code.php");
    ?>
</head>
<body>
    <table id="pop">
        <tr>
            <th>Catégorie</th><th>Femmes</th><th>Hommes</th><th>Graphique</th>
        </tr>
        <?php
            ligne("Moins de 18 ans", 1112811, 1164347);
            ligne("De 18 à 64 ans", 3438304, 3462994);
            ligne("Plus de 64 ans", 1152835, 877753);
            ligne("Total", 5703950, 5505094);
        ?>
    </table>
</body>
</html>