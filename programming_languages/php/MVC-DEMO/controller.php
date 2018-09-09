<?php  
include('library_silverwing_MVC/model.php');
include('library_silverwing_MVC/dao.php');
$m=new model();
$d=new dao();
	
extract($_POST);
if (isset($_POST['submit'])) {
	$m->set_data("name",$name);
	$m->set_data("mail",$mail);
	$m->set_data("mobile",$mobile);

	$a = array('name' =>$m->get_data('name'),
			'mail'=>$m->get_data('mail'),
			'mobile'=>$m->get_data('mobile'));
	$temp= $d->insert('mvc-1',$a);

	if ($temp>0) {
		header('location:view.php');
	}
	else{
		echo "Error occured";
	}

}

?>

