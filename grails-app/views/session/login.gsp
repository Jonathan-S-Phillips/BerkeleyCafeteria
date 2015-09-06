<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>UC Berkeley Cafeteria</title>
	</head>
	<body>
		<div class="container" style="padding-top:80px;">
			<applicationTag:error error="${flash.error}"/>
			<g:form controller="session" action="processLogin">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="form-login panel panel-default">
						<div class="panel-body">
							<h4>Log In</h4>
							<g:textField id="userName" name="userName" 
								class="form-control input-sm chat-input" placeholder="Username" /><br/>
							<g:passwordField id="password" name="password" 
								class="form-control input-sm chat-input" placeholder="Password" /><br/>
							<div class="wrapper">
								<span class="group-btn"> <input type="submit"
									class="btn btn-primary btn-md btn-block" value="Log In">
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</g:form>
		</div>
	</body>
</html>