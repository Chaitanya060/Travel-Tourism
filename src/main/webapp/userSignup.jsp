<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="CSS/signup.css">
</head>
<body>
    <div class="container">
        <div class="title">Registration</div>
        <form action="${pageContext.request.contextPath}/addclient" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">First Name</span>
                    <input type="text" name="fname" placeholder="Enter your first name" required>
                </div>
                <div class="input-box">
                    <span class="details">Last Name</span>
                    <input type="text" name="lname" placeholder="Enter your last name" required>
                </div>
                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="input-box">
                    <span class="details">Location</span>
                    <input type="text" name="location" placeholder="Enter your location" required>
                </div>
                <div class="input-box">
                    <span class="details">Mobile Number</span>
                    <input type="text" name="mobile" placeholder="Enter your number" required>
                </div>
                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="password" name="pwd1" placeholder="Enter your password" required>
                </div>
                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input type="password" name="pwd2" placeholder="Confirm your password" required>
                </div>
            </div>
            
            <!-- Gender Selection -->
            <div class="gender-details">
                <span class="gender-title">Gender</span>
                <div class="category">
                    <label>
                        <input type="radio" name="gender" value="Male" required>
                        <span class="dot"></span>
                        Male
                    </label>
                    <label>
                        <input type="radio" name="gender" value="Female" required>
                        <span class="dot"></span>
                        Female
                    </label>
                    <label>
                        <input type="radio" name="gender" value="Other" required>
                        <span class="dot"></span>
                        Prefer not to say
                    </label>
                </div>
            </div>
            
            <!-- Date of Birth -->
            <div class="dob-container">
                <label for="dob">Date of Birth</label>
                <input type="date" id="dob" name="dob" required>
            </div>
            
            <div class="button">
                <input type="submit" value="Register">
            </div>
        </form>
    </div>
</body>
</html>
