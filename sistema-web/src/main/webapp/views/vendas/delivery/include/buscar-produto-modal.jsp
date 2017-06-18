<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Modal HTML Markup -->
<div id="modal-buscar-produto" class="modal" data-backdrop="static" tabindex="-1"
   role="dialog" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">

         <div class="modal-header div-titulo-pagina">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1 class="modal-title titulo-font">Adicionar Produto</h1>
         </div>
         <div class="modal-body">

            <form id="adicionar-produto-form" role="form">
               <input type="hidden" id="input-hidden-adicionar-produto-id" name="id">
               <table id="buscar-produto-table"
                  class="table table-responsive table-bordered table-striped cor-cabecalho tabelaBuscarProduto">

                  <thead>
                     <th>&nbsp;</th>
                     <th>&nbsp;</th>
                     <th>CATEGORIA</th>
                     <th>ITEM</th>
                     <th class="text-right">ESTOQUE</th>
                     <th class="text-right">PREÇO</th>
                     <th class="text-right">SUBTOTAL</th>
                  </thead>

                  <tbody class="buscar-produto-table-body">

                  </tbody>

                  <tfoot style="border: none;">
                     <tr style="border: none;">
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;"><label class="pedido-label">TOTAL:</label></td>
                        <td style="border: none;" class="text-right"><label id="td-modal-pedido-valor-total-label" class="pedido-valor-label">0</label></td>
                     </tr>
                  </tfoot>

               </table>
            </form>

         </div>
         <div class="modal-footer">
            <button id="btn-venda-delivery-voltar" type="button" data-dismiss="modal"
               class="btn btn-primary btn">
               <span class="glyphicon glyphicon-minus-sign"></span>
               Cancelar
            </button>
            <button id="btn-adicionar-no-pedido" type="button" class="btn btn-primary btn">
               <span class="glyphicon glyphicon-plus"></span>
               Adicionar no Pedido
            </button>
         </div>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<!-- /.modal -->