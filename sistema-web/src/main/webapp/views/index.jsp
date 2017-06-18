<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html ng-app="primeiraApp">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Sistema Web</title>

<link rel="stylesheet" href="assets/dist/css/sistemaWeb.css">

<!-- Bootstrap 3.3.6 necessário para o tema-->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
<!-- Font Awesome necessário para o tema-->
<link rel="stylesheet" href="assets/plugins/font-awesome/font-awesome.min.css">
<!-- Ionicons necessário para o tema-->
<link rel="stylesheet" href="assets/plugins/ionicons/ionicons.min.css">

<!-- Theme style necessário para o tema-->
<link rel="stylesheet" href="assets/dist/css/AdminLTE.css">
<!-- Theme style necessário para o tema-->
<link rel="stylesheet" href="assets/dist/css/skins/skin-purple.min.css">

<link rel="stylesheet" href="assets/angular16/css/angular-toastr.min.css">




<!-- jQuery 3.2.0 necessário para o tema-->
<script src="assets/plugins/jQuery/jquery-3.2.0.min.js"></script>

<!-- Bootstrap 3.3.6 necessário para o tema-->
<script src="assets/bootstrap/js/bootstrap.min.js"></script>


<!-- AdminLTE App necessário para o tema-->
<script src="assets/dist/js/app.min.js"></script>

<!-- mascaras -->
<script src="assets/plugins/input-mask/jquery.maskedinput.min.js"></script>
<script src="assets/plugins/input-mask/jquery.mask.min.js"></script>

<!-- Configuraçoes gerais -->
<script src="assets/dist/js/sistema.web.config.js"></script>

<!-- Utils interno do sistema-->
<script src="assets/dist/js/utils.js"></script>

<script src="assets/dist/js/jquery-paginate.js"></script>



</head>
<!-- <body id="body-id" class="sidebar-mini wysihtml5-supported skin-purple sidebar-collapse" style="height: auto;"> -->
<body class="sidebar-mini wysihtml5-supported skin-purple">
   <div class="wrapper">
      <header class="main-header" ng-include="'./template/navigation.jsp'"></header>
      <aside class="main-sidebar" ng-include="'./template/menu.jsp'"></aside>
      <div class="content-wrapper" ui-view></div>
      <footer class="main-footer" ng-include="'./template/footer.jsp'"></footer>
   </div>

   <script src="assets/angular16/js/angular.min.js"></script>
   <script src="assets/angular16/js/angular-ui-router.js"></script>
   <script src="assets/angular16/js/angular-animate.min.js"></script>
   <script src="assets/angular16/js/angular-toastr.tpls.min.js"></script>
   <script src="assets/angular16/index.js"></script>
</body>
</html>