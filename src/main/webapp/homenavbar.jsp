<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/home.css">
    <div class="sidebar-header">
        <h2>WanderStay</h2>
        <p>Welcome back, <b>${sessionScope.username}</b>!</p>
    </div>
    <ul class="nav-links">
        <li><a href="${pageContext.request.contextPath}/homestays"><i class="fas fa-home"></i> Homestays</a></li>
        <li><a href="${pageContext.request.contextPath}/attractions"><i class="fas fa-map-marker-alt"></i> Attractions</a></li>
        <li><a href="${pageContext.request.contextPath}/bookings"><i class="fas fa-book"></i> My Bookings</a></li>
        <li><a href="${pageContext.request.contextPath}/guides"><i class="fas fa-users"></i> Local Guides</a></li>
        <li><a href="${pageContext.request.contextPath}/settings"><i class="fas fa-cog"></i> Settings</a></li>
        <li><a href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
    </ul>
</div>
