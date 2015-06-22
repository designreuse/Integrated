<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<h2>Dashboard</h2>
		<ol class="breadcrumb">
			<li><a href="index.html">This is</a></li>
			<li class="active"><strong>Category</strong></li>
		</ol>
	</div>

</div>
<div class="row">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<div class="animated fadeInRightBig">
				<form method="POST" class="form-horizontal" action='UserController'
					name="frmAddUser">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-1">
									<div class="form-group">
										<label class="col-md-12 control-label" for="project">User
											Id </label>
										<div class="col-md-12">
											<input type="text" name="userid" readonly="readonly"
												class="form-control"
												value="<c:out value="${user.userid}" />" id="userid">
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label class="col-md-12 control-label" for="project">First
											Name</label>
										<div class="col-md-12">
											<input type="text" name="firstName" class="form-control"
												value="<c:out value="${user.firstName}" />" required="required" id="firstName">
										</div>
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<label class="col-md-12 control-label" for="station">Last
											Name</label>
										<div class="col-md-12">
											<input type="text" name="lastName" class="form-control"
												value="<c:out value="${user.lastName}" />" required="required" id="lastName">
										</div>
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<label class="col-md-12 control-label" for="year">DOB</label>
										<div class="col-md-12">
											<input type="text" name="dob" required="required" class="form-control"
												value="<fmt:formatDate pattern="dd/MM/yyyy" value="${user.dob}" />" />
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label class="col-md-12 control-label" for="year">Email</label>
										<div class="col-md-12">
											<input type="text" required="required" name="email" class="form-control"
												value="<c:out value="${user.email}" />" />
										</div>
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>&nbsp;</label> <label>&nbsp;</label> <label>&nbsp;</label>
										<label>&nbsp;</label> <label>&nbsp;</label> <label>&nbsp;</label>										
										<input class="btn btn-success" type="submit" value="Submit" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>