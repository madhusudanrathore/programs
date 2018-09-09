 <?php 
 define("host","localhost");
define("user","root");
define("password","");
define("db","ld");
$conn = new mysqli(host, user, password,db);
extract($_POST);
if(isset($_POST['submit']))
{	// $imagetype=$_FILES["img"]['type'];
// $imagesize=$_FILES["img"]['size'];
 	$image_Arr=$_FILES["img"];

 	move_uploaded_file($image_Arr['tmp_name'], 'img/'.$image_Arr['name']);
 	$img=$image_Arr['name'];



	$hobby = implode(',', $_POST['hobby']);
	$sql = "UPDATE form SET name='$name',email='$email',mobile='$mobile',password='$password',image='$img',gender='$gender',hobby='$hobby',cars='$cars',address='$address' WHERE id = '$id'";



 
	
	
if ($conn->query($sql) === TRUE) {
   header("location:add.php");
} 
else {
    echo "Error: " . $sql . "<br>" . $conn->error;

}
}



  ?>