<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create reservation</title>
</head>
<body>

<form name="reservation" action="/updateReservation" method="post">
    <p>ID</p>
    <input title="ReservId" type="text" name="reservId" value="${reservation.reservId}">
    <p>Start</p>
    <input title="startReserv" type="text" name="startReserv" value="${reservation.startReserv}">
    <p>End</p>
    <input title="endReserv" type="text" name="endReserv" value="${reservation.endReserv}">
    <p>Room</p>
    <input title="roomId" type="text" name="roomId" value="${reservation.roomId}">
    <p>Guest</p>
    <input title="guestId" type="text" name="guestId" value="${reservation.guestId}>
    <input type="submit" value="Add">
</form>

</body>
</html>