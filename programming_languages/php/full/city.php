<?php 
define("host","localhost");
define("user","root");
define("password","");
define("db","ld");

$conn = new mysqli(host, user, password,db); 
extract($_POST);
$q="SELECT * FROM city WHERE s_id='$s_id'";
	$result=$conn->query($q);
	while($data=$result->fetch_array())
	{
	 ?>
	<option value="<?php echo $data['city_id'];?>">
		<?php echo $data['city_name']; ?></option>


<?php } ?>
