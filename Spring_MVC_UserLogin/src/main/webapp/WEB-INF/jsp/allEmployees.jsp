<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User's Credential</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: #000;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        table {
            border-collapse: inherit;
            background-color: black;
            color: white;
            width: 100%;
        }
        h2 {
            font-size: 24px;
            color:  #ff3d2e;
        }
        .container {
            width: 100%;
            text-align: center;
        }
        th, td {
            padding: 8px;
            text-align: center;
            border-bottom: 1px solid #444;
            cursor: pointer;
        }
        th {
            background-color: black;
            color:  #ff3d2e;
            cursor: pointer;
        }
        tr:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User's List</h2>
<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Mobile no</th>
    </tr>
    <c:forEach var="employees" items="${employee}" >
        <tr>
            <td>${employees.username}</td>
            <td>${employees.password}</td>
            <td>${employees.emailId}</td>
            <td>${employees.mobNo}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
