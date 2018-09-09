<?php
define("host","localhost");
define("user","root");
define("password","");
define("db","ld");
$conn = new mysqli(host, user, password,db);
  extract($_GET);
  $q="SELECT * FROM form WHERE id='$user_id'";
   $result = $conn->query($q);
  $data=$result->fetch_array();?>


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
	
 </head>
 <body>
 <div class="col-md-4 col-md-offset-6">
<div class="container">
<h1><u><em>REGISTER</em></u></h1>
</div>
</div>
<form action="update.php" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<?php echo $data['id']; ?>">
<div class="col-md-4 col-md-offset-2">
<div class="container">
	<div class="form-group">
	<label>name</label>
	<input type="text" class="form-control" name="name" value="<?php echo $data['name']; ?>"><br>
	</div>
	<div class="form-group">

	<label>email</label>
	<input type="text" class="form-control" name="email" value="<?php echo $data['email']; ?>" ><br>
</div>
<div class="form-group">
	<label>mobile</label>
	<input type="number" class="form-control" name="mobile" value="<?php echo $data['mobile']; ?>"><br>
</div>

<div class="form-group">
	<label>password</label>
	<input type="text" class="form-control" name="password" value="<?php echo $data['password']; ?>"><br>
</div>
<div class="form-group">
	Select image to upload:
    <input type="file" class="btn btn-primary" name="img" id="fileToUpload"><br>
</div>
<div class="form-group">
    <label>Gender</label>
    <input type="radio" <?php if($data['gender']=="female") {echo "checked";} ?> name="gender" value="female">Female
    <input type="radio" <?php if($data['gender']=="male") {echo "checked";} ?> name="gender" value="male">male<br>
</div>
<?php echo $h=$data['hobby'];
$hh=explode(',', $h);
echo print_r($hh); ?>

<div class="form-group">
    <input type="checkbox" <?php if($data['hobby']=="painting") {echo "checked";} ?> name="hobby[]" value="painting">Painting
    <input type="checkbox" <?php if($data['hobby']=="reading") {echo "checked";} ?>  name="hobby[]" value="reading">Reading
    <input type="checkbox" <?php if($data['hobby']=="dancing") {echo "checked";} ?> name="hobby[]" value="dancing">Dancing<br>
</div>
<div class="form-group">
    <select name="cars">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="fiat">Fiat</option>
  <option value="audi">Audi</option>
	</select><br>
	</div>
	<div class="form-group">
	<label>address</label><br>
	<textarea name="address" rows="5" cols="50"><?php echo $data['address'];?></textarea><br>
    </div>
	<input type="submit" class="btn btn-primary btn-lg" name="submit" value="update">
	</div>

</form>
 </body>
 </html>
