<!DOCTYPE html>
<html>


<!-- Mirrored from webapplayers.com/inspinia_admin-v1.9.2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Apr 2015 10:15:20 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Login</title>

    <link href="${pageContext.request.contextPath}/assets/admintheme/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/admintheme/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/assets/admintheme/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/admintheme/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">Java</h1>

            </div>      
           
            <form class="m-t" method="POST" action="LoginServlet">
                <div class="form-group">
                    <input type="text" name = "Username" class="form-control" placeholder="Username" required="">
                </div>
                <div class="form-group">
                    <input type="password" name = "Password" class="form-control" placeholder="Password" required="">
                </div>
                <input type="submit" class="btn btn-primary block full-width m-b" value="Submit"/>

                <a href="#"><small>Forgot password?</small></a>               
            </form>
            
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/assets/admintheme/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/admintheme/js/bootstrap.min.js"></script>

</body>

</html>
