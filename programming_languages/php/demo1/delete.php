<?php 
define("host","localhost");
define("user","root");
define("password","");
define("db","ld");
$conn = new mysqli(host, user, password,db);
  extract($_GET);
 if(isset($_GET['user_id']))
{ 	

	// $last_id = mysqli_insert_id($conn);
	$sql = "DELETE FROM form WHERE id = '$user_id'";
	
if ($conn->query($sql) === TRUE) {
   header("location:add.php");
} 
else {
    echo "Error: " . $sql . "<br>" . $conn->error;

}


}
?>
