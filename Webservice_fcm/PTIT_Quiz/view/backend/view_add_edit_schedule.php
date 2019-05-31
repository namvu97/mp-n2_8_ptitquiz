<div class="row justify-content-center">
	<div class="col-md-12">
		<!-- card -->		
		<div class="card  border-primary">
			<div class="card card-header bg-primary text-white">Add edit schedule</div>
			<div class="card-body">
				<form method="post" action="<?php echo $form_action; ?>">
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Môn học</div>
							<div class="col-md-10">
								<select type="text" name="monhoc">
									<option>Mạng máy tính</option>
									<option>Lập trình web</option>
									<option>An toàn bảo mật</option>
									<option>Xác suất thống kê</option>
									<option>Hệ điều hành Win/Unix/Linux</option>
									<option>Quản lý dự án phần mềm</option>
								</select>
								
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Đề thi</div>
							<div class="col-md-10">
								<select type="text" name="dethi">
									<?php 
										foreach($arr2 as $rows)
										{
									 ?>
									<option><?php echo $rows->made; ?></option>
									<?php 
										}
									 ?>
								</select>
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Hình thức thi</div>
							<div class="col-md-10">
								<input <?php if(isset($arr->hinhthuc)) { ?> disabled <?php } ?> required type="text" name="hinhthuc" value="<?php echo isset($arr->hinhthuc)?$arr->hinhthuc:""; ?>" class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Sinh viên</div>
							<div class="col-md-10">
								<select type="text" name="sinhvien">
									<option>Sinh viên 1</option>
									<option>Sinh viên 2</option>
									<option>Sinh viên 3</option>
								</select>
								
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right"></div>
							<div class="col-md-10">
								<input type="submit" value="Process" class="btn btn-primary"> <input type="reset" value="Reset" class="btn btn-danger">
							</div>
						</div>
					</div>
					<!-- end form group -->
				</form>
			</div>
		</div>
		<!-- end card -->
	</div>
</div>