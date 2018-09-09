<?php
	$conn = new mysqli("localhost", "root", "", "category");
?>

<!DOCTYPE html>
<html>
<head>
	<title>CATEGORY</title>
</head>
<body>

	<form action="controller.php" method="post">
		<h4>Select Category</h4>

		<select name="dropdown_select">
			<?php
			$q = "select * from category";
			$result = $conn->query($q);
			while( $data = $result->fetch_array() ){
			?>
			<option value="<?php echo $data['category_id']?>"><?php echo $data['category_name']?></option>

			<?php
				}
			?>
	  	</select>

	  	<h4>Enter Category</h4>
	  	<input type="text" name="sub_category"><br><br>

		<input type="submit" value="Insert" name="selectBTN">
	</form>


</body>
</html>