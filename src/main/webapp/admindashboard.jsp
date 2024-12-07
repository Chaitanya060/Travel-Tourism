<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }

        .dashboard-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        header {
            background-color: #343a40;
            color: white;
            padding: 15px 20px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        header h1 {
            margin: 0;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 10px 0 0;
            display: flex;
            gap: 15px;
        }

        nav ul li {
            display: inline;
        }

        nav ul li a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            padding: 5px 10px;
            border: 2px solid transparent;
            border-radius: 5px;
        }

        nav ul li a:hover {
            border: 2px solid white;
        }

        main {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        main h2 {
            margin-top: 0;
        }

        .quick-actions {
            display: flex;
            gap: 20px;
            margin-top: 20px;
        }

        .action {
            background-color: #f8f9fa;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            text-align: center;
            flex: 1;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .action h3 {
            margin-top: 0;
        }

        .action p {
            margin: 10px 0;
        }

        .btn {
            display: inline-block;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <header>
            <h1>Welcome, ${admin.adminname}!</h1>
            <nav>
                <ul>
                    <li><a href="/adddestination">Destinations</a></li>
                    <li><a href="/addhotel">Hotels</a></li>
                    <li><a href="/adminlogin">Logout</a></li>
                </ul>
            </nav>
        </header>

        <main>
            <h2>Dashboard Overview</h2>
            <p>Manage destinations, hotels, and other admin tasks from here.</p>

            <section class="quick-actions">
                <div class="action">
                    <h3>Destinations</h3>
                    <p>View, add, update, or delete destinations.</p>
                    <a href="/viewalldestination" class="btn">Manage Destinations</a>
                </div>
                <div class="action">
                    <h3>Hotels</h3>
                    <p>View, add, update, or delete hotel details.</p>
                    <a href="/viewallhotel" class="btn">Manage Hotels</a>
                </div>
            </section>
        </main>
    </div>
</body>
</html>
