<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Hotel list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>RoomId</th>
        <th>Price</th>
    </tr>
<#list hotel as hotelWithRoom>
    <tr>
        <td><a href="/hotel/${hotelWithRoom.id}">${hotelWithRoom.id}</a></td>
        <td>${hotelWithRoom.name}</td>
        <td>${hotelWithRoom.roomId}</td>
        <td>${hotelWithRoom.price}</td>
        <td><a href="/delete/${hotelWithRoom.id}">Delete</a></td>
        <td><a href="/update/${hotelWithRoom.id}">Edit</a></td>
    </tr>
</#list>
</table>
<a href="/addHotel">Add User</a>
</body>
</html>