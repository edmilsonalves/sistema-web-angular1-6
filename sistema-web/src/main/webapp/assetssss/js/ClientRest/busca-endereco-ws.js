//$(document).ready(
//		function() {
//
//			function limpa_formulário_cep() {
//				// Limpa valores do formulário de cep.
//				$("#input_rua").val("");
//				$("#input_bairro").val("");
//				$("#input_cidade").val("");
//				$("#input_estado").val("");
//				$("#input_ibge").val("");
//				$("#input_hidden_endereco_id").val("");
//			}
//
//			// Quando o campo input_endereco perde o foco.
//			$("#input_endereco").blur(
//					function() {
//						
//						// cep ou rua
//						var endereco = $(this).val();
//						
//						//se for numerico entao busca por cep
//						if($.isNumeric(endereco)){
//							var cep = endereco;
//							// Verifica se campo cep possui valor informado.
//							if (cep != "") {
//
//								// Expressão regular para validar o CEP.
//								var validacep = /^[0-9]{8}$/;
//
//								// Valida o formato do CEP.
//								if (validacep.test(cep)) {
//
//									// Preenche os campos com "..." enquanto
//									// consulta webservice.
//									$("#input_rua").val("...");
//									$("#input_bairro").val("...");
//									$("#input_cidade").val("...");
//									$("#input_estado").val("...");
//									$("#input_ibge").val("...");
//
//									// Consulta o webservice viacep.com.br/
//									$.getJSON("http://viacep.com.br/ws/" + cep
//											+ "/json/?callback=?", function(dados) {
//
//										if (!("erro" in dados)) {
//											// Atualiza os campos com os valores da
//											// consulta.
//											$("#input_rua").val(dados.logradouro);
//											$("#input_bairro").val(dados.bairro);
//											$("#input_cidade").val(dados.localidade);
//											$("#input_estado").val(dados.uf);
//											$("#input_ibge").val(dados.ibge);
//										} // end if.
//										else {
//											// CEP pesquisado não foi encontrado.
//											limpa_formulário_cep();
//											alert("CEP não encontrado.");
//										}
//									});
//								} // end if.
//								else {
//									// cep é inválido.
//									limpa_formulário_cep();
//									alert("Formato de CEP inválido.");
//								}
//							} // end if.
//							else {
//								// cep sem valor, limpa formulário.
//								limpa_formulário_cep();
//							}
//						}else{
//							limpa_formulário_cep();
//						}
//				});
//		});
