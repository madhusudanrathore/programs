<?php 
session_start();
include 'connection.php';
date_default_timezone_set("Asia/Kolkata");
extract($_POST);
extract($_GET);
$userid=$_SESSION['id'];
$createdDate= date("d/m/Y h:i:sa");
// register new user
if(isset($_POST['register'])) {
	$password = md5($password);
	$q="INSERT INTO form (name,email,password) VALUES ('$name','$email','$password')";
	if($conn->query($q)===TRUE) {
		$user_id= $conn->insert_id;
		$_SESSION['id']=$id;
		$_SESSION['name']=$name;
		$_SESSION['email']=$email;
		header("location:index.php");
	}
	else {
		header("location:register.php");
	}
}

//Check User Login

if(isset($_POST['login'])) {
	$password= md5($password);
	$q="SELECT * FROM form WHERE email='$email' AND password='$password'";
	$result=$conn->query($q);
	$data=$result->fetch_array();
	if($data>0){
		$_SESSION['id']=$data['id'];
		$_SESSION['name']=$data['name'];
		$_SESSION['email']=$data['email'];
		header("location:index.php");
	} else {
		header("location:login.php?msg=Wrong details");
	}
}

// delete user 

if(isset($_POST['deleteUser'])) {
	if($id==$userid) {
		$q="DELETE FROM users WHERE id='$id'";
		if($conn->query($q)===TRUE) {
			header("location:login.php");
		}
		else {
			header("location:register.php");
		}
	} else {
		header("location:index.php?msgError=Access Denide");
	}
}

 ?>