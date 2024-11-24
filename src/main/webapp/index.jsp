<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="navbar.jsp" %>
<link rel="stylesheet" type="text/css" href="/styles.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="background-video">
    <video autoplay loop muted>
        <source src="IMAGES/index.mp4" type="video/mp4">
    </video>
</div>

<div class="search-section">
    <h2>Our Packages</h2>
    <h1>Search your Holiday</h1>
    <form class="search-form">
        <input type="text" placeholder="Search your destination" name="destination">
        <input type="date" placeholder="Select your date" name="date">
        <input type="range" min="0" max="5000" name="price" value="2500">
        <button type="submit">More Filters</button>
    </form>
</div>
</body>
</html>