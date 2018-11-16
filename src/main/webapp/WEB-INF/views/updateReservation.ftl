<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create reservation</title>
</head>
<body>

<form name="reservation" action="/updateReservation" method="post">

    <p>Id</p>
    <input title="reservId" type="text" name="reservId" value="${reservId}">
    <p>Start</p>
    <input title="startReserv" type="date" name="startReserv">
    <p>End</p>
    <input title="endReserv" type="date" name="endReserv">
    <p>Room</p>
    <input title="roomId" type="text" name="roomId">
    <p>Guest</p>
    <input title="guestId" type="text" name="guestId" >

    <input type="submit" value="Edit">
</form>

</body>
</html>