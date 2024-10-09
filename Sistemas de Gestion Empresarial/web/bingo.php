<?php
for ($i=1; $i < 100; $i++) { 
    $bingoInicial[$i] = $i;
}
bingo[]; // Array vacío
for ($i=1; $i < 100; $i++) { 
    $indice = random_int(0, sizeof($bingoInicial) - 1);
    $j = rand(0, sizeof($bingoInicial) - 1);
    $temp = $array[$i];
    $bingo[$i] = $bingo[$j];
    $bingo[$j] = $temp;
}
?>