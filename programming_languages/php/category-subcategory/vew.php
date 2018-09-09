<?php
include('lib/dao.php');

$d=new Dao();
?>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>Sucate_id</th>
        <th>sub_cat name</th>
        <th>category</th>
      </tr>
    </thead>
    <tbody>
       <?php
        $q=$d->select("sub_category,category","sub_category.category_id=category.category_id","");
        while ($data=mysqli_fetch_array($q)) {
          # code...
        
       ?>

      <tr>
        <td><?php  echo $data['sub_category_id']; ?></td>
        <td><?php  echo $data['sub_category_name']; ?></td>
        <td><?php  echo $data['category_name']; ?></td>
      </tr>
      <?php } ?>
    </tbody>
  </table>
</div>

</body>
</html>