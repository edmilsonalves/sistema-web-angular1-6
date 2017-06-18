/*
 * Biblioteca de evendos jQuery
 * Created on : 30/07/2016, 17:14:28
 * Author     : Anderson O. Aristides
 */
//############## SERIALIZE FORM JSON
//$.fn.serializeObject = function() {
//
//	var self = this, json = {}, push_counters = {}, patterns = {
//		"validate" : /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
//		"key" : /[a-zA-Z0-9_]+|(?=\[\])/g,
//		"push" : /^$/,
//		"fixed" : /^\d+$/,
//		"named" : /^[a-zA-Z0-9_]+$/
//	};
//
//	this.build = function(base, key, value) {
//		base[key] = value;
//		return base;
//	};
//
//	this.push_counter = function(key) {
//		if (push_counters[key] === undefined) {
//			push_counters[key] = 0;
//		}
//		return push_counters[key]++;
//	};
//
//	$
//			.each(
//					$(this).serializeArray(),
//					function() {
//
//						// skip invalid keys
//						if (!patterns.validate.test(this.name)) {
//							return;
//						}
//
//						var k, keys = this.name.match(patterns.key), merge = this.value, reverse_key = this.name;
//
//						while ((k = keys.pop()) !== undefined) {
//
//							// adjust reverse_key
//							reverse_key = reverse_key.replace(new RegExp("\\["
//									+ k + "\\]$"), '');
//
//							// push
//							if (k.match(patterns.push)) {
//								merge = self.build([], self
//										.push_counter(reverse_key), merge);
//							}
//
//							// fixed
//							else if (k.match(patterns.fixed)) {
//								merge = self.build([], k, merge);
//							}
//
//							// named
//							else if (k.match(patterns.named)) {
//								merge = self.build({}, k, merge);
//							}
//						}
//
//						json = $.extend(true, json, merge);
//					});
//
//	return json;
//};
//
//// Function Reset Criada para resetar os formularios nas modais
//jQuery.fn.reset = function() {
//	this.each(function() {
//		if ($(this).is('form')) {
//			var button = jQuery(jQuery('<input type="reset" />'));
//			button.hide();
//			$(this).append(button);
//			button.click().remove();
//		} else if ($(this).parent('form').size()) {
//			var button = jQuery(jQuery('<input type="reset" />'));
//			button.hide();
//			$(this).parent('form').append(button);
//			button.click().remove();
//		} else if ($(this).find('form').size()) {
//			$(this).find('form').each(function() {
//				var button = jQuery(jQuery('<input type="reset" />'));
//				button.hide();
//				$(this).append(button);
//				button.click().remove();
//			});
//		}
//	});
//
//	return this;
//};
//
//// ############## MESSAGE
//function TriggerMessage(Message, ErrNo) {
//	$('.trigger_ajax').fadeOut('fast', function() {
//		$(this).remove();
//	});
//
//	var CssClass = (ErrNo == "trigger_info" ? 'info'
//			: (ErrNo == "trigger_warning" ? 'warning'
//					: (ErrNo == "trigger_error" ? 'danger' : 'success')));
//	var iconCss = (ErrNo == "trigger_info" ? 'info-circle'
//			: (ErrNo == "trigger_warning" ? 'exclamation-triangle'
//					: (ErrNo == "trigger_error" ? 'times' : 'check')));
//	var textAlert = (ErrNo == "trigger_info" ? 'Informação'
//			: (ErrNo == "trigger_warning" ? 'Aviso'
//					: (ErrNo == "trigger_error" ? 'Erro' : 'Sucesso')));
//
//	return '<div class="alert alert-' + CssClass
//			+ '  fade in m-b-15 trigger_ajax"><i class="fa  fa-' + iconCss
//			+ '"></i> <strong> ' + textAlert + '!</strong> ' + Message
//			+ '<span class="close" data-dismiss="alert">×</span></div>';
//}
//
//// FECHAR TRIGGER MODAL
//function TriggerClose() {
//	$('.trigger_ajax').fadeOut('fast', function() {
//		$(this).remove();
//	});
//}
//
//
//// Tradução dataTable Portugues Brasil
//function traducaoDataTable() {
//	var traducao = {
//		"emptyTable" : "Nenhum registro encontrado",
//		"info" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
//		"infoEmpty" : "Mostrando 0 até 0 de 0 registros",
//		"infoFiltered" : "(Filtrados de _MAX_ registros)",
//		"infoPostFix" : "",
//		"thousands" : ".",
//		"lengthMenu" : "_MENU_ resultados por página",
//		"loadingRecords" : "Carregando...",
//		"processing" : "Processando...",
//		"zeroRecords" : "Nenhum registro encontrado",
//		"search" : "Pesquisar",
//		"paginate" : {
//			"next" : "Próximo",
//			"previous" : "Anterior",
//			"first" : "Primeiro",
//			"last" : "Último"
//		},
//		"aria" : {
//			"sortAscending" : ": Ordenar colunas de forma ascendente",
//			"sortDescending" : ": Ordenar colunas de forma descendente"
//		}
//	};
//
//	return traducao;
//}
//
////Ações dataTable
//function acoesDataTable() {
//	var acoes = '<a name="edit" id="edit" href="#modal-dialog-edit" class="label label-success" data-toggle="modal"><i class="glyphicon glyphicon-pencil"></i></a>'
//		+ '&nbsp'
//		+'<a  name="alert" id="alert" href="#modal-alert" class="label label-danger" data-toggle="modal"><i class="glyphicon glyphicon-trash"></i></a>';
//	return acoes;
//}
//


//URI BASE REST
function sAction() {
	return 'http://' + window.location.host + '/sistema-web/none/';
}


$(document).ready(function() {
	 $('.dataTables_filter input').attr("placeholder", "Pesquise aqui");
//	 $("input[type='search']").attr("placeholder", "Pesquise aqui");
});

//remove acentos na hora de fazeer a pesquisa no datatable
//jQuery.fn.DataTable.ext.type.search.string = function ( data ) {
//    return ! data ?
//        '' :
//        typeof data === 'string' ?
//            data
//                .replace( /έ/g, 'ε')
//                .replace( /ύ/g, 'υ')
//                .replace( /ό/g, 'ο')
//                .replace( /ώ/g, 'ω')
//                .replace( /ά/g, 'α')
//                .replace( /ί/g, 'ι')
//                .replace( /ή/g, 'η')
//                .replace( /\n/g, ' ' )
//                .replace( /[áÁ]/g, 'a' )
//                .replace( /[éÉ]/g, 'e' )
//                .replace( /[íÍ]/g, 'i' )
//                .replace( /[óÓ]/g, 'o' )
//                .replace( /[úÚ]/g, 'u' )
//                .replace( /ê/g, 'e' )
//                .replace( /î/g, 'i' )
//                .replace( /ô/g, 'o' )
//                .replace( /è/g, 'e' )
//                .replace( /ï/g, 'i' )
//                .replace( /ü/g, 'u' )
//                .replace( /ã/g, 'a' )
//                .replace( /õ/g, 'o' )
//                .replace( /ç/g, 'c' )
//                .replace( /ì/g, 'i' ) :
//            data;
//};

//Tradução dataTable default Portugues Brasil
function traducaoDefaultDataTable() {
	var traducao = {
		"sEmptyTable" : "Nenhum registro encontrado",
		"sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
		"sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
		"sInfoFiltered" : "(Filtrados de _MAX_ registros)",
		"sInfoPostFix" : "",
		"sInfoThousands" : ".",
		"sLengthMenu" : "_MENU_ resultados por página",
		"sLoadingRecords" : "Carregando...",
		"sProcessing" : "Processando...",
		"sZeroRecords" : "Nenhum registro encontrado",
		"oPaginate" : {
			"sNext" : "Próximo",
			"sPrevious" : "Anterior",
			"sFirst" : "Primeiro",
			"sLast" : "Último"
		},
		"oAria" : {
			"sSortAscending" : ": Ordenar colunas de forma ascendente",
			"sSortDescending" : ": Ordenar colunas de forma descendente"
		}
	};

	return traducao;
}

// Tradução dataTable Portugues Brasil
function traducaoDataTable() {
	var traducao = {
		"sEmptyTable" : "Nenhum registro encontrado",
		"sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
		"sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
		"sInfoFiltered" : "(Filtrados de _MAX_ registros)",
		"sInfoPostFix" : "",
		"sInfoThousands" : ".",
		"sLengthMenu" : "_MENU_ resultados por página",
		"sLoadingRecords" : "Carregando...",
		"sProcessing" : "Processando...",
		"sZeroRecords" : "Nenhum registro encontrado",
		"sSearch" : "Pesquisar",
		"oPaginate" : {
			"sNext" : "Próximo",
			"sPrevious" : "Anterior",
			"sFirst" : "Primeiro",
			"sLast" : "Último"
		},
		"oAria" : {
			"sSortAscending" : ": Ordenar colunas de forma ascendente",
			"sSortDescending" : ": Ordenar colunas de forma descendente"
		}
	};

	return traducao;
}

// $(".campo-telefone").mask("(999) 9999-9999");
//
// jQuery(function($){
// $(".campo-data").mask("99/99/9999",{placeholder:"mm/dd/yyyy"});
// $(".campo-telefone").mask("(999) 999-9999");
// $('.campo-rg').mask('9.999.999-9');
// });

function mascaraCpfCnpj(o, f) {
	v_obj = o
	v_fun = f
	setTimeout('execmascara()', 1)
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value)
}

function cpfCnpj(v) {

	// Remove tudo o que não é dígito
	v = v.replace(/\D/g, "")

	if (v.length <= 14) { // CPF

		// Coloca um ponto entre o terceiro e o quarto dígitos
		v = v.replace(/(\d{3})(\d)/, "$1.$2")

		// Coloca um ponto entre o terceiro e o quarto dígitos
		// de novo (para o segundo bloco de números)
		v = v.replace(/(\d{3})(\d)/, "$1.$2")

		// Coloca um hífen entre o terceiro e o quarto dígitos
		v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2")

	} else { // CNPJ

		// Coloca ponto entre o segundo e o terceiro dígitos
		v = v.replace(/^(\d{2})(\d)/, "$1.$2")

		// Coloca ponto entre o quinto e o sexto dígitos
		v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3")

		// Coloca uma barra entre o oitavo e o nono dígitos
		v = v.replace(/\.(\d{3})(\d)/, ".$1/$2")

		// Coloca um hífen depois do bloco de quatro dígitos
		v = v.replace(/(\d{4})(\d)/, "$1-$2")

	}

	return v
}

$(document)
		.ready(
				function(e) {
					$(".calendario")
							.datepicker(
									{
										dayNamesMin : [ 'D', 'S', 'T', 'Q',
												'Q', 'S', 'S', 'D' ],
										dayNamesShort : [ 'Dom', 'Seg', 'Ter',
												'Qua', 'Qui', 'Sex', 'Sáb',
												'Dom' ],
										dayNames : [ 'Domingo', 'Segunda',
												'Terça', 'Quarta', 'Quinta',
												'Sexta', 'Sábado' ],
										monthNamesShort : [ 'Jan', 'Fev',
												'Mar', 'Abr', 'Mai', 'Jun',
												'Jul', 'Ago', 'Set', 'Out',
												'Nov', 'Dez' ],
										monthNames : [ 'Janeiro', 'Fevereiro',
												'Março', 'Abril', 'Maio',
												'Junho', 'Julho', 'Agosto',
												'Setembro', 'Outubro',
												'Novembro', 'Dezembro' ],
										dateFormat : 'dd/mm/yy',
										nextText : 'Próximo',
										prevText : 'Anterior',
									     changeMonth: true,
									     changeYear: true,
									     onSelect: function(dateText, inst) {
									    	 this.focus();
									     }
									});
				});
$('.calendario').mask("99/99/9999");

//$(function() {
//    $('input[name="birthdate"]').daterangepicker({
//        singleDatePicker: true,
//        showDropdowns: true
//    });
//});

function validaData(data) {
    var patternData = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;
    if(!patternData.test(data)){
        return false;
    }else{
    	return true;
    }
}

$(document).ready(function(){
	  $('.date').mask('00/00/0000');
	  $('.time').mask('00:00:00');
	  $('.date_time').mask('00/00/0000 00:00:00');
	  $('.cep').mask('00000-000');
	  $('.phone').mask('0000-0000');
	  $('.phone_with_ddd').mask('(00) 0000-0000');
	  $('.phone_us').mask('(000) 000-0000');
	  $('.mixed').mask('AAA 000-S0S');
	  $('.cpf').mask('000.000.000-00', {reverse: true});
	  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
	  $('.moeda1').mask('000.000.000.000.000,00', {reverse: true});
	  $('.moeda').mask("#.##0,00", {reverse: true});
	  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
	    translation: {
	      'Z': {
	        pattern: /[0-9]/, optional: true
	      }
	    }
	  });
	  $('.ip_address').mask('099.099.099.099');
	  $('.percent').mask('##0,00%', {reverse: true});
	  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
	  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
	  $('.fallback').mask("00r00r0000", {
	      translation: {
	        'r': {
	          pattern: /[\/]/,
	          fallback: '/'
	        },
	        placeholder: "__/__/____"
	      }
	    });
	  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});
	});

$(document).ready(function() {

	$(".caixa_alta").blur(function() {
		$(this).val($(this).val().toUpperCase());
	});

});

$(document).ready(function() {

	$(".caixa_baixa").blur(function() {

		$(this).val($(this).val().toLowerCase());

	});
});

$('.campo_telefone').focusout(function(){
    var phone, element;
    element = $(this);
    element.unmask();
    phone = element.val().replace(/\D/g, '');
    if(phone.length > 10) {
        element.mask("(99) 99999-999?9");
    } else {
        element.mask("(99) 9999-9999?9");
    }
}).trigger('focusout');


$(document).ready(function(){
	  $('.date').mask('00/00/0000');
	  $('.time').mask('00:00:00');
	  $('.date_time').mask('00/00/0000 00:00:00');
	  $('.cep').mask('00000-000');
	  $('.phone').mask('0000-0000');
	  $('.phone_with_ddd').mask('(00) 0000-0000');
	  $('.phone_us').mask('(000) 000-0000');
	  $('.mixed').mask('AAA 000-S0S');
	  $('.cpf').mask('000.000.000-00', {reverse: true});
	  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
	  $('.money').mask('000.000.000.000.000,00', {reverse: true});
	  $('.moeda').mask("#.##0,00", {reverse: true});
	  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
	    translation: {
	      'Z': {
	        pattern: /[0-9]/, optional: true
	      }
	    }
	  });
	  $('.ip_address').mask('099.099.099.099');
	  $('.percent').mask('##0,00%', {reverse: true});
	  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
	  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
	  $('.fallback').mask("00r00r0000", {
	      translation: {
	        'r': {
	          pattern: /[\/]/,
	          fallback: '/'
	        },
	        placeholder: "__/__/____"
	      }
	    });
	  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});
	});


//############## SERIALIZE FORM JSON
$.fn.serializeObject = function(){
	    var self = this,
	        json = {},
	        push_counters = {},
	        patterns = {
	            "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
	            "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
	            "push":     /^$/,
	            "fixed":    /^\d+$/,
	            "named":    /^[a-zA-Z0-9_]+$/
	        };


	    this.build = function(base, key, value){
	        base[key] = value;
	        return base;
	    };

	    this.push_counter = function(key){
	        if(push_counters[key] === undefined){
	            push_counters[key] = 0;
	        }
	        return push_counters[key]++;
	    };

	    $.each($(this).serializeArray(), function(){

	        // skip invalid keys
	        if(!patterns.validate.test(this.name)){
	            return;
	        }

	        var k,
	            keys = this.name.match(patterns.key),
	            merge = this.value,
	            reverse_key = this.name;

	        while((k = keys.pop()) !== undefined){

	            // adjust reverse_key
	            reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');

	            // push
	            if(k.match(patterns.push)){
	                merge = self.build([], self.push_counter(reverse_key), merge);
	            }

	            // fixed
	            else if(k.match(patterns.fixed)){
	                merge = self.build([], k, merge);
	            }

	            // named
	            else if(k.match(patterns.named)){
	                merge = self.build({}, k, merge);
	            }
	        }

	        json = $.extend(true, json, merge);
	    });

	    return json;
	};

	//Function Reset Criada para resetar os formularios nas modais
jQuery.fn.reset = function() {
	 this.each(function() {
	  if ($(this).is('form')) {
	   var button = jQuery(jQuery('<input type="reset" />'));
	   button.hide();
	   $(this).append(button);
	   button.click().remove();
	  } else if ($(this).parent('form').size()) {
	   var button = jQuery(jQuery('<input type="reset" />'));
	   button.hide();
	   $(this).parent('form').append(button);
	   button.click().remove();
	  } else if ($(this).find('form').size()) {
	   $(this).find('form').each(function() {
	    var button = jQuery(jQuery('<input type="reset" />'));
	    button.hide();
	    $(this).append(button);
	    button.click().remove();
	   });
	  }
	 });

	 return this;
	};

	function handleEnter (field, event) {
		   var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		  if (keyCode == 13) {
		    var i;
		  for (i = 0; i < field.form.elements.length; i++)
		     if (field == field.form.elements[ i ])
		       break;
		       i = (i + 1) % field.form.elements.length;
		       field.form.elements[ i ].focus();
		       return false;
		    }
		   else
		return true;
}

function paginacao(){
	$('table.paginated').each(function() {
		console.log('paginando');
	    var currentPage = 0;
	    var numPerPage = 3;
	    var $table = $(this);
	    $table.bind('repaginate', function() {
	        $table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	    });
	    $table.trigger('repaginate');
	    var numRows = $table.find('tbody tr').length;
	    var numPages = Math.ceil(numRows / numPerPage);
	    var $pager = $('<ul class="pagination pagination-sm pull-right paginated-ul" style="margin-top: -15px"></ul>');
	    for (var page = 0; page < numPages; page++) {
	    	var pg = page + 1;
	    	var active = '';
	    	if(page == 0){
	    		active  = ' active pageSelecionada'
	    	}

	    	$('<li class="page-item'+active+'"></li>').html('<a class="page-link" href="#">'+pg+'</a>').bind('click', {
	            newPage: page
	        }, function(event) {
	            currentPage = event.data['newPage'];
	            $table.trigger('repaginate');
	            $(this).addClass('active pageSelecionada').siblings().removeClass('active pageSelecionada');

		    	$(".pg-proximo").parent().removeClass('disabled');
	    		$(".pg-proximo").prop('disabled', false);

	    		$(".pg-anterior").parent().removeClass('disabled');
	    		$(".pg-anterior").prop('disabled', false);

	        }).appendTo($pager).addClass('clickable');

	    }
	    $pager.prepend('<li class="page-item"> <a class="page-link pg-anterior" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span> </a> </li>')
	    .append('<li class="page-item"> <a class="page-link pg-proximo" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span> </a> </li>')
	    .insertAfter($table).find('span.page-number:first').addClass('active pageSelecionada');

	    $(".pg-anterior").on("click",function() {
	    	var pagina = currentPage - 1;

//		    	console.log('Pagina atual: << '+currentPage);
//		    	console.log('Pagina proxima: << '+pagina);

	    	$(".pg-proximo").parent().removeClass('disabled');
    		$(".pg-proximo").prop('disabled', false);

	    	if(pagina >= 0){
		        currentPage = pagina;
		        $table.trigger('repaginate');
		        $(".pageSelecionada").prev().addClass('active pageSelecionada').siblings().removeClass('active pageSelecionada');
		        if(pagina === 0){
		        	$(".pg-anterior").parent().addClass('disabled');
		    		$(".pg-anterior").prop('disabled', true);
		        }
	    	}else{
	    		$(".pg-anterior").parent().addClass('disabled');
	    		$(".pg-anterior").prop('disabled', true);
	    	}

		});

	    $(".pg-proximo").on("click",function() {
	    	var pagina = currentPage + 1;

//		    	console.log('Pagina atual >>: '+currentPage);
//		    	console.log('Pagina proxima >>: '+pagina);

	    	$(".pg-anterior").parent().removeClass('disabled');
    		$(".pg-anterior").prop('disabled', false);

	    	if(pagina < numPages){
		        currentPage = pagina;
		        $table.trigger('repaginate');
		        $(".pageSelecionada").next().addClass('active pageSelecionada').siblings().removeClass('active pageSelecionada');

		        if(pagina+1 === numPages){
		        	$(".pg-proximo").parent().addClass('disabled');
		    		$(".pg-proximo").prop('disabled', true);
		        }
	    	}else{
	    		$(".pg-proximo").parent().addClass('disabled');
	    		$(".pg-proximo").prop('disabled', true);
	    	}

		});

	});
}
