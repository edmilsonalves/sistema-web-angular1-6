<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Modal HTML Markup -->
<div id="adicionalModal" class="modal tam-30" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">

         <div class="modal-header div-titulo-pagina">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1 class="modal-title titulo-font">Adicionais Disponíveis</h1>
         </div>
         <div class="modal-body">


            <form id="adicional-form" role="form">
               <input type="hidden" id="input-hidden-adicional-id" name="id">

               <div class="box-body">
                  <div class="row">
                     <div class="col-md-5">
                        <label for="input-adicional-nome"> Nome * </label>
                        <div class="input-group">
                           <input id="input-adicional-nome" name="descricao" class="form-control caixa_alta"
                              type="text" placeholder="Digite o nome do adicional" />
                        </div>
                     </div>
                     <div class="col-md-7">
                        <label for="input-adicional-preco"> Preço * </label>
                        <div class="input-group">
                           <input id="input-adicional-preco" name="preco" class="form-control text-right  moeda"
                              type="text" placeholder="Digite o preço do adicional" />
                           <div class="input-group-btn">
                              <button id="btn-add-adicional" type="button"
                                 class="btn btn-primary glyphicon glyphicon-plus">Add</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <br />
                  <div class="row">
                     <div class="col-md-12">
                        <div class="alert alert-danger msg-error-adicional" style="display: none;"></div>

                        <table id='adicional-table' class='table table-bordered table-striped cor-cabecalho padding-4'>
                           <thead>
                              <tr>
                                 <th>Descrição</th>
                                 <th>Preço</th>
                                 <th></th>
                              </tr>
                           </thead>
                           <tbody class="adicional-table-body"></tbody>
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