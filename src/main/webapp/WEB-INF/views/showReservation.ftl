<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reservation</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>StartReservation</th>
        <th>EndReservation</th>
        <th>RoomId</th>
        <th>GuestId</th>
    </tr>
<#list reservation as reservation>
<tr>
    <td>${reservation.reservId}</td>
    <td>${reservation.startReserv}</td>
    <td>${reservation.endReserv}</td>
    <td>${reservation.roomId}</td>
    <td>${reservation.guestId}</td>


</tr>
</#list>
</table>
<br>
<a href="/hotels">Back</a>

</body>
</html>