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