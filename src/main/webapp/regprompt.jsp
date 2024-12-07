<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            height: 100vh;
            background-color: #f4f4f4;
        }

        .split-container {
            display: flex;
            flex-direction: row;
            width: 100%;
            height: 100vh;
        }

        .left-section {
            flex: 1;
            background-image: url('${pageContext.request.contextPath}/IMAGES/signup.jpg'); /* Replace with your image path */
            background-size: cover;
            background-position: center;
        }

        .right-section {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: white;
            padding: 2rem;
            box-shadow: -2px 0 5px rgba(0, 0, 0, 0.1);
        }

        .card {
            text-align: center;
            max-width: 400px;
            padding: 2rem;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
        }

        .card span {
            font-size: 20px;
            color: #333;
            margin-bottom: 1.5rem;
            display: block;
        }

        .my-button {
            margin-top: 1rem;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .my-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="split-container">
        <!-- Left section with the image -->
        <div class="left-section"></div>

        <!-- Right section with the "Create Account" content -->
        <div class="right-section">
            <div class="card">
                <span>Create Your Account and Make Your First Order Right Now</span>
                <a href="${pageContext.request.contextPath}/userreg">
                    <button class="my-button">Create Account!</button>
                </a>
            </div>
        </div>
    </div>
</body>
</html>
