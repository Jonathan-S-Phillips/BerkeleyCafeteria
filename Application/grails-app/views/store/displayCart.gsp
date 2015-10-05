<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>UC Berkeley Cafeteria</title>
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/jQuery/pickadate', file: 'default.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/jQuery/pickadate', file: 'default.date.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/jQuery/pickadate', file: 'default.time.css')}" type="text/css">
		<g:javascript src="js-lib/jQuery/jquery-ui-1.11.0.js"/>
		<g:javascript src="js-lib/jQuery/jquery.blockUI.js"/>
		<g:javascript src="js-lib/jQuery/pickadate/picker.js"/>
		<g:javascript src="js-lib/jQuery/pickadate/picker.date.js"/>
		<g:javascript src="js-lib/jQuery/pickadate/picker.time.js"/>
		<g:javascript src="js-lib/accounting.min.js"/>
		<g:javascript src="js-lib/date.js"/>
		<g:javascript src="store/store.js"/>
	</head>
	<body>
		<nav class="navbar" style="padding-top:50px;">
			<div class="container-fluid">
				<div id="navbar" class="navbar-collapse collapse center">
					<storeTag:stores/>
				</div>
			</div>
		</nav>
		<div id="checkout" class="popupWindow">
			<g:render template="/store/templates/checkout"/>
		</div>
		<div class="container">
			<h2>Order Food Online & Schedule Pickup Time</h2>
			<applicationTag:success success="${flash.success}"/>
			<applicationTag:error error="${flash.error}"/>
			<div id="error" style="visibility:hidden;"></div>
			<div id="cart" class="panel panel-default">
				<g:render template="/store/templates/cart" model="['displayQuantityField':true]"/>
			</div>
			<div class="pull-right">
				<g:link controller="session" action="index" class="btn btn-default" role="button">
					Continue Shopping
				</g:link>
				<g:link url="#" class="btn btn-default" role="button" onclick="checkout();">
					Checkout
				</g:link>
			</div>
		</div><br/>
		<script>
			var contextPath = "${request.contextPath}";
			var total = parseInt("${order.cafeteriaOrderMenuItems?.size()}");
		</script>
	</body>
</html>