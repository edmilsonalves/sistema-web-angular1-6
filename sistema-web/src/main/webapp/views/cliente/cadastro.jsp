<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form id="js-cliente-form" role="form">

   <div id="msg-sucesso-cliente" class="alert alert-success" style="display: none">Cliente salvo com
      sucesso!</div>

   <input type="hidden" id="input-hidden-clienteId" name="id" >
   <input type="hidden" id="input-hidden-enderecoClienteId">
   <input type="hidden" id="input-hidden-enderecoId" class="input-hidden-enderecoId">

   <div class="box-body">

      <div class="row">
         <div class="col-md-4">
            <div class="form-group">
               <label for="input-cliente-nome">
                  <spring:message code="label.cliente.nomecliente" />
                  *
               </label>
               <div class="input-group">
                  <span class="input-group-addon">
                     <i class="glyphicon glyphicon-user"></i>
                  </span>
                  <div>
                     <input id="input-cliente-nome" name="nome" class="form-control caixa_alta" type="text"
                        placeholder="Digite o Nome" onkeypress="return handleEnter(this, event)" />
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md-3">
            <div class="form-group has-feedback">
               <label for="input-cliente-telefone">
                  <spring:message code="label.telefoneMI" />
                  *
               </label>
               <div class="input-group">
                  <span class="input-group-addon">
                     <i class="glyphicon glyphicon-earphone"></i>
                  </span>
                  <div>
                     <input id="input-cliente-telefone" name="telefone" class="form-control campo_telefone"
                        type="text" placeholder="(00) 0000-00000" onkeypress="return handleEnter(this, event)" />
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md-3">
            <div class="form-group">
               <label for="input-cliente-telefone2">
                  <spring:message code="label.telefone2MI" />
               </label>
               <div class="input-group">
                  <span class="input-group-addon">
                     <i class="glyphicon glyphicon-earphone"></i>
                  </span>
                  <input id="input-cliente-telefone2" name="telefone2" class="form-control campo_telefone"
                     type="text" placeholder="(00) 0000-00000" onkeypress="return handleEnter(this, event)" />
               </div>
            </div>
         </div>
         <div class="col-md-2">
            <div class="form-group ">
               <label for="input-cliente-aniversario">
                  <spring:message code="label.datanasc" />
               </label>
               <div class="input-group">
                  <span class="input-group-addon">
                     <i class="glyphicon glyphicon-calendar"></i>
                  </span>
                  <div>
                     <input id="input-cliente-aniversario" name="aniversario" class="form-control calendario"
                        type=text placeholder="99/99/9999" maxlength="10"
                        onkeypress="return handleEnter(this, event)" />
                  </div>
               </div>
            </div>
         </div>
      </div>


      <div class="row">
         <div class="col-md-4">
            <div class="form-group has-feedback">
               <label for="input-endereco-cliente">
                  <spring:message code="label.enderecoMI" />
                  *
               </label>
               <div class="input-group">
                  <span class="input-group-addon">
                     <i class="glyphicon glyphicon-globe"></i>
                  </span>
                  <div>
                     <input id="input-endereco-cliente" name="input-endereco-cliente"
                        class="form-control endereco-auto-complete caixa_alta" type="text"
                        placeholder="Digite Cep ou Endereço" onkeypress="return handleEnter(this, event)" />
                  </div>
               </div>
            </div>
         </div>

         <div class="col-md-3">
            <div class="form-group">
               <label for="input-cliente-bairro">
                  <spring:message code="label.bairro" />
               </label>
               <input id="input-cliente-bairro"
                  class="form-control input-bairro caixa_alta" type="text" readonly="readonly"
                  onkeypress="return handleEnter(this, event)" />
            </div>
         </div>
         <div class="col-md-3">
            <div class="form-group">
               <label for="input-cliente-municipio">
                  <spring:message code="label.municipio" />
               </label>
               <input id="input-cliente-municipio"
                  class="form-control input-municipio caixa_alta" type="text" readonly="readonly"
                  onkeypress="return handleEnter(this, event)" />
            </div>
         </div>
         <div class="col-md-2">
            <div class="form-group">
               <label for="input-cliente-numero">
                  <spring:message code="label.numero" />
                  *
               </label>
               <div>
                  <input id="input-cliente-numero" class="form-control" name="enderecoCliente[numero]" type="number"
                     placeholder="Digite o Número" onkeypress="return handleEnter(this, event)" />
               </div>
            </div>
         </div>
      </div>

      <div class="row">
         <div class="col-md-12">
            <div class="form-group">
               <label for="input-ponto-referencia">
                  <spring:message code="label.cliente.pontoref" />
               </label>
               <textarea id="input-ponto-referencia" name="enderecoCliente[pontoReferencia]" class="form-control caixa_alta" rows="5"
                  placeholder="Digite o Ponto de Referência"></textarea>
            </div>
         </div>
      </div>
   </div>
   <!-- /.box-body -->

   <div class="box-footer">
      <div id="div-acoes-cliente" class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
         <div class="btn-group mr-2" role="group" aria-label="Second group">
            <button id="js-cliente-cancelar-button" type="button"
               class="btn btn btn-primary glyphicon glyphicon-arrow-left">
               <spring:message code="bt.voltar" />
            </button>
         </div>
         <div class="btn-group" role="group" aria-label="Third group">
            <button id="js-cliente-salvar-button" type="button"
               class="btn btn-success glyphicon glyphicon-floppy-disk">
               <spring:message code="bt.salvar" />
            </button>
         </div>
         <div class="btn-group" role="group" aria-label="Third group">
            <button id="js-cliente-excluir-button" type="button"
               class="btn btn-danger glyphicon glyphicon-trash" data-toggle="modal"
               data-target="#modalConfimaExclusao">
               <spring:message code="bt.excluir" />
            </button>
         </div>

         <div class="btn-group" role="group" aria-label="Third group">
            <button id="js-cliente-limpar-button" type="button"
               class="btn btn-danger glyphicon glyphicon-refresh">
               <spring:message code="bt.limpar" />
            </button>
         </div>
      </div>

      <!-- 		<div id="div-excluir-cliente" class="col-xs-8 .col-sm-4"> -->
      <!-- 			<div class="alert alert-danger"> -->
      <%-- 				<strong> <spring:message code="label.cliente.atencao" /> --%>
      <!-- 				</strong> -->
      <%-- 				<spring:message code="msg.cliente.confirmacao" /> --%>
      <!-- 			</div> -->
      <!-- 			<button id="js-cliente-sim-button" type="button" -->
      <!-- 				class="btn btn btn-primary glyphicon glyphicon-ok"> -->
      <%-- 				<spring:message code="label.sim" /> --%>
      <!-- 			</button> -->
      <!-- 			<button id="js-cliente-nao-button" type="button" -->
      <!-- 				class="btn btn-secondary glyphicon glyphicon-remove"> -->
      <%-- 				<spring:message code="label.nao" /> --%>
      <!-- 			</button> -->
      <!-- 		</div> -->
   </div>
   <!-- /.box-footer -->
</form>


<!-- Modal -->
<div class="modal" id="modalConfimaExclusao" role="dialog">
   <div class="modal-dialog modal-sm">
      <div class="modal-content">
         <div class="modal-header">
            <h4 class="modal-title">Atenção</h4>
         </div>
         <div class="modal-body">
            <p>Deseja realemnte excluir o registro?</p>
         </div>
         <div class="modal-footer">
            <button id="js-cliente-sim-button" type="button"
               class="btn btn btn-primary glyphicon glyphicon-ok">
               <spring:message code="label.sim" />
            </button>
            <button id="js-cliente-nao-button" type="button"
               class="btn btn-secondary glyphicon glyphicon-remove" data-dismiss="modal">
               <spring:message code="label.nao" />
            </button>
         </div>
      </div>
   </div>
</div>
