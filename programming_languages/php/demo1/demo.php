<?php 
//var_dump($_GET);
print_r($_GET);
$name = $_GET['name'];
$email = $_GET['email'];

$mobile = $_GET['mobile'];

$password = $_GET['password'];




 ?>
 <table border="1">
 <tr>
 	<th>name</th>
 	<td><?php echo "$name"; ?></td>
 </tr>
 	<tr>
 	<th>email</th>
 	<td><?php echo "$email"; ?></td>
 </tr>
 <tr>
 	<th>mobile</th>
 	<td><?php echo "$mobile"; ?></td>
 </tr>
 <tr>
 	<th>password</th>
 	<td><?php echo "$password"; ?></td>
 </tr>




 </table>