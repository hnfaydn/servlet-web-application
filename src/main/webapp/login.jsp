<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>You Had Logged In</title>
</head>
<body>
<div>
    <h1 align="center">Atmosware Admin System</h1>
    <table style="with: 50%">
        <tr>
            <td>
                <% String username = request.getParameter("username"); %>
                <a>Welcome   <%=username%> User!!!! You have logged in.</a></td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td></td>
            <td><a href="index.jsp"><b>Logout</b></a></td>
        </tr>
    </table>
</div>
</body>
</html>