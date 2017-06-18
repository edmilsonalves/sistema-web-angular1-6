<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
   <div class="col-md-4">
      <button id="btn-novo-pedido" type="button" class="btn btn-primary btn">
         <span class="glyphicon glyphicon-plus"></span>
         NOVO PEDIDO
      </button>
   </div>
</div>

<br />

<table id="produto-table" class="table table-bordered table-striped cor-cabecalho">
   <thead>
      <tr>
         <th class="text-center">PEDIDO</th>
         <th>DESCRIÇÃO</th>
         <th>INICIADO EM</th>
         <th>DURAÇÃO</th>
         <th>CLIENTE</th>
         <th>TELEFONE</th>
         <th>ENDEREÇO</th>
         <th>STATUS</th>
         <th class="text-center">PAGO?</th>
         <th class="text-center">TOTAL</th>
      </tr>
   </thead>
   <tbody class="produto-table-body"></tbody>
</table>
<br />
<br />

<div class="box-footer">
   <div class="btn-group mr-2" role="group" aria-label="Second group">
      <a class="fontSize" href="dashboard.html"> Paine de Controle </a>
   </div>
</div>