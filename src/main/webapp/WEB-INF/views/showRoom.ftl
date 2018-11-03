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
        <th>reservId</th>
    </tr>
<#list room as room>
<tr>
    <td>#{room.roomId}</td>
    <td>${room.price}</td>
    <td>${room.hotelId}</td>
    <td>${room.reservId}</td>
</tr>
</#list>
</table>
<br>
<a href="/hotels">Back</a>
</body>
</html>