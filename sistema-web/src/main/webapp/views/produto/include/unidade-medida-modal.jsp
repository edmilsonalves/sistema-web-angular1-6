<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Modal HTML Markup -->
<div id="unidade-medidaModal" class="modal tam-30" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">

         <div class="modal-header div-titulo-pagina">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1 class="modal-title titulo-font">Unidade Medidas</h1>
         </div>
         <div class="modal-body">

            <form id="unidade-medida-form" role="form">
               <input type="hidden" id="input-hidden-unidade-medida-id" name="id">
               <div class="box-body">
                  <div class="row">
                     <div class="col-md-8">
                        <label for="input-unidade-medida-nome"> Nome * </label>
                        <div class="input-group">
                           <input id="input-unidade-medida-nome" name="descricao"
                              class="form-control caixa_alta" type="text"
                              placeholder="Digite o nome da unidade medida" />
                           <div class="input-group-btn">
                              <button id="btn-add-unidade-medida" type="button"
                                 class="btn btn-primary glyphicon glyphicon-plus">Add</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <br />
                  <div class="row">
                     <div class="col-md-12">
                     <div class="alert alert-danger msg-error-unidade-medida" style="display: none;"></div>
                        <table id='unidade-medida-table'
                           class='table table-bordered table-striped cor-cabecalho padding-4'>
                           <thead>
                              <tr>
                                 <th style="border: none;">Descrição</th>
                                 <th style="border: none;"></th>
                              </tr>
                           </thead>
                           <tbody class="unidade-medida-table-body"></tbody>
                        </table>

                     </div>
                  </div>
               </div>
               <!-- /.box-body -->
            </form>
         </div>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<!-- /.modal -->