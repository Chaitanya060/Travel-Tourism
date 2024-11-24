<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="CSS/admin.css">
</head>
<body>
    <div class="dashboard-container">
        <header>
            <h1>Welcome, ${admin.adminname}!</h1>
            <nav>
                <ul>
                    <li><a href="/addproduct">Add Product</a></li>
                    <li><a href="/viewproducts">View Products</a></li>
                    <li><a href="/viewclients">View Clients</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </nav>
        </header>

        <main>
            <h2>Dashboard Overview</h2>
            <p>Manage products, clients, and other admin tasks from here.</p>

            <section class="quick-actions">
                <div class="action">
                    <h3>Products</h3>
                    <p>View, add, update, or delete products.</p>
                    <a href="/viewproducts" class="btn">Manage Products</a>
                </div>
                <div class="action">
                    <h3>Clients</h3>
                    <p>View and manage client details.</p>
                    <a href="/viewclients" class="btn">Manage Clients</a>
                </div>
            </section>
        </main>
    </div>
</body>
</html>
