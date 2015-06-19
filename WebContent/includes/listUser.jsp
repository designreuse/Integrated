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
	<div class="col-sm-8">
		<div class="title-action">
			<a href="UserController?action=insert" class="btn btn-primary">Add User</a>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<div class="animated fadeInRightBig">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>User Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>DOB</th>
							<th>Email</th>
							<th colspan=2>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td><c:out value="${user.userid}" /></td>
								<td><c:out value="${user.firstName}" /></td>
								<td><c:out value="${user.lastName}" /></td>
								<td><fmt:formatDate pattern="yyyy-MMM-dd"
										value="${user.dob}" /></td>
								<td><c:out value="${user.email}" /></td>
								<td><a
									href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a>
								</td>
								<td><a
									href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>