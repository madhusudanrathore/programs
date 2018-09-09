<?php
	include('library_silverwing_MVC/dao.php');
	$d=new dao();
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<center>
		<table border="1">
			<thead>
				<tr>
						<th>Name</th>
						<th>E-Mail</th>
						<th>Mobile No</th>
				</tr>
			</thead>
			<tbody>
			<?php
				$q=$d->select('mvc-1',"","");
				while ($data=mysqli_fetch_array($q)) {
				?>
					<tr>
						<td><?php echo $data['name'];?></td>
						<td><?php echo $data['mail'];?></td>
						<td><?php echo $data['mobile'];?></td>
					</tr>
				<?php } ?>
			</tbody>
		</table>
	</center>
</body>
</html>