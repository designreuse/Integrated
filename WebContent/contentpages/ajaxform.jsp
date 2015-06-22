<div class="row">
	<div class="col-lg-10">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>Horizontal form</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a href="#" data-toggle="dropdown" class="dropdown-toggle"> <i
						class="fa fa-wrench"></i>
					</a>
				</div>
			</div>
			<div class="ibox-content">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-2 control-label">District</label>

						<div class="col-lg-10">
							<select name="district" class="form-control" id="district">
								<option value="">--select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">VDC</label>
						<div class="col-lg-10">
							<select name="vdc" id="vdc" class="form-control">
								<option value="">--select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Population</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" name="population" placeholder="population">
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" class="btn btn-sm btn-success" value="Submit">								
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#district").bind('change',function(){
			var district = $("#district").val();
			$.ajax({
				type :'POST',
				url ='AjaxCall',
				data : {district:district},
				success:function(msg){
					
				}
			});
		});
	});
</script>