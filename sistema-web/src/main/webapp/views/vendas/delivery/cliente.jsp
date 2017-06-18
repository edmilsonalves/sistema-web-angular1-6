<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form id="js-cliente-form" role="form">



   <input type="hidden" id="input-hidden-clienteId" name="id">
   <input type="hidden" id="input-hidden-enderecoClienteId">
   <input type="hidden" id="input-hidden-enderecoId" class="input-hidden-enderecoId">

   <div class="box-body" style="margin-top: -15px;">

      <div class="row">
         <div class="col-md-4">
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
                     <input id="input-cliente-telefone" name="telefone"
                        class="form-control input-sm campo_telefone" type="text" placeholder="(00) 0000-00000"
                        onkeypress="return handleEnter(this, event)" />
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md-8">
            <div class="form-group">
               <label for="input-produto-nome"> Nome * </label>
               <div class="input-group">
                  <span class="input-group-addon">
                     <i class="glyphicon glyphicon-user"></i>
                  </span>
                  <div>
                     <input id="input-produto-nome" name="nome" class="form-control input-sm caixa_alta"
                        type="text" placeholder="Digite..." onkeypress="return handleEnter(this, event)" />
                  </div>
               </div>
            </div>

         </div>
      </div>

      <div class="row">
         <div class="col-md-6">
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
                        class="form-control endereco-auto-complete input-sm caixa_alta" type="text"
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
               <input id="input-cliente-bairro" class="form-control input-sm input-bairro caixa_alta"
                  type="text" readonly="readonly" onkeypress="return handleEnter(this, event)" />
            </div>
         </div>
         <div class="col-md-3">
            <div class="form-group">
               <label for="input-cliente-municipio">
                  <spring:message code="label.municipio" />
               </label>
               <input id="input-cliente-municipio" class="form-control input-sm input-municipio caixa_alta"
                  type="text" readonly="readonly" onkeypress="return handleEnter(this, event)" />
            </div>
         </div>
      </div>

      <div class="row">
         <div class="col-md-4">
            <div class="form-group">
               <label for="input-cliente-numero">
                  <spring:message code="label.numero" />
                  *
               </label>
               <div>
                  <input id="input-cliente-numero" class="form-control input-sm"
                     name="enderecoCliente[numero]" type="number" placeholder="Digite o Número"
                     onkeypress="return handleEnter(this, event)" />
               </div>
            </div>
         </div>
         <div class="col-md-8">
            <div class="form-group">
               <label for="input-ponto-referencia">
                  <spring:message code="label.cliente.pontoref" />
               </label>
               <input id="input-ponto-referencia" name="enderecoCliente[pontoReferencia]"
                  class="form-control input-sm caixa_alta" placeholder="Digite o Ponto de Referência">
               </textarea>
            </div>
         </div>
      </div>
      <br />
      <div class="row">
         <div class="col-md-12">
            <label>Status da entrega</label>
         </div>
         <div class="col-md-6" style="margin-left: 40px;">
            <div class="radio">
               <label>
                  <input type="radio" name="optradio">
                  Iniciado
               </label>
            </div>
            <div class="radio">
               <label>
                  <input type="radio" name="optradio">
                  Saiu p/ Entrega
               </label>
            </div>
            <div class="radio">
               <label>
                  <input type="radio" name="optradio">
                  Entregue
               </label>
            </div>
         </div>
      </div>


   </div>
</form>