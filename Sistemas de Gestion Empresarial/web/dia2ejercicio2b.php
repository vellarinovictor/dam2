<?php
$variablecars = $_GET["cars"];
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border=5>
    <tr>
        <th>Key</th>
        <th>Value</th>
    </tr>
    <?php
        foreach ($variablecars as $key => $value) {
            // if ($contador % 2 == 0)  {
            //     echo "<tr bgcolor = 'yellow'>";
            // }else echo "<tr bgcolor = 'magenta'>";
            switch ($contador % 4) {
                case 0:
                    echo "<tr bgcolor = 'yellow'>";
                    break;
                case 1:
                    echo "<tr bgcolor = 'red'>";
                    break;
                case 2:
                    echo "<tr bgcolor = 'green'>";
                    break;
                case 3:
                    echo "<tr bgcolor = 'blue'>";
                    break;
            }
            echo "<td>";
            echo $key;
            echo "</td>";
            echo "<td>";
            echo $value;
            echo "</td>";
            echo "</tr>";
            $contador++;
        }
    ?>
    </table>
</body>
</html>

