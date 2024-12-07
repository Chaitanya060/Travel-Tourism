<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: "Karla", sans-serif;
            background-color: #d0d0ce;
            min-height: 100vh;
        }
        
        .login-card {
            border: 0;
            border-radius: 27.5px;
            box-shadow: 0 10px 30px 0 rgba(172, 168, 168, 0.43);
            overflow: hidden;
        }
        
        .login-card-img {
            border-radius: 0;
            position: absolute;
            width: 100%;
            height: 100%;
            -o-object-fit: cover;
               object-fit: cover;
        }
        
        .login-card .card-body {
            padding: 85px 60px 60px;
        }

        .login-card-description {
            font-size: 25px;
            color: #000;
            font-weight: normal;
            margin-bottom: 23px;
        }

        .login-card .form-control {
            border: 1px solid #d5dae2;
            padding: 15px 25px;
            margin-bottom: 20px;
            min-height: 45px;
            font-size: 13px;
            font-weight: normal;
        }

        .login-card .login-btn {
            padding: 13px 20px 12px;
            background-color: #000;
            border-radius: 4px;
            font-size: 17px;
            font-weight: bold;
            color: #fff;
            margin-bottom: 24px;
            width: 100%;
        }

        .login-card .login-btn:hover {
            background-color: #FFD200;
            color: #000;
        }

        .login-card-footer-text {
            font-size: 16px;
            color: #0d2366;
        }
        
        .brand-wrapper {
    margin-bottom: 19px;
}

.brand-text {
    font-size: 28px;
    font-weight: bold;
    font-family: 'Karla', sans-serif; /* Use the same font-family as the rest of the page */
    color: #333; /* Adjust the color as needed */
    text-transform: uppercase; /* Optional: to make the text uppercase */
    display: inline-block; /* Ensure proper alignment */
}
        
        
    </style>
</head>
<body>
    <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
        <div class="container">
            <div class="card login-card">
                <div class="row no-gutters">
                    <div class="col-md-5">
                        <img src="${pageContext.request.contextPath}/IMAGES/login.png" alt="login" class="login-card-img">

                    </div>
                    <div class="col-md-7">
                        <div class="card-body">
                            <div class="brand-wrapper">
                     			<span class="brand-text">Travel.</span>
							</div>

                            <p class="login-card-description">Sign into your account</p>
                            <form action="${pageContext.request.contextPath}/checkclientlogin" method="post">
                                <div class="form-group">
                                    <label for="email" class="sr-only">Email</label>
                                    <input type="text" name="email" id="email" class="form-control" placeholder="Email address" required>
                                </div>
                                <div class="form-group mb-4">
                                    <label for="pwd" class="sr-only">Password</label>
                                    <input type="password" name="pwd" id="pwd" class="form-control" placeholder="***********" required>
                                </div>
                                <button name="login" id="signinbtn" class="btn login-btn mb-4" type="submit">SIGN IN</button>
                            </form>
                            <a href="#" class="forgot-password-link">Forgot password?</a>
                            <p class="login-card-footer-text">
                                Don't have an account? 
                                <a href="${pageContext.request.contextPath}/regprompt" style="color: #FFD200;">Register here</a>
                            </p>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
