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
        <th>ID</th>
        <th>Hotel</th>
        <th>RoomID</th>
    </tr>
<#list hotels as hotel>
<tr>
    <td>${hotel.hotel_id}</td>
    <td>${hotel.hotel}</td>
    <td>${hotel.room_id}</td>
</tr>
</#list>
</table>


</body>
</html>