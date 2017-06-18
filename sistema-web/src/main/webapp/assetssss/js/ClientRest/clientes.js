// The root URL for the RESTful services
var rootClienteURL = "rest/clientes";


function findByName(searchKey) {
	$.ajax({
		type: 'GET',
		url: rootClienteURL + '/search/' + searchKey,
		dataType: "json",
		success: renderList 
	});
}


var tableConfig = {
	"searching" : true,
	"processing" : true,
	"serverSide" : true,
	"responsive": true,
	"ajax" : {
		"type": 'GET',
		"url" : rootClienteURL+"/clientesDataTable",
		"dataType": "json",
		"data" : function(obj) {
//			console.log('obj: '+JSON.stringify(obj));
		}, 
		"dataSrc" : function(json) {
			return json.data;
		},
		"error": function(error) {
			alert("Erro ao consultar os clientes no web service "+ rootClienteURL)
		},
	},
	fnServerParams: function(data) {
	      data['order'].forEach(function(items, index) {
//	    	  alert('index: '+data['columns'][items.column]['data']);
	          data['columns'][index]['name'] = data['columns'][items.column]['data'];
	    });
	},
	 initComplete: function() {
		 var table = $('#cliente-table').dataTable();
	        $('#cliente-table_filter input').unbind();
	        
	        $('#cliente-table_filter input').bind('keyup', function(e) {	
	            if(e.keyCode === 13) {
	            	table.fnFilter(this.value);
	            }if(e.keyCode === 8) {
	            	if(this.value.length == 0){
		            	table.fnFilter('');	            		
	            	}
	            }
	        });
	        
	        $('#cliente-table_filter input').bind('blur', function(e) {
	            if(this.value.length > 0){
	            	table.fnFilter(this.value);	            		
	            }else if(this.value.length == 0){
		            table.fnFilter('');	            		
	            }
	        });
	    },
    "columns": [
        { 
            "data": "id",
            "render" : function ( data, type, row, meta ) {
                return '<a class="btn-link editClienteLink" href="#">'+data+'</a>';
            }
         },
        { "data": "nome" },
        { "data": "telefone" },
        { "data": "enderecoCliente.endereco.logradouro" }

        
    ],
    select: true,
    "columnDefs": [ 
			{
				"width": "2%",
				"className" : "text-center",
				"targets" : 0
			},
			{
				"width": "30%",
				"targets" : 1
			},
			{
				"width": "10%",
				"targets" : 2
			},
			{
				"width": "8%",
				"targets" : 3
			},
	    	{
	    	"targets": "no-sort",
	    	"orderable": false,
	    	}
    	],
    "language" : traducaoDataTable()	
};

var currentWine;

carregarTela();

// Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

$('#btnAdd').click(function() {
	newWine();
	return false;
});
//
//$('#js-cliente-salvar-button').submit(function() {
//    $('#clienteFormModal').modal('hide');
//    return false;
//});


$('#js-cliente-salvar-button').click(function() {	
	if (!$('#js-cliente-form').validator('validate').has('.has-error').length) {
		if ($('#input-hidden-clienteId').val() == ''){
			addCliente();
		}
		else{
			updateCliente();
		}
		$('#clienteFormModal').modal('hide');
		ajaxReload();
	}
	return false;
});

function ajaxReload(){
	$('#cliente-table').DataTable().ajax.reload();
}

//Abre modal do cliente para inclusão
$(function () {
    $('#js-cliente-novo-button').click(function () {
    	$('#js-cliente-form').each (function(){ 
    		$('.input_hidden_endereco_cliente_id').val(null);
    		$('#js-cliente-excluir-button').hide();
//    		$('#js-cliente-form')[0].reset();
    		this.reset();
    		$("#div-codigo").hide();
    	});   		
    }); 
});

$('#js-cliente-excluir-button').click(function() {
	$("#div_acoes_cliente").hide();
	$("#div_excluir_cliente").show();
	return false;
});

$('#js-cliente-sim-button').click(function(){
	deleteCliente();
	resetarBotoesConfirmacoes();
	$('#clienteFormModal').modal('hide');
	
});

$('#js-cliente-nao-button').click(function(){
	$("#div_acoes_cliente").show();
	$("#div_excluir_cliente").hide();
});

// Replace broken images with generic wine bottle
$("img").error(function(){
  $(this).attr("src", "pics/generic.jpg");

});

function resetarBotoesConfirmacoes(){
	$("#div_acoes_cliente").show();
	$("#div_excluir_cliente").hide();
	$('#js-cliente-excluir-button').show();
}

function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else
		findByName(searchKey);
}

function newWine() {
	$('#btnDelete').hide();
	currentWine = {};
	renderDetails(currentWine); // Display empty form
}

function carregarTela() {	
	$("#div_acoes_cliente").show();
	$("#div_excluir_cliente").hide();
	$('#cliente-table').dataTable(tableConfig);
}

$("div.dataTables_filter input").keyup( function (e) {
//    alert('aaa');
} );


//function findAll() {
//	console.log('findAll');
//	$.ajax({
//		type: 'GET',
//		url: rootClienteURL,
//		dataType: "json", // data type of response
//		error: error,
//		success: renderList
//	});
//}



function findByName(searchKey) {
	$.ajax({
		type: 'GET',
		url: rootClienteURL + '/search/' + searchKey,
		dataType: "json",
		success: renderList 
	});
}

function findById(id) {
	$.ajax({
		type: 'GET',
		url: rootClienteURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			currentWine = data;
			renderDetails(currentWine);
		}
	});
}

function addCliente() {
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootClienteURL + "/" + $('.input_hidden_enderecoId').val(),
		dataType: "json",
		data: formToJSON(),
		success: ajaxReload,
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao tentar incluir cliente: ' + textStatus);
		}
	});
}

function updateCliente() {
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootClienteURL + "/" + $('#input_hidden_enderecoId').val(),
		dataType: "json",
		data: formToJSON(),
		success: ajaxReload,
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao tentar alterar cliente:: ' + textStatus);
		}
	});
}

function deleteCliente() {
	$.ajax({
		type: 'DELETE',
		url: rootClienteURL + '/' + $('#input-hidden-clienteId').val(),
		success: ajaxReload,
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteWine error');
		}
	});
}


function error() {
	alert('Erro de conexão web service /rest/clientes');
}

function renderList(dataSet) {
	var clienteTable = $('#cliente-table').DataTable( {
    	"processing": true,
    	 data: dataSet,
        "columns": [
            { 
                "data": "id",
                "render" : function ( data, type, row, meta ) {
                    return '<a class="btn-link editClienteLink" href="#">'+data+'</a>';
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
}


$(document).on("click", ".editClienteLink", function(){	
	var clienteTable = $('#cliente-table').DataTable();
	resetarBotoesConfirmacoes();
//	validator.resetValidacoes();
	var data = clienteTable.row( $(this).parents('tr') ).data();
	$("#div-codigo").show();
	$('#input-hidden-clienteId').val(data.id);
	$('#input_hidden_enderecoId').val(data.enderecoCliente.endereco.id);
	$('#input_hidden_enderecoClienteId').val(data.enderecoCliente.id);
	$('#input-cliente-nome').val(data.nome);
	$('#input-ponto-referencia').val(data.enderecoCliente.pontoReferencia);
	$('#input-cliente-numero').val(data.enderecoCliente.numero);
	$('#input-cliente-telefone').val(data.telefone);
	$('#input-cliente-telefone2').val(data.telefone2);
	$('#input-cliente-aniversario').val(data.aniversario);
	
	$('#input_endereco-cliente').val(data.enderecoCliente.endereco.name);
	$('#input-cliente-bairro').val(data.enderecoCliente.endereco.bairro);
	$('#input-cliente-municipio').val(data.enderecoCliente.endereco.cidade+"/"+data.enderecoCliente.endereco.descricaoUf);
	$('#input-cliente-cep').val(data.enderecoCliente.endereco.cep);
	
	$('#js-cliente-form').validator('destroy');
	
	$('#clienteFormModal').modal('show'); 
});

function renderListlll(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#wineList li').remove();
	$.each(list, function(index, wine) {
		$('#wineList').append('<li><a href="#" data-identity="' + wine.id + '">'+wine.nome+'</a></li>');
	});
}

function renderDetails(wine) {
	$('#wineId').val(wine.id);
	$('#name').val(wine.name);
	$('#grapes').val(wine.grapes);
	$('#country').val(wine.country);
	$('#region').val(wine.region);
	$('#year').val(wine.year);
	$('#pic').attr('src', 'pics/' + wine.picture);
	$('#description').val(wine.description);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var clienteId = $('#input-hidden-clienteId').val();
	var obj = {
			"id":clienteId, 
			"enderecoCliente":jQuery.parseJSON(enderecoClienteToJSON()),
			"nome":$('#input-cliente-nome').val(), 
			"aniversario":$('#input-cliente-aniversario').val(), 
			"telefone":$('#input-cliente-telefone').val(),
			"telefone2":$('#input-cliente-telefone2').val()};
	
	
	var myJSON = JSON.stringify(obj);
	return myJSON;
}

function enderecoClienteToJSON() {
	var obj = {
			"id": $('#input_hidden_enderecoClienteId').val(), 
			"pontoReferencia": $('#input-ponto-referencia').val(), 
			"numero": $('#input-cliente-numero').val()};
	var myJSON = JSON.stringify(obj);	
	return myJSON;
}

