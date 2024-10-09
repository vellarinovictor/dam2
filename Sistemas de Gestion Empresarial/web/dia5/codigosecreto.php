<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tablero de Palabras</title>
</head>
<body>
    <table border="1px" cellspacing="0" cellpadding="10">
<?php
// Abrir y leer archivo
$myfile = fopen("palabras.txt", "r") or die("Unable to open file!");
$matriz = [];  // Inicializar el array

while (!feof($myfile)) {
    $linea = trim(fgets($myfile));
    if (!empty($linea)) {  // Evitar agregar líneas vacías
        $matriz[] = $linea;
    }
}
fclose($myfile);

// Inicializar el array de colores
$colores = [
    "red", "red", "red", "red", "red", "red",
    "blue", "blue", "blue", "blue", "blue", "blue", "blue",
    "green",
    "white", "white", "white", "white", "white", "white", 
    "white", "white", "white", "white", "white"
];


shuffle($matriz);
shuffle($colores);

$tablero = [];
$contador = 0;

for ($i = 0; $i < 5; $i++) {
    echo "<tr>";
    for ($j = 0; $j < 5; $j++) {
        echo "<td bgcolor='" . $colores[$contador] . "'>";
        $tablero[$i][$j] = $matriz[$contador];
        echo $tablero[$i][$j];
        $contador++;
        echo "</td>";
    }
    echo "</tr>";
}
?>
    </table>
</body>
</html>