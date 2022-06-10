<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="contactUs.css">
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<div class="bg-container">
        <div class="container">
            <div class="heading-container">
                <h1 class="main-heading">Contact Us</h1>
                <p class="main-description">Please fill this form in a decent manner</p>
            </div>
            <div class="form-container">
                <form action="Submit" class="form" method="post">
                    <div class="inputs-container">
                        <label for="name">Full name <span class="span">*</span></label>
                        <input id="name" type="text"  class="inputs" placeholder="Please enter your Name" name="name">
                    </div>
                    <div class="inputs-container">
                        <label for="email">E-mail <span class="span">*</span></label>
                        <input id="email" type="text"  placeholder="Please enter your E-mail" name="email">
                        <p class="example">example@example.com</p>
                    </div>
                    <div class="inputs-container">
                        <label for="name">Message   <span class="span">*</span></label>
                        <textarea rows="5" cols="30" style="display: block; width: 400px; margin-top: 10px;" name="textarea">   
                        </textarea>
                    </div>
                    <input type="submit" class="submit-btn">
                </form> 
            </div>
        </div>	
	</div>
</body>
</html>