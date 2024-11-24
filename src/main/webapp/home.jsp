<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Screen</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div class="container">
        <!-- Include Navbar -->
        <jsp:include page="homenavbar.jsp" />

        <!-- Main Content -->
        <div class="main-content">
            <h1>Homestays</h1>
            <div class="cards-container">
                <!-- Example cards -->
                <c:forEach var="homestay" items="${homestayList}">
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/images/${homestay.image}" alt="${homestay.name}">
                        <h3>${homestay.name}</h3>
                        <p>${homestay.location}</p>
                        <p>$${homestay.price}/night</p>
                        <p>${homestay.guests} guests</p>
                        <p>${homestay.rating}/5</p>
                        <form action="${pageContext.request.contextPath}/bookHomestay" method="post">
                            <input type="hidden" name="homestayId" value="${homestay.id}">
                            <button class="btn" type="submit">Book Now</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
