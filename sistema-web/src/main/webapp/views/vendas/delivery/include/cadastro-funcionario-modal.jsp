<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Modal HTML Markup -->
<div id="modal-cadastrar-funcionario" class="modal width-50" data-backdrop="static" tabindex="-1"
   role="dialog" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">

         <div class="modal-header div-titulo-pagina">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1 class="modal-title titulo-font">Cadastrar Funcionario</h1>
         </div>
         <div class="modal-body">

            <form id="funcionario-modal-form" role="form">
               <input type="hidden" id="funcionario-modal-id" name="id">

               <div class="row">
                  <div class="col-md-8">
                     <div class="form-group">
                        <label for="input-produto-nome">NOME *</label>
                        <div class="input-group">
                           <span class="input-group-addon">
                              <i class="glyphicon glyphicon-user"></i>
                           </span>
                           <div>
                              <input id="input-funcionario-nome" name="nome"
                                 class="form-control input-sm caixa_alta" type="text" placeholder="Digite..."
                                 onkeypress="return handleEnter(this, event)" />
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-md-4">
                     <div class="form-group">
                        <label for="input-funcionario-cargo">CARGO *</label>
                        <div>
                           <select id="input-funcionario-cargo" class="form-control input-sm">
                              <option value="1">ENTREGADOR</option>
                              <option value="2">VENDEDOR</option>
                              <option value="3">CAIXA</option>
                           </select>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-12">
                     <div class="form-group has-feedback">
                        <label for="input-endereco-cliente"> ENDERECO * </label>
                        <div class="input-group">
                           <span class="input-group-addon">
                              <i class="glyphicon glyphicon-globe"></i>
                           </span>
                           <div>
                              <input id="input-endereco-cliente" name="input-endereco-cliente"
                                 class="form-control input-sm endereco-auto-complete caixa_alta" type="text"
                                 placeholder="Digite Cep ou Endereço"
                                 onkeypress="return handleEnter(this, event)" />
                           </div>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="row">
                  <div class="col-md-4">
                     <div class="form-group">
                        <label for="input-cliente-bairro"> BAIRRO </label>
                        <input id="input-cliente-bairro" class="form-control input-sm input-bairro caixa_alta"
                           type="text" readonly="readonly" onkeypress="return handleEnter(this, event)" />
                     </div>
                  </div>
                  <div class="col-md-4">
                     <div class="form-group">
                        <label for="input-cliente-municipio"> MUNICÍPIO </label>
                        <input id="input-cliente-municipio" class="form-control input-sm input-municipio caixa_alta"
                           type="text" readonly="readonly" onkeypress="return handleEnter(this, event)" />
                     </div>
                  </div>
                  <div class="col-md-4">
                     <div class="form-group">
                        <label for="input-cliente-numero"> NUMERO * </label>
                        <div>
                           <input id="input-cliente-numero" class="form-control input-sm"
                              name="enderecoCliente[numero]" type="number" placeholder="Digite o Número"
                              onkeypress="return handleEnter(this, event)" />
                        </div>
                     </div>
                  </div>
               </div>

               <div class="row">
                  <div class="col-md-12">
                     <div class="form-group">
                        <label for="input-ponto-referencia"> PONTO DE REFERÊNCIA </label>
                        <textarea id="input-ponto-referencia" name="enderecoCliente[pontoReferencia]"
                           class="form-control input-sm caixa_alta" rows="5" placeholder="Digite o Ponto de Referência"></textarea>
                     </div>
                  </div>
               </div>

            </form>

         </div>
         <div class="modal-footer">
            <button id="btn-venda-delivery-voltar" type="button" data-dismiss="modal"
               class="btn btn-primary btn">
               <span class="glyphicon glyphicon-minus-sign"></span>
               Cancelar
            </button>
            <button id="btn-salvar-funcionario" type="button" class="btn btn-primary btn">
               <span class="glyphicon glyphicon-plus"></span>
               Salvar
            </button>
         </div>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<!-- /.modal -->