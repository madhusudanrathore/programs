<?php 
session_start();
if(isset($SESSION['id']))
{
	header("location:home.php");
}

 ?>


<!DOCTYPE html>
<html>
<head>
	<title>login</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	

	<meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<style>
body  {
    background-image: url("5.jpg");
    width: 100%;
    color: white;
    /*background-color: #cccccc;*/
}
	
</style>
	
</head>
<body>
	<h3 align="center">LOGIN</h3>
<form method="post" action="add.php">
	<label>email</label>
	<input type="text" class="form-control" name="email"><br>

	<label>password</label>
	<input type="password" class="form-control" name="password"><br>
	<input type="submit" class="btn btn-success btn-lg" name="login" value="login">
    <a href="form.php">Sign Up?</a>

</form>
</body>
</html>
