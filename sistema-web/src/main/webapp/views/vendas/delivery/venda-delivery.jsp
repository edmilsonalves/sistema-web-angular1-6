<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request}" />
<c:set var="uriBase" value="${contextPath.requestURI}" />
<c:set value="${fn:split(uriBase,'/')}" var="separatorPosition" />
<c:set value="${separatorPosition[fn:length(separatorPosition)-1]}" var="jspPageName" />


<!-- DataTables -->
<link rel="stylesheet" href="assets/plugins/datatables/dataTables.bootstrap.css">

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


   <section class="content-header">
      <div class="jquery-waiting-base-container" style="display: none;"></div>
      <h1 style="font: bold 14px Tahoma, Geneva, sans-serif">
         <img alt="Controle de vendas Delivery" src="assets/dist/icones/venda-delivery.png" width="80" height="40">
         Vendas Delivery
      </h1>
      <ol class="breadcrumb">
         <li></li>
      </ol>

   </section>

   <!-- Main content -->
   <section class="content">
      <div class="row">
         <div class="col-md-12">

            <div class="box">
               <!-- /.box-header -->
               <div class="box-body">
                  <div id="div-pedidos">
                     <jsp:include page="/views/vendas/delivery/pedidos.jsp" />
                  </div>
                  <div id="div-pedido" style="display: none;">
                     <jsp:include page="/views/vendas/delivery/pedido.jsp" />
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

<!-- Vendas Delivery -->
<script src="assets/dist/js/pages/vendas/delivery/venda-delivery.js"></script>

<script src="assets/dist/js/jquery.tabletojson.js"></script>


<script src="assets/dist/js/sistema.web.config.js"></script>
