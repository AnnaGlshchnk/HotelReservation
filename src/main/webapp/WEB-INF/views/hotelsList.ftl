<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Hotels List</h1<>
<table>
    <tr>
        <th>Id</th>
        <th>Hotel</th>
        <th>RoomId</th>
    </tr>
<#list hotels as hotel>
<tr>
    <td><a href="/hotel/${hotel.hotelId}">${hotel.hotelId}</a></td>
    <td>${hotel.hotel}</td>
    <td>${hotel.roomId}</td>
</tr>
</#list>
</table>


</body>
</html>