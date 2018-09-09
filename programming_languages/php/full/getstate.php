<?php 
define("host","localhost");
define("user","root");
define("password","");
define("db","ld");

$conn = new mysqli(host, user, password,db); ?>

<!DOCTYPE html>
<html>
<head>
	<title>get</title>
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		function getstate()
		{
			jQuery.ajax({
				url:'state.php',
				type: 'POST',
				data: {country_id:$('#country_id').val()},
				success: function(data)
				{
					$("#abc").html(data);
					
				}
			});
		}
        
        function getcity()
		{
			jQuery.ajax({
				url:'city.php',
				type: 'POST',
				data: {s_id:$('#abc').val()},
				success: function(data)
				{
					$("#pqr").html(data);
				}
			});
		}


	</script>
</head>
<body>
		<label>country</label>
		<select id="country_id" onchange="getstate();">
		<option>select country</option>

	<?php 
	extract($_POST);
	$q="SELECT * FROM country";
	$result=$conn->query($q);
	while($data=$result->fetch_array())
	{
	 ?>
	<option value="<?php echo $data['country_id'];?>"><?php echo $data['country_n']; ?></option>


<?php } ?>
</select>
<br>
<br>
<!-- <div class="x" style="display:none"> -->
<label>state</label>
<select id="abc" onchange="getcity();">
	<option>select state</option>
	
</select>
<!-- </div> -->
<br>
<br>
<!-- <div class="y" style="display:none"> -->
<label>city</label>
<select id="pqr">
	<option>select city</option>
</select>
<!-- </div>
 -->
</body>
</html>