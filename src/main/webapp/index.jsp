<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="navbar.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">

<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<div class="background-video">
    <video autoplay loop muted>
        <source src="IMAGES/index.mp4" type="video/mp4">
    </video>
</div>

<!-- Image Slideshow -->
<div class="slideshow-container">
    <div class="mySlides fade">
        <img src="IMAGES/login.png" style="width:100%">
    </div>
    <div class="mySlides fade">
        <img src="IMAGES/slide2.jpg" style="width:100%">
    </div>
    <div class="mySlides fade">
        <img src="IMAGES/slide3.jpg" style="width:100%">
    </div>
    <div class="mySlides fade">
        <img src="IMAGES/slide4.jpg" style="width:100%">
    </div>
    <div class="mySlides fade">
        <img src="IMAGES/slide5.jpg" style="width:100%">
    </div>
    <div class="mySlides fade">
        <img src="IMAGES/slide6.jpg" style="width:100%">
    </div>

    <!-- Navigation Dots -->
    <div class="dots-container">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
        <span class="dot" onclick="currentSlide(4)"></span>
        <span class="dot" onclick="currentSlide(5)"></span>
        <span class="dot" onclick="currentSlide(6)"></span>
    </div>
</div>

<script>
    let slideIndex = 0;
    showSlides();

    function showSlides() {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");

        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {
            slideIndex = 1;
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
        setTimeout(showSlides, 4000); // Change slide every 4 seconds
    }

    function currentSlide(n) {
        slideIndex = n - 1; // Adjust index for zero-based counting
        showSlides();
    }
</script>

</body>
</html>
