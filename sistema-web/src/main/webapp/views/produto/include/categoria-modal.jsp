<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Modal HTML Markup -->
<div id="categoriaModal" class="modal tam-30" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">

         <div class="modal-header div-titulo-pagina">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1 class="modal-title titulo-font">Categorias</h1>
         </div>
         <div class="modal-body">


            <form id="categoria-form" role="form">
               <input type="hidden" id="input-hidden-categoria-id" name="id">

               <!--                <div id="msg-categoria-sucesso" class="alert alert-success" style="display: none">Registro -->
               <!--                   salvo com sucesso!</div> -->

               <div class="box-body">
                  <div class="row">
                     <div class="col-md-12">

                        <div class="form-group">
                           <label for="input-categoria-nome"> Nome * </label>
                           <div class="input-group">
                              <div>
                                 <input id="input-categoria-nome" name="descricao"
                                    class="form-control input-sm caixa_alta" type="text"
                                    placeholder="Digite..." />
                              </div>
                              <span id="link-add-categoria" class="input-group-addon"
                                 style="cursor: pointer; background-color: #3c8dbc;">
                                 <a href="#" title="Digite a descrição da observação">
                                    <span class="glyphicon glyphicon-plus" style="color: #fff;">Add</span>
                                 </a>
                              </span>
                           </div>
                        </div>
                     </div>
                  </div>
                  <br />
                  <div class="row">
                     <div class="col-md-12">
                        <div class="alert alert-danger msg-error-categoria" style="display: none;"></div>
                        <table id='categoria-table' class='table table-bordered table-striped cor-cabecalho padding-4'>
                           <thead>
                              <tr>
                                 <th style="border: none;">Descrição</th>
                                 <th style="border: none;"></th>
                              </tr>
                           </thead>
                           <tbody class="categoria-table-body"></tbody>
                        </table>

                     </div>
                  </div>
               </div>
               <!-- /.box-body -->

               <!--                <div class="box-footer"> -->
               <!--                   <div id="div_excluir_cliente" style="display: none;" class="col-xs-8 .col-sm-4"> -->
               <!--                      <div class="alert alert-danger"> -->
               <!--                         <strong> -->
               <%--                            <spring:message code="label.cliente.atencao" /> --%>
               <!--                         </strong> -->
               <%--                         <spring:message code="msg.cliente.confirmacao" /> --%>
               <!--                      </div> -->
               <!--                      <button id="js-cliente-sim-button" type="button" -->
               <!--                         class="btn btn btn-primary glyphicon glyphicon-ok"> -->
               <%--                         <spring:message code="label.sim" /> --%>
               <!--                      </button> -->
               <!--                      <button id="js-cliente-nao-button" type="button" -->
               <!--                         class="btn btn-secondary glyphicon glyphicon-remove"> -->
               <%--                         <spring:message code="label.nao" /> --%>
               <!--                      </button> -->
               <!--                   </div> -->
               <!--                </div> -->
               <!-- /.box-footer -->
            </form>

         </div>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<!-- /.modal -->