<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="login.css">
<script src="https://kit.fontawesome.com/986acf6314.js" crossorigin="anonymous"></script>
<title>Admin Login</title>
</head>
<body>
     <div class="bg-container">
         <h1 class="main-heading">ACCOUNT LOGIN</h1>
         <div class="form-container">
         	<form action="checklogIn" class="form" method="post">
	             <div class="inputs-cont">
	                 <i class="fa-solid fa-user icon"></i>
	                 <input type="text" name="username" placeholder="User Name" class="input">
	             </div>
	             <hr/>
	             <div>
	                 <i class="fa-solid fa-lock icon"></i>
	                 <input type="password" name="password" placeholder="Password" class="input">
	             </div>
	             <hr/>             
              <input type="submit" class="btn" value="LOGIN">
             </form>
         </div>
     </div>
</body>
</html>