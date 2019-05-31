<?php 
	class controller_add_edit_schedule{
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
					$form_action = "admin.php?controller=add_edit_schedule&act=do_edit&id=$id";
					//lay mot ban ghi tuong ung voi id truyen vao
					$arr = $this->model->get_a_record("select * from tbl_schedule where schedule_id=$id");
				break;
				case "do_edit":
					$monhoc = $_POST["monhoc"];
					$dethi = $_POST["dethi"];
					//-------------
					//loai bo ky tu nhay don
					$monhoc = str_replace("'", "\'", $monhoc);
					//-------------
					//update ban ghi co id truyen vao
					$this->model->execute("update tbl_schedule set monhoc='$monhoc',dethi='$dethi' where schedule_id=$id");
					$sinhvien = $_POST["sinhvien"];
					$sinhvien = str_replace("'", "\'", $sinhvien);
					//-------------
					//update ban ghi co id truyen vao
					$this->model->execute("update tbl_schedule set sinhvien='$sinhvien' where schedule_id=$id");
					if($sinhvien == "Sinh viên 1") 
						//quay tro lai trang schedule
					header("location:tao_dot_thi-sinhvien1");
					if($sinhvien == "Sinh viên 2") 	
						//quay tro lai trang schedule
					header("location:tao_dot_thi-sinhvien2");
					if($sinhvien == "Sinh viên 3") 	
						//quay tro lai trang schedule
					header("location:tao_dot_thi-sinhvien3");
				break;
				case "add":
					$form_action = "admin.php?controller=add_edit_schedule&act=do_add";
				break;
				case "do_add":
					$monhoc = $_POST["monhoc"];
					$dethi = $_POST["monhoc"];
					$hinhthuc = $_POST["hinhthuc"];
					$sinhvien = $_POST["sinhvien"];
					//insert ban ghi
					$this->model->execute("insert into tbl_schedule(monhoc,dethi,hinhthuc,sinhvien) values('$monhoc','$dethi','$hinhthuc','$sinhvien')");
					if($sinhvien == "Sinh viên 1") 
						//quay tro lai trang schedule
					header("location:tao_dot_thi-sinhvien1");
					if($sinhvien == "Sinh viên 2") 	
						//quay tro lai trang schedule
					header("location:tao_dot_thi-sinhvien2");
					if($sinhvien == "Sinh viên 3") 	
						//quay tro lai trang schedule
					header("location:tao_dot_thi-sinhvien3");
				break;
			}
			//-------------

			$arr2 = $this->model->get_all("select DISTINCT made from tbl_question order by question_id desc");
			//load view
			include "view/backend/view_add_edit_schedule.php";
		}
	}
	new controller_add_edit_schedule();
 ?>