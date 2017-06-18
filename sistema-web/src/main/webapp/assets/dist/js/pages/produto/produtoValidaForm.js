$(document).ready(function() {
	$("span.help-block").hide();
	$("#input-produto-codigo-busca").keyup(validar);
	$("#input-produto-nome").keyup(validar);
	$("#select-produto-categoria").change(validar);
	$("#input-produto-preco-venda").keyup(validar);
	$("#input-produto-preco-custo").keyup(validar);
	$("#uploadfile").change(validar);
	$("#select-produto-unidade-medida").change(validar);
	$("#input-estoque-estoqueatual").keyup(validar);
	$("#input-estoque-alertaestoque").keyup(validar);
});

function somenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}


function resetarValidacoes(){
	$("div").removeClass("has-error");
	$("div").removeClass("has-success");
	$("div").removeClass("has-feedback");
	$('#label-produto-imagem').html('Imagem');
	$(".iconeValidacao").remove();
}

function verificarProdutoForm(){
    var v1,v2,v3,v4,v5,v6,v7,v8,v9;

    var isValid = false;

    v1 = validar('input-produto-codigo-busca', "submit");
    v2 = validar('input-produto-nome', "submit");
    v3 = validar('select-produto-categoria', "submit");
    v4 = validar('input-produto-preco-venda', "submit");
    v5 = validar('input-produto-preco-custo', "submit");
    v6 = validar('uploadfile', "submit");
    v7 = validar('select-produto-unidade-medida', "submit");
    v8 = validar('input-estoque-estoqueatual', "submit");
    v9 = validar('input-estoque-alertaestoque', "submit");

    return v1 && v2 && v3 && v4 && v5 && v6 && v7 && v8 && v9;
}

function validar(campo, acao){

	if(acao != 'submit'){
		campo = $(this).attr('id');
	}

	if (campo==='input-produto-codigo-busca')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-remove form-control-feedback iconeValidacao'></span>");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-ok form-control-feedback iconeValidacao'></span>");

            return true;
        }
    }

	if (campo==='input-produto-nome')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-remove form-control-feedback iconeValidacao'></span>");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-ok form-control-feedback iconeValidacao'></span>");

            return true;
        }
    }

	if (campo==='select-produto-categoria')
    {
        valor = $("#"+campo).val();
        if(valor == '' || valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");
            console.log('erro: '+valor);

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");
            console.log('sucesso: '+valor);

            return true;
        }
    }

	if (campo==='input-produto-preco-venda')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-remove form-control-feedback iconeValidacao'></span>");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-ok form-control-feedback iconeValidacao'></span>");

            return true;
        }
    }

	if (campo==='input-produto-preco-custo')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-remove form-control-feedback iconeValidacao'></span>");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");
            $('#'+campo).parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-ok form-control-feedback iconeValidacao'></span>");

            return true;
        }
    }

	if (campo==='uploadfile')
    {
        valor = $("#"+campo).val();
        if(valor == null || valor.length == 0 ){
        	valor = $("#produto-nome-imagem").text();
        }
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");
            $('#label-produto-imagem').html('Imagem do produto é obrigatória');
            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");
            $('#label-produto-imagem').html('Imagem');
            return true;
        }
    }

	if (campo==='select-produto-unidade-medida')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-error has-feedback");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().parent().attr("class", "form-group has-success has-feedback");

            return true;
        }
    }

	if (campo==='input-estoque-estoqueatual')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $('#'+campo).parent().parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-remove form-control-feedback iconeValidacao'></span>");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $('#'+campo).parent().parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-ok form-control-feedback iconeValidacao'></span>");

            return true;
        }
    }

	if (campo==='input-estoque-alertaestoque')
    {
        valor = $("#"+campo).val();
        if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $('#'+campo).parent().parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-remove form-control-feedback iconeValidacao'></span>");

            return false;

        }else{
            $("#icone_"+campo).remove();
            $('#'+campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $('#'+campo).parent().parent().append("<span id='icone_"+campo+"' class='glyphicon glyphicon-ok form-control-feedback iconeValidacao'></span>");

            return true;
        }
    }

}


