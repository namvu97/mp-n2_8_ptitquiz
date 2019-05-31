<?php
	include "config.php";
		
		$sql1 = "select * from tbl_schedule where schedule_id = (select max(schedule_id) from tbl_schedule)";
				//$result = mysqli_query($db,$sql) or die("Lỗi!");
				$result1 = mysqli_query($db,$sql1);
				$rows1 = mysqli_fetch_object($result1);
				$a=$rows1->dethi;
				$b=$rows1->monhoc;
		$sql = "select * from tbl_question where made = '$a'  AND monhoc= '$b'";
				//$result = mysqli_query($db,$sql) or die("Lỗi!");
				$result = mysqli_query($db,$sql);
	class schedule{
		function schedule($monhoc, $hinhthuc){
			$this -> monhoc = $monhoc;
			$this -> hinhthuc = $hinhthuc;
		}
	}
	$mang = array();
	while($rows = mysqli_fetch_object($result))
				$mang[] = $rows;

	
	echo json_encode($mang);
?>