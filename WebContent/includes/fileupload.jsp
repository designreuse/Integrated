<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<h2>Dashboard</h2>
		<ol class="breadcrumb">
			<li><a href="index.html">This is</a></li>
			<li class="active"><strong>Category</strong></li>
		</ol>
	</div>
</div>
<div class="col-lg-12">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<h5>File Upload</h5>
			<div class="ibox-tools">
				<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
				</a>
			</div>
		</div>
		<div class="ibox-content">
			<form class="form-horizontal" enctype = "multipart/form-data" method ="post" action = "FileUpload">
				<div class="form-group">
					<label class="col-lg-2 control-label">Name</label>

					<div class="col-lg-10">
						<input type="text" name = "fullname"  class="form-control" placeholder="Full Name">						
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label">Choose File</label>

					<div class="col-lg-10">
						<input type="file" class="form-control" name = "file_name">						
					</div>
				</div>				
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" class="btn btn-sm btn-success" value="Save">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>