<?php
    require_once("demo.php");

    function pourcents($val1, $val2){
        return round($val1 / $val2 * 100, 2);
    }

    function repete($nb, $txt = "$"){
        $res = "";
        for($i = 0; $i < $nb; $i++){
            $res .= $txt;
        }
        return $res;
    }

    function textInColor($txt, $color){
        return "<span style='color: $color'>$txt</span>";
    }

    function barre($val1,$val2,$coul1,$coul2,$taille = 20){
        $nb1 = pourcents($val1, $val1 + $val2) * $taille / 100;
        $nb2 = $taille - $nb1;

        return textInColor(repete($nb1), $coul1) . textInColor(repete($nb2), $coul2);
    }


    function ligne($ctg,$val1,$val2) {
        global $coulH, $coulF;

        $pourc1 = pourcents($val1, $val1+ $val2);
        $pourc2 = pourcents($val2, $val1+ $val2);
        $graph = barre($val1, $val2, $coulH, $coulF);
        echo "<tr><td>$ctg</td>
            <td>$val1 ( $pourc1 ) %</td>
            <td>$val2 ( $pourc2 ) %</td>
            <td>$graph</td>
            </tr>";
    }
?>