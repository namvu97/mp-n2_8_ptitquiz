<div class="row justify-content-center">
	<div class="col-md-12">
		<!-- card -->
		<div style="margin:15px 0px">
			<a href="admin.php?controller=add_edit_schedule&act=add" class="btn btn-primary">Add</a>
		</div>
		
		<div class="card border-primary">
			<div class="card card-header bg-primary text-white" style="padding:7px !important;">Tạo đợt thi</div>
				<div class="card-body">
				<!-- table -->
				<table class="table table-hover table-bordered" >
					<tr>
						<th>Môn thi</th>
						<th>Đề thi</th>
						<th>Hình thức bài thi</th>
						<th>Sinh viên</th>
						<th style="width: 150px;"></th>
					</tr>
				<?php 
					foreach($arr as $rows)
					{
				 ?>
					<tr>
						<td><?php echo $rows->monhoc; ?></td>
						<td><?php echo $rows->dethi; ?></td>
						<td><?php echo $rows->hinhthuc; ?></td>
						<td><?php echo $rows->sinhvien; ?></td>
						<td style="text-align: center;">
							<a href="admin.php?controller=add_edit_schedule&act=edit&id=<?php echo $rows->schedule_id; ?>"><img src="public/icon-edit.png" style="width:25px;" />Edit</a>&nbsp;&nbsp;
							<a onclick="return window.confirm('Are you sure?');" href="admin.php?controller=schedule&act=delete&id=<?php echo $rows->schedule_id; ?>"><img src="public/icon-remove.png" style="width:25px;" />Delete</a>
						</td>
					</tr>
				<?php } ?>
				</table>
				<!-- end table -->
				</div>
				<div class="card-footer" style="padding:7px !important">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">Trang</a></li>
					<?php 
						for($i = 1; $i <= $num_page; $i++)
						{
					 ?>	
						<li class="page-item"><a class="page-link" href="admin.php?controller=schedule&p=<?php echo $i; ?>"><?php echo $i; ?></a></li>
					<?php } ?>
					</ul>
				</div>
			</div>
		</div>
		<!-- end card -->
	</div>
</div>