<!DOCTYPE html>
<html lang="en" data-ng-app="app">
<head>
<meta charset="utf-8" />
<title>Web Project</title>
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/fonts.*" type="text/css" />

<link rel="stylesheet" href="vendor/bootstrap/css/dcalendar.picker.css"/>

<link rel="stylesheet" href="css/app.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<!-- <link rel="stylesheet" href="css/fonts.css" type="text/css" /> -->
</head>
<body ng-app="app">
	<div ng-view></div>
	<div ng-include="commonviews/page_footer.html"></div>
	<!--Angular   -->
	<script src="vendor/angular/angular.min.js"></script>
	<script src="vendor/angular/angular-resource.min.js"></script>
	<script src="vendor/angular/angular-route.min.js"></script>
	<script src="vendor/angular/angular-cookies.min.js"></script>

	<!-- jquery -->
	<script src="vendor/jquery/jquery-1.11.1.js"></script>
	<!-- bootstrap -->
	<script src="vendor/bootstrap/js/bootstrap.js"></script>
	<!-- App -->
	<script src="js/app/app.js"></script>
	<script src="js/app/common.js"></script>
	<script src="js/controllers/homeController.js"></script>
	<script src="js/controllers/signinController.js"></script>
	<script src="js/controllers/signupController.js"></script>
	
	<!--dcalendar -->
	<script type="text/javascript" src="js/utils/dcalendar.picker.js"></script>
	<script>
		
	</script>
</body>
</html>