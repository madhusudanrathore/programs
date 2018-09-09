<?php 
session_start();
if(isset($_SESSION['id'])) {
  header("location:home.php");
}

 ?>

<!DOCTYPE html>
<html>
<head>
	<title>form</title>
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
.cars
{
	background-color: rgba(0,0,0,0.1);
}
</style>
	


</head>
<body>
<!-- <form action="demo.php" method="get"> to show the data in form of table using file demo.php -->
<div class="col-md-4 col-md-offset-6">
<div class="container">
<h1><u><em>REGISTER</em></u></h1>
</div>
</div>
<form action="add.php" method="post" enctype="multipart/form-data">
<div class="col-md-4 col-md-offset-2">
<div class="container">
	<div class="form-group">
	<label>name</label>
	<input type="text" class="form-control" name="name"><br>
	</div>
	<div class="form-group">

	<label>email</label>
	<input type="text" class="form-control" name="email"><br>
</div>
<div class="form-group">
	<label>mobile</label>
	<input type="number" class="form-control" name="mobile"><br>
</div>

<div class="form-group">
	<label>password</label>
	<input type="password" class="form-control" name="password"><br>
</div>
<div class="form-group">
	Select image to upload:
    <input type="file" class="btn btn-info" name="img" id="fileToUpload"><br>
</div>
<div class="form-group">
    <label>Gender</label>
    <input type="radio" name="gender" value="female">Female
    <input type="radio" name="gender" value="male">male<br>
</div>
<div class="form-group">
    <input type="checkbox" name="hobby[]" value="painting">Painting
    <input type="checkbox" name="hobby[]" value="reading">Reading
    <input type="checkbox" name="hobby[]" value="dancing">Dancing<br>
</div>
<div class="form-group">
    <select name="cars" class="cars">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="fiat">Fiat</option>
  <option value="audi">Audi</option>
	</select><br>
	</div>
	<div class="form-group">
	<label>address</label><br>
	<textarea name="address" rows="5" cols="50"></textarea><br>
    </div>

	<input type="submit" class="btn btn-success btn-lg" value="submit" name="submit">
	<button action="logout.php" class="btn btn-info btn-lg">
     <a href="login.php" style="color:white">Login</a>
 </button>
	

	</div>
</form>

</body>
</html>