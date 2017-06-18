<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table id="ultimos-pedidos-table" class="table table-bordered table-striped cor-cabecalho" style="margin-top:-15px;">
   <thead>
      <tr>
         <th class="text-center">Nº PEDIDO</th>
         <th>DATA</th>
         <th>TX.ENTREGA</th>
         <th>DESCONTO</th>
      </tr>
   </thead>
   <tbody class="ultimos-pedidos-table-body"></tbody>
</table>

