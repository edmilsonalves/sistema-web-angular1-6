<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form id="delivery-pedido-form" role="form">

   <input type="hidden" id="input-hidden-produto-id" name="id">
   <input type="hidden" id="input-hidden-estoque-id" name="estoque[id]">
   <input type="hidden" id="input-hidden-produto-nome-imagem" name="nomeImagem">
   <input type="hidden" id="input-hidden-path-imagem" name="pathImagem">

   <div class="box-body">

      <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
         <button id="btn-voltar" type="button" class="btn btn-primary btn">
            <span class="glyphicon glyphicon-arrow-left"></span>
            Voltar
         </button>
         <button type="button" class="btn btn-primary btn">
            <span class="glyphicon glyphicon-floppy-disk"></span>
            Salvar
         </button>

         <button type="button" class="btn btn-primary btn">
            <span class="glyphicon glyphicon-trash"></span>
            Excluir
         </button>

         <button type="button" class="btn btn-primary btn">
            <span class="glyphicon glyphicon-plus"></span>
            Novo
         </button>
         <button type="button" class="btn btn-primary btn">
            <span class="glyphicon glyphicon-list-alt"></span>
            Pagamento
         </button>
      </div>
      <br />
      <div class="alert alert-danger msg-error-produto" style="display: none;"></div>
      <div class="alert alert-success msg-sucesso-produto" style="display: none;"></div>

      <!--       <div class="alert alert-success"> -->
      <!--          <span class="glyphicon glyphicon-ok"></span> -->
      <!--          <strong class=" msg-sucesso-produto">Success Message</strong> -->
      <!--       </div> -->

      <div class="row">


         <div class="col-md-7 box-default">

            <div class="box box-primary">
               <div class="box-body">
                  <div class="col-md-12">




                     <div class="panel panel-default">
                        <div class="panel-heading">
                           <div class="row">
                              <div id="editar-pedido-id" class="col-md-4" style="display: none;">
                                 <label class="pedido-label">Pedido: </label>
                                 <label class="pedido-valor-label">1001</label>
                              </div>

                              <div id="novo-pedido-id" class="col-md-4">
                                 <label class="pedido-valor-label">Novo Pedido</label>
                              </div>

                              <div class="col-md-8">
                                 <div class="form-group">
                                    <label class="control-label col-sm-3 text-right"
                                       for="link-entregador-novo">Entregador</label>
                                    <div class="col-sm-9 text-right">
                                       <div class="input-group">
                                          <span id="link-entregador-novo" class="input-group-addon"
                                             style="cursor: pointer; background-color: #3c8dbc;">
                                             <a href="#" title="Clique para adicionar um novo entregador">
                                                <span class="glyphicon glyphicon-plus" style="color: #fff;"></span>
                                             </a>
                                          </span>
                                          <div>
                                             <select id="select-entregador" name="categoriaProduto[id]"
                                                class="selectpicker form-control input-sm">
                                                <option value=""></option>
                                             </select>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="panel-body">
                           <div class="col-md-6">
                              <label class="pedido-label">Subtotal: </label>
                              <label id="pedido-subtotal-label" class="pedido-valor-label">0</label>
                           </div>
                           <div class="col-md-6">
                              <label class="pedido-label">Entregador: </label>
                              <label class="pedido-valor-label">edmilson</label>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-md-12">
                     <div class="panel panel-default">
                        <div class="panel-heading">
                           <button id="btn-buscar-produto" type="button" class="btn btn-primary btn">
                              <span class="glyphicon glyphicon-search"></span>
                              Buscar produto
                           </button>
                        </div>
                        <div class="panel-body">
                           <form id="venda-delivery-pedido-form" role="form">
                              <input type="hidden" id="input-hidden-adicionar-produto-id" name="id">
                              <table id="pedido-table"
                                 class="table table-responsive table-bordered table-striped cor-cabecalho tabelaPedido">

                                 <thead>
                                    <th>&nbsp;</th>
                                    <th>CATEGORIA</th>
                                    <th>ITEM</th>
                                    <th class="text-right">ESTOQUE</th>
                                    <th class="text-right">PREÇO</th>
                                    <th class="text-right">SUBTOTAL</th>
                                    <th>&nbsp;</th>
                                 </thead>

                                 <tbody class="pedido-table-body">

                                 </tbody>
                              </table>
                           </form>
                        </div>
                        <div class="panel-footer">
                           <div class="row">
                              <div class="col-md-6">
                                 <label class="pedido-label">Taxa de Entrega: </label>
                                 <label class="pedido-valor-label">R$ 3,00</label>
                              </div>

                              <div class="col-md-6 text-right">
                                 <label class="pedido-label">Total a Pagar: </label>
                                 <label id="pedido-total-pagar-label" class="pedido-valor-label">0</label>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- /.box-body -->
            </div>
            <!-- /.box -->


         </div>
         <!-- /.col (left) -->
         <div class="col-md-5 box-default">
            <div class="box box-primary">
               <div class="box-body">
                  <ul class="nav nav-tabs">
                     <li style="float: right"></li>
                     <li class="active">
                        <a href="#delivery-cliente-tab" data-toggle="tab"> Delivery </a>
                     </li>
                     <li>
                        <a href="#delvery-ultimos-pedidos-tab" data-toggle="tab"> Ultimos Pedidos </a>
                     </li>
                  </ul>
                  <div class="tab-content">
                     <div class="tab-pane active in" id="delivery-cliente-tab">
                        <br />
                        <jsp:include page="/views/vendas/delivery/cliente.jsp" />
                     </div>
                     <div class="tab-pane" id="delvery-ultimos-pedidos-tab">
                        <br />
                        <jsp:include page="/views/vendas/delivery/ultimos-pedidos.jsp" />
                     </div>
                  </div>
                  <!-- /.box-body -->
               </div>
               <!-- /.box-body -->
            </div>
            <!-- /.box -->
         </div>
         <!-- /.col (right) -->
      </div>
      <!-- /.row -->

   </div>
   <!-- /.box-body -->
</form>

<jsp:include page="/views/vendas/delivery/include/buscar-produto-modal.jsp" />
<jsp:include page="/views/vendas/delivery/include/cadastro-funcionario-modal.jsp" />

<div class="box-footer">
   <div class="btn-group mr-2" role="group" aria-label="Second group">
      <a class="fontSize" href="dashboard.html"> Paine de Controle </a>
   </div>
</div>

<!-- Modal -->
<div class="modal" id="modalConfimaExclusao" role="dialog">
   <div class="modal-dialog modal-sm">
      <div class="modal-content">
         <div class="modal-header">
            <h4 class="modal-title">Atenção</h4>
         </div>
         <div class="modal-body">
            <p>Deseja realmente excluir o registro?</p>
         </div>
         <div class="modal-footer">
            <button id="produto-confirme-sim-excluir-button" type="button"
               class="btn btn btn-primary glyphicon glyphicon-ok" data-dismiss="modal">
               <spring:message code="label.sim" />
            </button>
            <button id="produto-confirme-nao-button" type="button"
               class="btn btn-secondary glyphicon glyphicon-remove" data-dismiss="modal">
               <spring:message code="label.nao" />
            </button>
         </div>
      </div>
   </div>
</div>
