<div class="row justify-content-center">
	<div class="col-md-12">
		<!-- card -->
		<div style="margin:15px 0px">
			<a href="admin.php?controller=add_edit_question&act=add" class="btn btn-primary">Add</a>
		</div>
		
		<div class="card border-primary">
			<div class="card card-header bg-primary text-white" style="padding:7px !important;">Tạo đợt thi</div>
				<div class="card-body">
				<!-- table -->
				<table class="table table-hover table-bordered" >
					<tr>
						<th style="width: 100px">Môn thi</th>
						<th>Mã đề</th>
						<th>Câu hỏi</th>
						<th>Đáp án 1</th>
						<th>Đáp án 2</th>
						<th>Đáp án 3</th>
						<th>Đáp án 4</th>
						<th>Đáp án đúng</th>
						<th style="width: 150px;"></th>
					</tr>
				<?php 
					foreach($arr as $rows)
					{
				 ?>
					<tr>
						<td><?php echo $rows->monhoc; ?></td>
						<td><?php echo $rows->made; ?></td>
						<td><?php echo $rows->cauhoi; ?></td>
						<td><?php echo $rows->answer1; ?></td>
						<td><?php echo $rows->answer2; ?></td>
						<td><?php echo $rows->answer3; ?></td>
						<td><?php echo $rows->answer4; ?></td>
						<td><?php echo $rows->answer; ?></td>
						<td style="text-align: center;">
							<a href="admin.php?controller=add_edit_question&act=edit&id=<?php echo $rows->question_id; ?>"><img src="public/icon-edit.png" style="width:25px;" />Edit</a>&nbsp;&nbsp;
							<a onclick="return window.confirm('Are you sure?');" href="admin.php?controller=question&act=delete&id=<?php echo $rows->question_id; ?>"><img src="public/icon-remove.png" style="width:25px;" />Delete</a>
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
						<li class="page-item"><a class="page-link" href="admin.php?controller=question&p=<?php echo $i; ?>"><?php echo $i; ?></a></li>
					<?php } ?>
					</ul>
				</div>
			</div>

		</div>
		<!-- end card -->
	</div>
</div>