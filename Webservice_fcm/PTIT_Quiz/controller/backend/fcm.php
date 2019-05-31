<?php 
	if(isset($_GET['send_notification'])){
	   send_notification ();
	}
	function send_notification()
	{

		//echo 'Hello';
	define( 'API_ACCESS_KEY', 'AAAAvRGYdF8:APA91bHwYC9fdEDr-uw5OpecsXeTPIkcpMibyPxuxIQpig7Kw0CjC_7xG3RhnawO2lVk0AyCkhDD4hq6cggQ2eMgg0ZmPOdvCz5xuF1CljnrgmMEN6klFBtFzpIkSQyYV1uNj2LuvdRZ');
	 //   $registrationIds = ;
	#prep the bundle
	include "config.php";
	
		$sql = "select * from tbl_schedule where schedule_id = (select max(schedule_id) from tbl_schedule)";
				//$result = mysqli_query($db,$sql) or die("Lỗi!");
				$result = mysqli_query($db,$sql);
				$rows = mysqli_fetch_object($result);
	     $msg = array
	          (
			'body' 	=> $rows->monhoc,
			'title'	=> $rows->sinhvien,
			'click_action' => $rows->dethi,
	             	
	          );
	          $re = isset($_REQUEST['token']) ? $_REQUEST['token'] : "dBW7bzqCt6Y:APA91bFACXFpQb5oXCx7fwpcr-sLZ3ZRd8T2ZWqlI7XeGq6_1Nz-3X84L5rwxnUaaArkrD-MhGKFID_k2yD2xE1HsAkBcRm6g39QeDPQScBGgvo6JznkOyijB63c3w3He24HTFM4paqO" ? $_REQUEST['token'] : "dg3vgiXR3Gg:APA91bHJCxupcH_lcDM852u2tX_QLj8IQ-yA3ZPA5tJuBN9ZtKTW4wb0Dm6F2fMRKuYspmXO3ZNsanWYmruvtlE5ysXs6LBRuexbgDcYvGFi296Eb_3Su4POJGsmfWvbLTaCcpijjK5K";

		$fields = array
				(
					'to'		=> "$re",
					'notification'	=> $msg
				);
		
		
		$headers = array
				(
					'Authorization: key=' . API_ACCESS_KEY,
					'Content-Type: application/json'
				);
	#Send Reponse To FireBase Server	
			$ch = curl_init();
			curl_setopt( $ch,CURLOPT_URL, 'https://fcm.googleapis.com/fcm/send' );
			curl_setopt( $ch,CURLOPT_POST, true );
			curl_setopt( $ch,CURLOPT_HTTPHEADER, $headers );
			curl_setopt( $ch,CURLOPT_RETURNTRANSFER, true );
			curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER, false );
			curl_setopt( $ch,CURLOPT_POSTFIELDS, json_encode( $fields ) );
			$result = curl_exec($ch );
			//echo $result;
			curl_close( $ch );
	}
?>