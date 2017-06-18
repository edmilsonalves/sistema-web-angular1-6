<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request}" />
<c:set var="uriBase" value="${contextPath.requestURI}" />
<c:set value="${fn:split(uriBase,'/')}" var="separatorPosition" />
<c:set value="${separatorPosition[fn:length(separatorPosition)-1]}" var="jspPageName" />

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style type="text/css">
span.adicional-disponivels {
	width: -50px !important;
}

.success {
	color: #4F8A10;
	background-color: #DFF2BF;
}
</style>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
   <!-- Content Header (Page header) -->
   <section class="content-header">
      <div class="jquery-waiting-base-container" style="display: none;"></div>
      <h1 style="font: bold 14px Tahoma, Geneva, sans-serif">
         <img alt="Gerenciar produtos" src="assets/dist/icones/produtos.png" width="30" height="30">
         GERENCIAR PRODUTOS
      </h1>
      <ol class="breadcrumb">
         <li></li>
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
                        <!--                         <button type="button" id="bt-produto-novo" class="btn btn-primary bt-produto-novo" -->
                        <!--                            data-toggle="modal" data-target="#clienteFormModal"> -->
                        <%--                            <spring:message code="label.novo" /> --%>
                        <!--                         </button> -->
                     </li>
                     <li class="active">
                        <a class="glyphicon glyphicon-search" href="#produto-pesquisa-tab" data-toggle="tab">
                           Pesquisa </a>
                     </li>
                     <li>
                        <a class="fa fa-product-hunt" href="#produto-cadastro-tab" data-toggle="tab">
                           Cadastro </a>
                     </li>
                     <li>
                        <a href="#produto-observacoes-tab" data-toggle="tab">Observações</a>
                     </li>
                  </ul>

                  <div class="tab-content">
                     <div class="tab-pane active in" id="produto-pesquisa-tab">
                        <br />
                        <jsp:include page="/views/produto/pesquisa.jsp" />
                     </div>
                     <div class="tab-pane" id="produto-cadastro-tab">
                        <br />
                        <jsp:include page="/views/produto/cadastro.jsp" />
                     </div>
                     <div class="tab-pane" id="produto-observacoes-tab">
                        <br />
                        <jsp:include page="/views/produto/cadastro-obs-adicionais.jsp" />
                     </div>
                  </div>
               </div>
            </div>
            <!-- /.box -->
         </div>
         <!-- /.col -->
      </div>
      <!-- /.row -->

      <jsp:include page="/views/produto/include/categoria-modal.jsp" />
      <jsp:include page="/views/produto/include/adicional-modal.jsp" />
      <jsp:include page="/views/produto/include/unidade-medida-modal.jsp" />
   </section>
   <!-- /.content -->
</div>

<!-- Produto -->
<script src="assets/dist/js/pages/produto/produtoValidaForm.js"></script>
<script src="assets/dist/js/pages/produto/produtos.js"></script>
<script src="assets/dist/js/pages/observacao/observacoes.js"></script>
<script src="assets/dist/js/pages/observacao/observacoesValidaForm.js"></script>
<script src="assets/dist/js/pages/categoria/categorias.js"></script>
<script src="assets/dist/js/pages/categoria/categoriaValidaForm.js"></script>
<script src="assets/dist/js/pages/adicional/adicionais.js"></script>
<script src="assets/dist/js/pages/adicional/adicionalValidaForm.js"></script>
<script src="assets/dist/js/pages/unidademedida/unidadeMedida.js"></script>
<script src="assets/dist/js/pages/unidademedida/unidadeMedidaValidaForm.js"></script>

<script src="assets/dist/js/sistema.web.config.js"></script>
