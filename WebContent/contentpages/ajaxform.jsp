<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="display: none" id="alertdiv"
	class="alert alert-success alert-dismissable col-md-10">
	<button type="button" class="close" data-dismiss="alert"
		aria-hidden="true">×</button>
		Successfully Added Population !!
</div>
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
			<%-- 			 <h2>${distlist}</h2>						 --%>
			<div class="ibox-content">
				<form class="form-horizontal" id="ajaxform">
					<div class="form-group">
						<label class="col-lg-2 control-label">District</label>

						<div class="col-lg-10">
							<select name="district" class="form-control" id="district">
								<option value="">--select--</option>
								<c:forEach items="${distlist}" var="dist">
									<option value="${dist.dist_id}">${dist.dist_name}</option>
								</c:forEach>
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
							<input type="text" class="form-control" name="population"
								placeholder="population">
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" class="btn btn-sm btn-success"
								value="Submit">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	function show_message(message,type){
		toastr.options = {
	            closeButton: true,
	            progressBar: true,
	            showMethod: 'fadeIn',
	            timeOut: 4000
	        };
		if(type ==1){
			toastr.success(message);
		}else if(type ==0){
			toastr.error(message);
		}else {
			toastr.warning(message);
		}
	}
	
	$(document).ready(
			function() {
				$("#district").bind('change', function() {
					var district = $("#district").val();
					$.ajax({
						type : 'POST',
						url : 'AjaxCall',
						data : {
							district : district,
							action : "getvdc"
						},
						success : function(msg) {
							$("#vdc").html(msg);
						}
					});
				});
				$("#ajaxform").submit(
						function(event) {
							event.preventDefault();
							var formdata = $("#ajaxform").serialize()
									+ "&action=savepopulation";
							$.ajax({
								type : 'POST',
								url : 'AjaxCall',
								data : formdata,
								success : function(msg) {
									if (msg == 1) {										
										//$("#alertdiv").show();
										show_message("SuccessFully added Data",1)
										$("#ajaxform")[0].reset();
									} else {
										show_message("error while adding Data",0)
									}
								}
							});
						});
			});
</script>