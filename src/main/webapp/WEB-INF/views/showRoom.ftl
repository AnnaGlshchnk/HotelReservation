<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Room</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Price</th>
        <th>HotelId</th>
    </tr>
<#list room as room>
<tr>
    <td><a href="/room/${room.roomId}">${room.roomId}</a></td>
    <td>${room.price}</td>
    <td>${room.hotelId}</td>
</tr>
</#list>
</table>
<br>
<a href="/hotels">Back</a>
</body>
</html>