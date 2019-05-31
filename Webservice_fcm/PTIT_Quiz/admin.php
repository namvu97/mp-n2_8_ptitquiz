<?php 
	//start session
	session_start();
	//load file config.php
	include "config.php";
	//load file model
	include "model/model.php";
	//--------------
	//lay gia tri cua bien controller truyen tu url
	$controller = isset($_GET["controller"])?$_GET["controller"]:"";
	//gan cac thanh phan de bien $controller thanh duong dan hoan chinh.
	$controller = "controller/backend/controller_$controller.php";
	include "view/backend/master.php";
	//--------------
 ?>