<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Modal HTML Markup -->
<div id="clienteFormModal" class="modal modal-wide" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
         <div class="modal-header div-titulo-pagina">
            <h1 class="modal-title titulo-font">
               <spring:message code="label.cliente.cadastrocliente" />
            </h1>
         </div>
         <div class="modal-body">


            <form id="js-cliente-form" role="form">
               <input type="hidden" id="input_hidden_clienteId">
               <input type="hidden" id="input_hidden_enderecoId" class="input_hidden_enderecoId">
               <input type="hidden" id="input_hidden_enderecoClienteId">
               <div class="box-body">

                  <div class="row">
                     <div class="col-md-12">


                        <div class="form-group">
                           <label for="input_cliente_nome">
                              <spring:message code="label.cliente.nomecliente" />
                              *
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="glyphicon glyphicon-user"></i>
                              </span>
                              <div>
                                 <input id="input_cliente_nome" class="form-control caixa_alta" type="text"
                                    placeholder="Digite o Nome" onkeypress="return handleEnter(this, event)" />
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="row">
                     <div class="col-md-4">
                        <div class="form-group has-feedback">
                           <label for="input_cliente_telefone">
                              <spring:message code="label.telefoneMI" />
                              *
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="glyphicon glyphicon-earphone"></i>
                              </span>
                              <div>
                                 <input id="input_cliente_telefone" name="input_cliente_telefone"
                                    class="form-control campo_telefone" type="text"
                                    placeholder="(00) 0000-00000" onkeypress="return handleEnter(this, event)" />
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input_cliente_telefone2">
                              <spring:message code="label.telefone2MI" />
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="glyphicon glyphicon-earphone"></i>
                              </span>
                              <input id="input_cliente_telefone2" name="input_cliente_telefone2"
                                 class="form-control campo_telefone" type="text" placeholder="(00) 0000-00000"
                                 onkeypress="return handleEnter(this, event)" />
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group ">
                           <label for="input_cliente_aniversario">
                              <spring:message code="label.datanasc" />
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="glyphicon glyphicon-calendar"></i>
                              </span>
                              <div>
                                 <input id="input_cliente_aniversario" class="form-control calendario"
                                    type=text placeholder="99/99/9999" maxlength="10"
                                    onkeypress="return handleEnter(this, event)" />
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>



                  <div class="row">
                     <div class="col-md-12">
                        <div class="form-group has-feedback">
                           <label for="input_endereco_cliente">
                              <spring:message code="label.enderecoMI" />
                              *
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="glyphicon glyphicon-globe"></i>
                              </span>
                              <div>
                                 <input id="input_endereco_cliente" name="input_endereco_cliente"
                                    class="form-control endereco-auto-complete caixa_alta" type="text"
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
                           <label for="input_cliente_bairro">
                              <spring:message code="label.bairro" />
                           </label>
                           <input id="input_cliente_bairro" name="input_cliente_bairro"
                              class="form-control input_bairro caixa_alta" type="text" readonly="readonly"
                              onkeypress="return handleEnter(this, event)" />
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input_cliente_municipio">
                              <spring:message code="label.municipio" />
                           </label>
                           <input id="input_cliente_municipio" name="input_cliente_municipio"
                              class="form-control input_municipio caixa_alta" type="text" readonly="readonly"
                              onkeypress="return handleEnter(this, event)" />
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input_cliente_numero">
                              <spring:message code="label.numero" />
                              *
                           </label>
                           <div>
                              <input id="input_cliente_numero" class="form-control" type="number"
                                 placeholder="Digite o Número" onkeypress="return handleEnter(this, event)" />
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="row">
                     <div class="col-md-12">
                        <div class="form-group">
                           <label for="input_ponto_referencia">
                              <spring:message code="label.cliente.pontoref" />
                           </label>
                           <textarea id="input_ponto_referencia" class="form-control caixa_alta" rows="5"
                              placeholder="Digite o Ponto de Referência"></textarea>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- /.box-body -->

               <div class="box-footer">
                  <div id="div_acoes_cliente" class="btn-toolbar" role="toolbar"
                     aria-label="Toolbar with button groups">
                     <div class="btn-group mr-2" role="group" aria-label="Second group">
                        <button id="js-cliente-cancelar-button" type="button"
                           class="btn btn btn-primary glyphicon glyphicon-remove-circle" data-dismiss="modal">
                           <spring:message code="bt.cancelar" />
                        </button>
                     </div>
                     <div class="btn-group" role="group" aria-label="Third group">
                        <button id="js-cliente-salvar-button" type="button"
                           class="btn btn-success glyphicon glyphicon-floppy-disk">
                           <spring:message code="bt.salvar" />
                        </button>
                     </div>
                     <div class="btn-group" role="group" aria-label="Third group">
                        <button id="js-cliente-excluir-button" type="submit"
                           class="btn btn-danger glyphicon glyphicon-trash">
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

                  <div id="div_excluir_cliente" class="col-xs-8 .col-sm-4">
                     <div class="alert alert-danger">
                        <strong>
                           <spring:message code="label.cliente.atencao" />
                        </strong>
                        <spring:message code="msg.cliente.confirmacao" />
                     </div>
                     <button id="js-cliente-sim-button" type="button"
                        class="btn btn btn-primary glyphicon glyphicon-ok">
                        <spring:message code="label.sim" />
                     </button>
                     <button id="js-cliente-nao-button" type="button"
                        class="btn btn-secondary glyphicon glyphicon-remove">
                        <spring:message code="label.nao" />
                     </button>
                  </div>
               </div>
               <!-- /.box-footer -->
            </form>

         </div>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<!-- /.modal -->