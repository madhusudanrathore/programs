<?php

class dbconnect
{
    function connect()
    {
        $connection=mysqli_connect("localhost","root","","mvc_ld");
				return $connection;
    }
}
?>