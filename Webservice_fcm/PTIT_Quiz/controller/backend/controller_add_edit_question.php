<?php 
	class controller_add_edit_question{
		public $model;
		public function __construct(){
			$this->model = new model();
			//-------------
			//lay bien act tu url
			$act = isset($_GET["act"]) ? $_GET["act"]:"";
			//lay bien id tu url
			$id = isset($_GET["id"]) ? $_GET["id"]:0;
			//tao bien $form_action de xac dinh trang thai submit cua form la add hay la edit
			//kiem tra cac truong hop cua bien $act
			switch($act){
				case "edit":
					$form_action = "admin.php?controller=add_edit_question&act=do_edit&id=$id";
					//lay mot ban ghi tuong ung voi id truyen vao
					$arr = $this->model->get_a_record("select * from tbl_question where question_id=$id");
				break;
				case "do_edit":
					$monhoc = $_POST["monhoc"];
					$made = $_POST["made"];
					$cauhoi = $_POST["cauhoi"];
					$answer1 = $_POST["answer1"];
					$answer2 = $_POST["answer2"];
					$answer3 = $_POST["answer3"];
					$answer4 = $_POST["answer4"];
					$answer = $_POST["answer"];
					//-------------
					//-------------
					//update ban ghi co id truyen vao
					$this->model->execute("update tbl_question set monhoc='$monhoc', made='$made', cauhoi='$cauhoi', answer1='$answer1', answer2='$answer2', answer3='$answer3', answer4='$answer4', answer='$answer' where question_id=$id");
					header("location:admin.php?controller=question");
				break;
				case "add":
					$form_action = "admin.php?controller=add_edit_question&act=do_add";
				break;
				case "do_add":
					$monhoc = $_POST["monhoc"];
					$made = $_POST["made"];
					$cauhoi = $_POST["cauhoi"];
					$answer1 = $_POST["answer1"];
					$answer2 = $_POST["answer2"];
					$answer3 = $_POST["answer3"];
					$answer4 = $_POST["answer4"];
					$answer = $_POST["answer"];
					//insert ban ghi
					$this->model->execute("insert into tbl_question(monhoc,made,cauhoi,answer1,answer2,answer3,answer4,answer) values('$monhoc','$made','$cauhoi','$answer1','$answer2','$answer3','$answer4','$answer')");
						//quay tro lai trang question
					header("location:admin.php?controller=question");
				break;
			}
			//-------------
			//load view
			include "view/backend/view_add_edit_question.php";
		}
	}
	new controller_add_edit_question();
 ?>