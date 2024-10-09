<?php
function factorial($n) {
    if ($n <= 1) {
        return 1;
    } else {
        return $n * factorial($n - 1);
    }
}

function suma($sum1, $sum2) {
    return $sum1 + $sum2;
}
?>