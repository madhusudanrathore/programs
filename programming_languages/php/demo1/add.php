
 <?php 
 session_start();
 define("host","localhost");
define("user","root");
define("password","");
define("db","ld");

$conn = new mysqli(host, user, password,db);

 date_default_timezone_set("Asia/Kolkata");
  extract($_POST);
 extract($_GET);
$userid=$_SESSION['id'];






/*if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "Connected successfully";

/*$sql = "CREATE TABLE form (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(30) NOT NULL,
email VARCHAR(30) NOT NULL,
mobile VARCHAR(30),
password VARCHAR(30))";

if ($conn->query($sql) === TRUE) {
    echo "Table form created successfully";
} else {
    echo "Error creating table: " . $conn->error;
}*/

if(isset($_POST['submit']))
{	

	$image_Arr=$_FILES["img"];

move_uploaded_file($image_Arr['tmp_name'], 'img/'.$image_Arr['name']);
$img=$image_Arr['name'];

	$hobby = implode(',', $_POST['hobby']);
	$img=$image_Arr['name'];
    // echo $hobby;
	//encrypt password
	$password=md5($password);
	$sql = "INSERT INTO form (name, email, mobile,password,image,gender,hobby,cars,address)
  VALUES ('$name', '$email', '$mobile','$password','$img','$gender','$hobby','$cars','$address')";

if ($conn->query($sql) === TRUE) {
   $id= $conn->insert_id;
		$_SESSION['id']=$id;
		$_SESSION['name']=$name;
		$_SESSION['email']=$email;
		header("location:home.php");
	}
	else {
		header("location:form.php");
	}
}


if(isset($_POST['login'])) {
	 $password= md5($password);
	$q="SELECT * FROM form WHERE email='$email' AND password='$password'";
	$result=$conn->query($q);
	$data=$result->fetch_array();
	if($data>0){
		$_SESSION['id']=$data['id'];
		$_SESSION['name']=$data['name'];
		$_SESSION['email']=$data['email'];
		header("location:home.php");
	} else {
		header("location:login.php?msg=Wrong details");
	}
}
?>
<!-- <?php 

$q = "SELECT * FROM form";
$result = $conn->query($q);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        echo "id: " . $row["id"]. " - Name: " . $row["name"]. "- Email: " . $row["email"]. "- Mobile: " . $row["mobile"]. " - Password: " . $row["password"]. /*"- Image " . $row["img"].*/ " - Gender: " . $row["gender"]. " - Hobby: " . $row["hobby"]. " - Cars: " . $row["cars"]. "<br>";
    }
} else {
    echo "0 results";
}

 ?> -->
<!-- while($data=$result->fetch_array())
<td><?php echo data["name"] ?></td> -->



