<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>UC Berkeley Cafeteria</title>
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/sortable', file: 'bootstrap-sortable.css')}" type="text/css">
		<g:javascript src="js-lib/bootstrap-3.3.4-dist/sortable/moment.min.js"/>
		<g:javascript src="js-lib/bootstrap-3.3.4-dist/sortable/bootstrap-sortable.js"/>
		<g:javascript src="store/store.js"/>
	</head>
	<body>
		<div class="container" style="padding-top:80px;">
			<h1>Point of Sale System</h1>
			<applicationTag:success success="${flash.success}"/>
			<div class="panel panel-default">
				<!-- Tab panes -->
				<div class="panel-body tab-content">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#outstanding"
							aria-controls="outstanding" role="tab" data-toggle="tab">Pending Orders</a></li>
						<li role="presentation"><a href="#completed"
							aria-controls="completed" role="tab" data-toggle="tab">Completed Orders</a></li>
						<li role="presentation"><a href="#missed"
							aria-controls="missed" role="tab" data-toggle="tab">Missed Orders</a></li>
					</ul>
					<div role="tabpanel" class="tab-pane active" id="outstanding">
						<g:render template="/order/templates/orders" model="['orders':outstanding, 'addActions':true]"/>
					</div>
					<div role="tabpanel" class="tab-pane" id="completed">
						<g:render template="/order/templates/orders" model="['orders':completed, 'addActions':false]"/>
					</div>
					<div role="tabpanel" class="tab-pane" id="missed">
						<g:render template="/order/templates/orders" model="['orders':missed, 'addActions':false]"/>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>