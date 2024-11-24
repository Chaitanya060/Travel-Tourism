<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div class="split-screen">
        <div class="left">
            <!-- Background image section -->
        </div>
        <div class="right">
            <form action="${pageContext.request.contextPath}/checkclientlogin" method="post">
                <section class="copy">
                    <h1>Sign In</h1>
                    <i class="fa-solid fa-lock fa-beat fa-xl my-icon"
                        style="color:#FFD200;margin-bottom: -5px;"></i>
                </section>
                <div class="input-container">
                    <input type="text" id="email" name="email" required />
                    <label for="email">Email Id</label>
                </div>
                <div class="input-container">
                    <input type="password" id="pwd" name="pwd" required />
                    <label for="pwd">Password</label>
                </div>
                <button type="submit" value="sign in" class="btn" id="signinbtn">SIGN IN</button>
                <br />
                <span style="font-size: 17px;">Don’t have an account? <a href="${pageContext.request.contextPath}/regprompt" style="color: #FFD200;">Sign up</a> now
                </span>
            </form>
        </div>
    </div>
</body>
</html>
