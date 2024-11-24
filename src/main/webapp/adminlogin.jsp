<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Client Login</title>
    <link rel="stylesheet" href="CSS/admin.css">
</head>
<body>
    <div class="login-container">
        <h2>Admin Login</h2>
        <form action="/adminlogin" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn">Login</button>
            <p class="error">${error}</p>
        </form>
    </div>
</body>
</html>
    