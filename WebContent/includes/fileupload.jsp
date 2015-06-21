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
			<form class="form-horizontal" enctype="multipart/form-data"
				method="post" action="FileUpload">
				<div class="form-group">
					<label class="col-lg-2 control-label">Name</label>

					<div class="col-lg-10">
						<input type="text" name="fullname" class="form-control"
							placeholder="Full Name">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label">Choose File</label>

					<div class="col-lg-10">
						<input type="file" class="form-control" name="file_name">
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
	<h1><%= request.getAttribute("success") %></h1>
</div>
<script
	src="${pageContext.request.contextPath}/assets/admintheme/js/plugins/toastr/toastr.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){				
		var tosttrigger='${success}';
		alert(tosttrigger);
		if(tosttrigger!=null){
			$( "#showtoast" ).click();
		}
		var i = -1;
		var toastCount = 0;
		var $toastlast;
		var getMessage = function() {
			var msg = '${success}';
			return msg;
		};

		$('#showsimple').click(function() {
			// Display a success toast, with a title
			toastr.success('Without any options', 'Simple notification!')
		});
		$('#showtoast')
				.click(
						function() {
							var shortCutFunction = $(
									"#toastTypeGroup input:radio:checked")
									.val();
							var msg = $('#message').val();
							var title = $('#title').val() || '';
							var $showDuration = $('#showDuration');
							var $hideDuration = $('#hideDuration');
							var $timeOut = $('#timeOut');
							var $extendedTimeOut = $('#extendedTimeOut');
							var $showEasing = $('#showEasing');
							var $hideEasing = $('#hideEasing');
							var $showMethod = $('#showMethod');
							var $hideMethod = $('#hideMethod');
							var toastIndex = toastCount++;
							toastr.options = {
								closeButton : $('#closeButton').prop('checked'),
								debug : $('#debugInfo').prop('checked'),
								progressBar : $('#progressBar').prop('checked'),
								positionClass : $(
										'#positionGroup input:radio:checked')
										.val()
										|| 'toast-top-right',
								onclick : null
							};
							if ($('#addBehaviorOnToastClick').prop('checked')) {
								toastr.options.onclick = function() {
									alert('You can perform some custom action after a toast goes away');
								};
							}
							if ($showDuration.val().length) {
								toastr.options.showDuration = $showDuration
										.val();
							}
							if ($hideDuration.val().length) {
								toastr.options.hideDuration = $hideDuration
										.val();
							}
							if ($timeOut.val().length) {
								toastr.options.timeOut = $timeOut.val();
							}
							if ($extendedTimeOut.val().length) {
								toastr.options.extendedTimeOut = $extendedTimeOut
										.val();
							}
							if ($showEasing.val().length) {
								toastr.options.showEasing = $showEasing.val();
							}
							if ($hideEasing.val().length) {
								toastr.options.hideEasing = $hideEasing.val();
							}
							if ($showMethod.val().length) {
								toastr.options.showMethod = $showMethod.val();
							}
							if ($hideMethod.val().length) {
								toastr.options.hideMethod = $hideMethod.val();
							}
							if (!msg) {
								msg = getMessage();
							}
							$("#toastrOptions").text(
									"Command: toastr["
											+ shortCutFunction
											+ "](\""
											+ msg
											+ (title ? "\", \"" + title : '')
											+ "\")\n\ntoastr.options = "
											+ JSON.stringify(toastr.options,
													null, 2));
							var $toast = toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
							$toastlast = $toast;
							if ($toast.find('#okBtn').length) {
								$toast.delegate('#okBtn', 'click', function() {
									alert('you clicked me. i was toast #'
											+ toastIndex + '. goodbye!');
									$toast.remove();
								});
							}
							if ($toast.find('#surpriseBtn').length) {
								$toast
										.delegate(
												'#surpriseBtn',
												'click',
												function() {
													alert('Surprise! you clicked me. i was toast #'
															+ toastIndex
															+ '. You could perform an action here.');
												});
							}
						});
		function getLastToast() {
			return $toastlast;
		}
		$('#clearlasttoast').click(function() {
			toastr.clear(getLastToast());
		});
		$('#cleartoasts').click(function() {
			toastr.clear();
		});
	});
</script>