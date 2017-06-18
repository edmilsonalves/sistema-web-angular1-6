<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form id="observacoes-form" role="form">
   <input type="hidden" id="input-hidden-obs-id" name="id">
   <div class="box-body">
      <div class="row">

         <div class="alert alert-danger msg-error-observacao" style="display: none;"></div>
         <div class="alert alert-success msg-sucesso-observacao" style="display: none;"></div>
         <div class="col-md-4">

            <div class="form-group">
               <label for="select-observacao-produto-categoria">
                  <spring:message code="label.produto.categoria" />
                  *
               </label>
               <div class="input-group">
                  <span id="link-observacao-categoria-novo" class="input-group-addon"
                     style="cursor: pointer; background-color: #3c8dbc;">
                     <a href="#" title="Clique para adicionar uma nova categoria">
                        <span class="glyphicon glyphicon-plus" style="color: #fff;"></span>
                     </a>
                  </span>
                  <div>
                     <select id="select-observacao-produto-categoria" name="categoriaProduto[id]"
                        class="selectpicker form-control input-sm">
                        <option value=""></option>
                     </select>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md-4">

            <div class="form-group">
               <label for="input-observacao-nome"> Nome * </label>
               <div class="input-group">
                  <div>
                     <input id="input-observacao-nome" name="descricao" class="form-control input-sm caixa_alta"
                        type="text" placeholder="Digite..." />
                  </div>
                  <span id="link-produto-observacao" class="input-group-addon"
                     style="cursor: pointer; background-color: #3c8dbc;">
                     <a href="#" title="Digite a descrição da observação">
                        <span class="glyphicon glyphicon-floppy-disk" style="color: #fff;">Salvar</span>
                     </a>
                  </span>
               </div>
            </div>
         </div>
      </div>
      <div class="row">
         <div class="col-md-8">

            <table id='observacao-table' class='table table-bordered table-striped cor-cabecalho padding-4'>
               <thead>
                  <tr>
                     <th>DESCRIÇÃO</th>
                     <th>CATEGORIA</th>
                     <th></th>
                  </tr>
               </thead>
               <tbody class="observacao-table-body"></tbody>
            </table>

         </div>
      </div>
   </div>
   <!-- /.box-body -->
</form>
