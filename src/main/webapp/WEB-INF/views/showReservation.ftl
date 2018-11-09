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
        <th>FirstName</th>
        <th>Surname</th>
    </tr>
<#list reservation as reservation>
<tr>
    <td>${reservation.reservId}</td>
    <td>${reservation.startReserv}</td>
    <td>${reservation.endReserv}</td>
    <td>${reservation.roomId}</td>
    <td>${reservation.guest.guestId}</td>
    <td>${reservation.guest.firstName}</td>
    <td>${reservation.guest.surname}</td>
    <td><a href="/delete/${reservation.reservId}">Delete</a> </td>
    <td><a href="/updateReservation/${reservation.reservId}">Update</a> </td>
</tr>
</#list>
</table>

<a href="/addReservation"> Add Reservation</a>
<br>
<a href="/hotels">Back</a>

</body>
</html>