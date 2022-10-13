<?php
    $x = 76;

    function inc(){
        global $x;
        $x = $x + 1;
    }
    function dec(){
        global $x;
        $x = $x - 1;
    }

    inc();
    dec();
    inc();
    var_dump($x);