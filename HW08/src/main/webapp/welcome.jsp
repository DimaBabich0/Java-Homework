<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Data</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="form-container">
        <h2>Welcome, <%= session.getAttribute("name") %>!</h2>
        <p><strong>Email:</strong> <%= session.getAttribute("email") %></p>
        <p><strong>Password:</strong> <%= session.getAttribute("password") %></p>
    </div>
</body>
</html>
