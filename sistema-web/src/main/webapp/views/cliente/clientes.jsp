<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request}" />
<c:set var="uriBase" value="${contextPath.requestURI}" />
<c:set value="${fn:split(uriBase,'/')}" var="separatorPosition" />
<c:set value="${separatorPosition[fn:length(separatorPosition)-1]}"
	var="jspPageName" />


<!-- DataTables -->
<link rel="stylesheet"
	href="assets/plugins/datatables/dataTables.bootstrap.css">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="jquery-waiting-base-container" style="display: none;">
		</div>
		<h1>
			<spring:message code="label.cliente.body.titulo" />
			<small> <spring:message code="label.cliente.small.titulo" />
			</small>
		</h1>
		<ol class="breadcrumb">
			<li>
				<!-- 				<button type="button" id="js-cliente-novo-button" --> <!-- 					class="btn btn-primary" data-toggle="modal" -->
				<!-- 					data-target="#clienteFormModal"> --> <%-- 					<spring:message code="label.novo" /> --%>
				<!-- 				</button> -->
			</li>
		</ol>


	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">

				<div class="box">
					<!-- /.box-header -->
					<div class="box-body">

						<ul class="nav nav-tabs">
							<li style="float: right">
								<button type="button" id="js-cliente-novo-button"
									class="btn btn-primary" data-toggle="modal"
									data-target="#clienteFormModal">
									<spring:message code="label.novo" />
								</button>
							</li>
							<li class="active"><a href="#cliente-pesquisa-tab"
								data-toggle="tab">Pesquisa </a></li>
							<li><a href="#cliente-cadastro-tab" data-toggle="tab">Cadastro</a></li>
						</ul>

						<div class="tab-content">
							<div class="tab-pane active in" id="cliente-pesquisa-tab">
								<br />
								<jsp:include page="/views/cliente/pesquisa.jsp" />
							</div>
							<div class="tab-pane" id="cliente-cadastro-tab">
								<br />
								<jsp:include page="/views/cliente/cadastro.jsp" />
							</div>
						</div>
					</div>
				</div>
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>

<!-- DataTables colocar na pagina cliente-->
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.min.js"></script>

<!-- Cliente -->
<script src="assets/dist/js/pages/cliente/clienteValidaForm.js"></script>
<script src="assets/dist/js/pages/cliente/clientes.js"></script>

<!-- Endereco -->
<script src="assets/dist/js/pages/enderecos.js"></script>

<!-- typeahead -->
<script src="assets/dist/js/bootstrap3-typeahead.js"></script>
<script src="assets/dist/js/bootstrap3-typeahead.min.js"></script>
<!-- Configuraçoes gerais -->
<script src="assets/dist/js/sistema.web.config.js"></script>


