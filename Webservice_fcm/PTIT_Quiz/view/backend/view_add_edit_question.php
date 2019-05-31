<div class="row justify-content-center">
	<div class="col-md-12">
		<!-- card -->		
		<div class="card  border-primary">
			<div class="card card-header bg-primary text-white">Add edit question</div>
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
							<div class="col-md-2 text-right">Mã đề</div>
							<div class="col-md-10">
								<input type="text" name="made" value="<?php echo isset($arr->made)?$arr->made:""; ?>" required class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Câu hỏi</div>
							<div class="col-md-10">
								<input type="text" name="cauhoi" value="<?php echo isset($arr->cauhoi)?$arr->cauhoi:""; ?>" required class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Đáp án 1</div>
							<div class="col-md-10">
								<input type="text" name="answer1" value="<?php echo isset($arr->answer1)?$arr->answer1:""; ?>" required class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Đáp án 2</div>
							<div class="col-md-10">
								<input type="text" name="answer2" value="<?php echo isset($arr->answer2)?$arr->answer2:""; ?>" required class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Đáp án 3</div>
							<div class="col-md-10">
								<input type="text" name="answer3" value="<?php echo isset($arr->answer3)?$arr->answer3:""; ?>" required class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Đáp án 4</div>
							<div class="col-md-10">
								<input type="text" name="answer4" value="<?php echo isset($arr->answer4)?$arr->answer4:""; ?>" required class="form-control">
							</div>
						</div>
					</div>
					<!-- end form group -->
					<!-- form group -->
					<div class="form-group">
						<div class="row">
							<div class="col-md-2 text-right">Đáp án đúng</div>
							<div class="col-md-10">
								<input type="text" name="answer" value="<?php echo isset($arr->answer)?$arr->answer:""; ?>" required class="form-control">
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