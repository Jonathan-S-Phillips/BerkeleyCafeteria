<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>UC Berkeley Cafeteria</title>
		<g:javascript src="store/store.js"/>
	</head>
	<body>
		<nav class="navbar" style="padding-top:50px;">
			<div class="container-fluid">
				<div id="navbar" class="navbar-collapse collapse center">
					<storeTag:stores active="1"/>
				</div>
			</div>
		</nav>
		<div class="container">
			<h2>Order Food Online & Schedule Pickup Time</h2>
			<applicationTag:success success="${flash.success}"/>
			<applicationTag:error error="${flash.error}"/>
			<div class="panel panel-default">
				<div class="panel-body">
					<ul class="media-list">
						<storeTag:menuItems menuItems="${store.menuItems}"/>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>