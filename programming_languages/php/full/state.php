<?php 
define("host","localhost");
define("user","root");
define("password","");
define("db","ld");

$conn = new mysqli(host, user, password,db); 
extract($_POST);
$q="SELECT * FROM state WHERE country_id='$country_id'";
	$result=$conn->query($q);
	while($data=$result->fetch_array())
	{
	 ?>
	<option value="<?php echo $data['s_id'];?>">
		<?php echo $data['s_name']; ?></option>


<?php } ?>
