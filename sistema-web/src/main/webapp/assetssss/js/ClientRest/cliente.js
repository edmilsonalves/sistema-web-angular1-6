$(document).ready(function() {
	var clienteTable = $('#cliente-table').DataTable( {
    	"processing": true,
    	"ajax": {
            "url": sAction() + "/rest/clientes",
    		"dataSrc" : "",
    		'dataType': "json",
    		"error" : function(){
    			alert('Erro ao acessar o web services /rest/clientes');
    		}
        },
        "columns": [
            { 
                "data": "id",
                "render" : function(data, type, row, meta){
                      return $("<a class='btn-link editClienteLink'>")
                         .attr("href", "#")
                         .text(data)
                         .wrap("<div></div>")
                         .parent()
                         .html();
                   
                }
             },
            { "data": "nome" },
            { "data": "cpfCnpj" },
            { "data": "rg" },
            { "data": "endereco.logradouro" }

            
        ],
        select: true,
        "columnDefs": [ {
        	"targets": "no-sort",
        	"orderable": false,
        	} ],
        "language" : traducaoDataTable()	
    } );
	
	
	//Abre modal do cliente para inclusão
	$(function () {
        $('#js-cliente-cancelar-button').click(function () {
        	$('#js-cliente-form').each (function(){   
        		validator.resetValidacoes();
        		this.reset();
        	});   		
        }); 
    });
	
	//Abre modal do cliente para inclusão
	$(function () {
        $('#js-cliente-novo-button').click(function () {
        	$('#js-cliente-form').each (function(){   
        		validator.resetValidacoes();
        		  this.reset();
        	});   		
        }); 
    });
	
	//Abre modal do cliente para edição
	$('#cliente-table tbody').on('click', '.editClienteLink', function () {
		validator.resetValidacoes();
		var data = clienteTable.row( $(this).parents('tr') ).data();
		$('#input_nome').val(data.nome);
		$('#input_rg').val(data.rg);
		$('#input_cpf_cnpj').val(data.cpfCnpj);
		
		$('#clienteFormModal').modal('show'); 
		
    } );
	

	
} );
