<?php 
	
	include "fcm.php";
	class controller_question{
		public $model;

		public function __construct(){
			//---------
			$this->model = new model();
			//---------
			//lay bien act tu url
			$act = isset($_GET["act"]) ? $_GET["act"]:"";
			//lay bien id tu url
			$id = isset($_GET["id"]) ? $_GET["id"]:0;
			switch($act){
				case "delete":
					//xoa ban ghi co id truyen vao
					$this->model->execute("delete from tbl_question where question_id=$id");
					//quay tro lai trang question
					header("location:admin.php?controller=question");
				break;
			}
			//---------
			//quy dinh so ban ghi tren 1 trang
			$record_perpage = 10;
			//tinh tong so ban ghi
			$total = $this->model->num_rows("select question_id from tbl_question");
			//tinh so trang
			$num_page = ceil($total/$record_perpage);
			//lay trang hien tai (la bien p truyen tu url)
			$page = isset($_GET["p"])&&$_GET["p"]>0?($_GET["p"]-1):0;
			//lay tu ban ghi nao
			$from = $page * $record_perpage;
			//lay cac ban ghi
			$arr = $this->model->get_all("select * from tbl_question order by monhoc desc limit $from,$record_perpage");
			//---------
			//load view
			include "view/backend/view_question.php";
			//load view
		}
	}
	new controller_question();




 ?>