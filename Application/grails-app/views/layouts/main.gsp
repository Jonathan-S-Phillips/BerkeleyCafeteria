<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="SmartCaseLaw"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/css', file: 'bootstrap.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/css', file: 'sticky-footer.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/css', file: 'custom-navbar.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<asset:javascript src="application.js"/>
		<g:javascript src="js-lib/jQuery/jquery-1.11.2.min.js"/>
		<g:javascript src="js-lib/bootstrap-3.3.4-dist/js/bootstrap.js"/>
		<g:layoutHead/>
	</head>
	<body>
		<g:render template="/layouts/templates/header" />
		<g:layoutBody/>
		<g:render template="/layouts/templates/footer" />
	</body>
</html>
