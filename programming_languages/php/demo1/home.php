<?php 
session_start();
define("host","localhost");
define("user","root");
define("password","");
define("db","ld");

$conn = new mysqli(host, user, password,db);
if(!isset($_SESSION['id'])) {
  header("location:login.php");
}
$id=$_SESSION['id'];

extract($_POST);


 ?>
<!DOCTYPE html>
<html>
<html lang="en">
<head>
	<title>form</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
<table border="1">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>email</th>
		<th>mobile</th>
		<th>password</th>
		<th>image</th>
		<th>gender</th>
		<th>hobby</th>
		<th>cars</th>
		<th>address</th>
		<th>delete</th>
		<th>edit</th>

	</tr>
	<?php
	//decrypt 
	extract($_POST);
// 	$image_Arr=$_FILES["img"];

// move_uploaded_file($image_Arr['tmp_name'], 'img/'.$image_Arr['name']);
// $img=$image_Arr['name'];

	
	$q = "SELECT * FROM form";
$result = $conn->query($q);
while ($data=$result->fetch_array()) {
	
?>
<tr>
	<td><?php echo $data['id']; ?></td>
	<td><?php echo $data['name']; ?></td>
	<td><?php echo $data['email']; ?></td>
	<td><?php echo $data['mobile']; ?></td>
	<td><?php echo $data['password']; ?></td>
	<td><img height="100" src="img/<?php echo $data['image'];  ?>"> </td>
	<td><?php echo $data['gender']; ?></td>
	<td><?php echo $data['hobby']; ?></td>
	<td><?php echo $data['cars']; ?></td>
	<td><?php echo $data['address']; ?></td>
	<?php if($id==$data['id']) { ?>
        <form action="add.php" method="post">
          <input type="hidden" name="id" value="<?php echo $data['id']; ?>">
	<td><button><a href="delete.php?user_id=<?php echo $data['id'];?> ">delete</a></button> </td>
	<td><button><a href="edit.php?user_id=<?php echo $data['id'];?> ">edit</a></button></td>
		<?php } ?>
	
</tr>
<?php  }?>

</table>
</body>
</html>
<button action="logout.php" class="btn btn-info btn-lg">
<a href="logout.php" style="color:white">Logout</a>
</button>