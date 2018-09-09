<?php 

$imagetype=$_FILES["img"]['type'];
$imagesize=$_FILES["img"]['size'];
$image_Arr=$_FILES["img"];

move_uploaded_file($image_Arr['tmp_name'], 'img/'.$image_Arr['name']);
$img=$image_Arr['name'];
echo $img;


 ?>