<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/signup.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- sign-up.jsp -->
<div class="signup-container">
    <div class="signup-form">
        <form action="${pageContext.request.contextPath}/addclient" method="post">
            <section class="form-header text-center">
                <h3>Create Your Account</h3>
                <p>Fill in the information below to create your account.</p>
            </section>

            <!-- First and Last Name -->
            <div class="form-row">
                <div class="form-field">
                    <label for="fname">First Name</label>
                    <input type="text" id="fname" name="fname" required>
                </div>
                <div class="form-field">
                    <label for="lname">Last Name</label>
                    <input type="text" id="lname" name="lname" required>
                </div>
            </div>

            <!-- Email and Location -->
            <div class="form-row">
                <div class="form-field">
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="form-field">
                    <label for="location">Location</label>
                    <input type="text" id="location" name="location" required>
                </div>
            </div>

            <!-- Mobile Number -->
            <div class="form-row">
                <div class="form-field">
                    <label for="mobile">Mobile Number</label>
                    <input type="text" id="mobile" name="mobile" required>
                </div>
            </div>

            <!-- Gender and Date of Birth -->
            <div class="form-row">
                <div class="form-field">
                    <label>Gender</label>
                    <div class="gender-options">
                        <label><input type="radio" name="gender" value="male" required> Male</label>
                        <label><input type="radio" name="gender" value="female" required> Female</label>
                    </div>
                </div>
                <div class="form-field">
                    <label for="dob">Date of Birth</label>
                    <input type="date" name="dob" id="dob" required>
                </div>
            </div>

            <!-- Password and Confirm Password -->
            <div class="form-row">
                <div class="form-field">
                    <label for="password1">Password</label>
                    <input type="password" id="password1" name="pwd1" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-field">
                    <label for="password2">Confirm Password</label>
                    <input type="password" id="password2" name="pwd2" required>
                </div>
            </div>

            <!-- Sign Up Button -->
            <div class="form-row text-center">
                <button type="submit" class="btn-signup">Sign Up</button>
            </div>
        </form>
    </div>
</div>


</body>
</html>