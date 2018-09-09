<?php  
session_start();
include ('lib/dbconnect.php');
include('lib/model.php');
include('lib/dao.php');
$m=new model();
$d=new dao();

	extract($_POST);
	if (isset($_POST['selectBTN'])) {


		$dropdown_select;
 
 		$m->set_data("sub_category_name","$sub_category");
        $m->set_data("category_id","$dropdown_select");


		$a = array('sub_category_name'=>$m->get_data('sub_category_name'),
					'category_id'=>$m->get_data('category_id')
				);

		$temp= $d->insert('sub_category',$a);
	}

?>