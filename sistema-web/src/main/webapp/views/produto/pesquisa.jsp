<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
   <div class="col-md-4">
      <div class="input-group">
         <div>
            <input type="search" class="form-control" id="pesquisa-produto" placeholder="Pesquise aqui">
         </div>
         <div>
            <input type="checkbox" id="checkbox-produto-ativo">
            Incluir inativos na consulta
         </div>
      </div>
   </div>




   <div class="col-md-8 text-right">
      <button type="button" id="bt-produto-novo"
         class="btn btn-primary bt-produto-novo glyphicon glyphicon-plus" data-toggle="modal"
         data-target="#clienteFormModal">
         <spring:message code="label.novo" />
      </button>
   </div>
</div>

<table id="produto-table" class="table table-bordered table-striped cor-cabecalho padding-4">
   <thead>
      <tr>
         <th class="text-center">CÓD BUSCA</th>
         <th>
            NOME
         </th>
         <th>
            ESTOQUE ATUAL
         </th>
         <th>
            ALERTA ESTOQUE
         </th>
         <th>
            SISUAÇÃO DO ESTOQUE
         </th>
         <th>PÇ VENDA</th>
         <th>PÇ CUSTO</th>
         <th class="text-center">ATIVO</th>
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