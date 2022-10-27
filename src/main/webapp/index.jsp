<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management System</title>
</head>
<body>
<div>
    <h1 align="center">User Management System</h1>

    <form action="/login" method="post">
        <table>
            <tr>
                <td><p>Please enter username: </p></td>
                <td><input type="text" name="username" required/></td>
                <td>${usernameMessage}</td>
            </tr>
            <tr>
                <td><p>Please enter password: </p></td>
                <td><input type="password" name="password" required/></td>
                <td>${passwordMessage}</td>
            </tr>
        </table>

        <p><input type="submit" value="Save"/></p>
    </form>
</div>
</body>
</html>