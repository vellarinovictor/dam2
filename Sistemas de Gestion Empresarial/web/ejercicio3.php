<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="dia2ejercicio2b.php" method="get">
        <label for = "cars">Choose a car:</label>
        <select name="cars[]" id="cars" multiple>
            <option value = "volvo">Volvo</option>
            <option value="renault">Renault</option>
            <option value="seat">Seat</option>
            <option value="mercedes">Mercedes</option>
            <option value="landrover">Land Rover</option>
        </select>
        <input type="submit" $value = "Enviar">
    </form>
</body>
</html>