<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create reservation</title>
</head>
<body>

<form name="reservation" action="/addReservation" method="post">
    <p>Start</p>
    <input title="startReserv" type="text" name="startReserv">
    <p>End</p>
    <input title="endReserv" type="text" name="endReserv">
    <p>Room</p>
    <input title="roomId" type="text" name="roomId">
    <p>Guest</p>
    <input title="guestId" type="text" name="guestId">
    <input type="submit" value="Add">
</form>

</body>
</html>