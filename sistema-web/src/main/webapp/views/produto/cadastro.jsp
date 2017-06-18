<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form id="produto-form" role="form" enctype="multipart/form-data">

   <input type="hidden" id="input-hidden-produto-id" name="id">
   <input type="hidden" id="input-hidden-estoque-id" name="estoque[id]">
   <input type="hidden" id="input-hidden-produto-nome-imagem" name="nomeImagem">
   <input type="hidden" id="input-hidden-path-imagem" name="pathImagem">

   <div class="box-body">

      <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
         <div class="btn-group mr-2" role="group" aria-label="Second group">
            <button id="btn-produto-voltar" type="button"
               class="btn btn btn-primary glyphicon glyphicon-arrow-left">
               <spring:message code="bt.voltar" />
            </button>
         </div>
         <div class="btn-group" role="group" aria-label="Third group">
            <button id="produto-salvar-button" type="button"
               class="btn btn-primary glyphicon glyphicon-floppy-disk">
               <spring:message code="bt.salvar" />
            </button>
         </div>
         <div class="btn-group" role="group" aria-label="Third group">
            <button id="produto-excluir-button" type="button"
               class="btn btn-primary glyphicon glyphicon-trash" data-toggle="modal"
               data-target="#modalConfimaExclusao">
               <spring:message code="bt.excluir" />
            </button>
         </div>

         <div class="btn-group" role="group" aria-label="Third group">
            <button type="button" id="produto-limpar-button"
               class="btn btn-primary produto-limpar-button glyphicon glyphicon-plus">
               <spring:message code="label.novo" />
            </button>
         </div>
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
               <div class="box-header">
                  <h3 class="box-title">Dados do Produto</h3>
               </div>
               <div class="box-body input-margim-bottom-5">

                  <div class="row">
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input-produto-codigo-busca">
                              <spring:message code="label.produto.codigobusca" />
                              *
                           </label>
                           <div class="input-group">
                              <span id="link-produto-codigo-busca-ajuda" class="input-group-addon"
                                 style="cursor: pointer; background-color: #3c8dbc;">
                                 <a href="#" title="Códigos personalizados">
                                    <span class="glyphicon glyphicon-question-sign"
                                       title="Digite seu código de busca personalizado!" style="color: #fff;"></span>
                                 </a>
                              </span>
                              <div>
                                 <input id="input-produto-codigo-busca" name="codigoBusca"
                                    class="form-control input-sm" type="text" placeholder="Digite..."
                                    onkeypress="return handleEnter(this, event)" />
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-6 ">
                        <div class="form-group">
                           <label for="input-produto-nome">
                              <spring:message code="label.produto.nome" />
                              *
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="fa fa-product-hunt"></i>
                              </span>
                              <div>
                                 <input id="input-produto-nome" name="nome" class="form-control input-sm caixa_alta"
                                    type="text" placeholder="Digite..."
                                    onkeypress="return handleEnter(this, event)" />
                              </div>
                           </div>
                        </div>
                     </div>

                     <div class="col-md-2">
                        <div class="form-group">
                           <label for="select-produto-ativo"> Ativo</label>
                           <div class="input-group">
                              <div>
                                 <select id="select-produto-ativo" name="ativo"
                                    class="form-control input-sm">
                                 </select>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="row" style="padding-top: -10px;">
                     <div class="col-md-4">

                        <div class="form-group">
                           <label for="select-produto-categoria">
                              <spring:message code="label.produto.categoria" />
                              *
                           </label>
                           <div class="input-group">
                              <span id="link-categoria-novo" class="input-group-addon"
                                 style="cursor: pointer; background-color: #3c8dbc;">
                                 <a href="#" title="Clique para adicionar uma nova categoria">
                                    <span class="glyphicon glyphicon-plus" style="color: #fff;"></span>
                                 </a>
                              </span>
                              <div>
                                 <select id="select-produto-categoria" name="categoriaProduto[id]"
                                    class="selectpicker form-control input-sm">
                                    <option value=""></option>
                                 </select>
                              </div>
                           </div>
                        </div>

                     </div>
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input-produto-preco-venda">
                              <spring:message code="label.produto.precovenda" />
                              *
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon"> R$ </span>
                              <div>
                                 <input id="input-produto-preco-venda" name="precoVenda"
                                    class="form-control input-sm text-right moeda" type="text" placeholder="Digite..."
                                    onkeypress="return handleEnter(this, event)" />
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input-produto-preco-custo">
                              <spring:message code="label.produto.precocusto" />
                              *
                           </label>
                           <div class="input-group">
                              <span class="input-group-addon"> R$ </span>
                              <div>
                                 <input id="input-produto-preco-custo" name="precoCusto"
                                    class="form-control input-sm text-right moeda" type="text" placeholder="Digite..."
                                    onkeypress="return handleEnter(this, event)" maxlength="9" />
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>

                  <!--                         <div id="pickList"></div> -->

                  <div class='row'>
                     <div class="col-md-5">
                        <div class="form-group">
                           <label for="adicionalDisponivelCB">
                              <spring:message code="label.produto.adicionaisdisponiveis" />
                              *
                           </label>
                           <div class="input-group">
                              <span id="link-produto-adicional-novo" class="input-group-addon"
                                 style="cursor: pointer; background-color: #3c8dbc;">
                                 <a href="#" title="Clique para adicionar um novo adicional de produto">
                                    <span class="glyphicon glyphicon-plus" style="color: #fff;"></span>
                                 </a>
                              </span>
                              <div>
                                 <select id="adicionalDisponivelCB" size="5" class='form-control input-sm'
                                    multiple="multiple">
                                 </select>
                              </div>
                           </div>
                        </div>
                     </div>

                     <div class='col-md-2 pickListButtons' style="margin-top: 28px; !important;">
                        <button id="addAll" type="button" class='btn-adicional center-block'>>></button>
                        <button id="add" type="button" class='btn-adicional center-block'>></button>
                        <button id="remove" type="button" class='btn-adicional center-block'><</button>
                        <button id="removeAll" type="button" class='btn-adicional center-block'><<</button>

                        <!--                         <button id="selecionados" type="button" class='remove btn-default center-block'>Selecteds</button> -->
                     </div>
                     <div class='col-md-5'>
                        <label for='input-produto-preco-custo'>
                           <spring:message code='label.produto.adicionaisproduto' />
                        </label>
                        <select id="adicionalProdutoDB" size="5" class='form-control input-sm' multiple="multiple">
                        </select>
                     </div>
                  </div>

                  <div class="row">
                     <div class="col-md-8">
                        <div class="form-group">
                           <label id="label-produto-imagem" for="upload_link">
                              <spring:message code="label.imagem" />
                           </label>
                           <div class="input-group">
                              <div>
                                 <a href="#" id="upload_link">
                                    <img id="img-produto" src="assets/dist/img/boxed-bg.jpg" width="220"
                                       height="140" />
                                 </a>
                                 <input id="uploadfile" style="display: none" accept="image/png, image/jpeg"
                                    name="uploadfile" class="form-control" type="file" />
                              </div>
                              <span id="produto-nome-imagem"></span>
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
               <div class="box-header">
                  <h3 class="box-title">Estoque</h3>
               </div>
               <div class="box-body">

                  <div class="row">

                     <div class="col-md-6">
                        <div class="form-group">
                           <label for="input-unidade-medida">
                              <spring:message code="label.estoque.unidademedida" />
                              *
                           </label>
                           <div class="input-group">
                              <span id="link-produto-unidade-medida-novo" class="input-group-addon"
                                 style="cursor: pointer; background-color: #3c8dbc;">
                                 <a href="#" title="Clique para adicionar uma nova unidade de medida">
                                    <span class="glyphicon glyphicon-plus" style="color: #fff;"></span>
                                 </a>
                              </span>
                              <div>
                                 <select id="select-produto-unidade-medida" name="estoque[unidadeMedida][id]"
                                    class="selectpicker form-control input-sm">
                                    <option value=""></option>
                                 </select>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- /.row -->

                  <div class="row">
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input-estoque-estoqueatual"
                              title="Digite a quantidade que contem desse produto"> Est Atual* </label>
                           <div>
                              <input id="input-estoque-estoqueatual" name="estoque[estoqueAtual]"
                                 class="form-control input-sm" type="text" placeholder="Digite..."
                                 onkeypress='return somenteNumero(event)' />
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group">
                           <label for="input-estoque-alertaestoque"
                              title="Valor minimo para o estoque, você recebera um alerta quando a quantidade em estoque chegar nesse valor">
                              Alerta Est* </label>
                           <div>
                              <input id="input-estoque-alertaestoque" name="estoque[alertaEstoque]"
                                 class="form-control input-sm" type="text" placeholder="Digite..."
                                 onkeypress='return somenteNumero(event)' />
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- /.row -->

                  <div class="row">
                     <div class="col-md-12">
                        <table id="cliente-table" class="table table-bordered table-striped cor-cabecalho">
                           <thead>
                              <tr>
                                 <th colspan="4" class="text-center">
                                    <spring:message code="label.estoque.movimentacoes" />
                                 </th>
                              </tr>
                           </thead>
                           <thead>
                              <tr>
                                 <th id="id">
                                    <spring:message code="label.estoque.tipo" />
                                 </th>
                                 <th>
                                    <spring:message code="label.quantidade" />
                                 </th>
                                 <th class="no-sort">
                                    <spring:message code="label.data" />
                                 </th>
                                 <th class="no-sort">
                                    <spring:message code="label.usuario" />
                                 </th>
                              </tr>
                           </thead>
                        </table>
                     </div>
                  </div>
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
