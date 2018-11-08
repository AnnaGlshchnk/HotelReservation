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
        <th>FirstNAme</th>
        <th>Surname</th>
    </tr>
<#list reservationAndGuest as reservationAndGuest>
<tr>
    <td>${reservationAndGuest.reservId}</td>
    <td>${reservationAndGuest.startReserv}</td>
    <td>${reservationAndGuest.endReserv}</td>
    <td>${reservationAndGuest.roomId}</td>
    <td>${reservationAndGuest.firstName}</td>
    <td>${reservationAndGuest.surname}</td>

</tr>
</#list>
</table>
<br>
<a href="/hotels">Back</a>

</body>
</html>