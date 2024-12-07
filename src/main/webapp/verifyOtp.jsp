<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/verifyOtp" method="get">
    <label for="otp">Enter OTP:</label>
    <input type="text" id="otp" name="enteredOtp" required>
    <button type="submit">Verify</button>
</form>


<%--<form action="verifyOtp" method="get">
    <label for="otp">Enter OTP:</label>
    <input type="text" id="otp" name="enteredOtp" required>
    <button type="submit">Verify</button>
</form>
<p>Didn't receive the OTP? <a href="/resendOtp">Resend OTP</a></p>
 --%>

</body>
</html>