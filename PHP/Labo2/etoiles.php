<?php
    // $x = 5;
    // $token = "*!";
    // $msg = "";
    
    // for($i = 0; $i < $x; $i++){
    //     echo $token;
    // }
        
    // for($i = 0; $i < $x; $i++){
    //     $msg .= $token;
    // }
    // echo $msg
    
    // for($i = 0; $i < $x; $i++) :
    //     $msg .= $token;
    // endfor;
    // echo $msg

    $x = 7259;
    $s = $x ."";

    for($i = 0; $i < strlen($s); $i++) :
        $msg = "";
        for($j = 0; $j < $s[-$i-1]; $j++) :
            $msg .= "*";
        endfor;
        echo $msg . "\n";
    endfor;
