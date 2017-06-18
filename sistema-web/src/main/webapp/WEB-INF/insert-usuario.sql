INSERT INTO empresa (id, cpf_cnpj, razao_social, sigla, desc_sigla) VALUES (1001, '72540094000100', 'DISK 1001', 'DSK1', 'DISK 1001');
INSERT INTO empresa (id, cpf_cnpj, razao_social, sigla, desc_sigla) VALUES (2002, '44193669000112', 'DISK 2002', 'DSK2', 'DISK 2002');
INSERT INTO empresa (id, cpf_cnpj, razao_social, sigla, desc_sigla) VALUES (3003, '32421905000121', 'DISK 3003', 'DSK3', 'DISK 3003');


INSERT INTO usuario (nome, email, password, ativo,empresa_tenant_id, empresa_id) VALUES ('Edmilson Reis', 'admin@gmail.com', SHA2('admin', 256), 1, 1001, 1001 );
INSERT INTO usuario (nome, email, password, ativo,empresa_tenant_id, empresa_id) VALUES ('Kauan dos Reis', 'kauan@gmail.com',SHA2('admin', 256), 1, 2002, 2002 );
INSERT INTO usuario (nome, email, password, ativo,empresa_tenant_id, empresa_id) VALUES ('Lukas Batista', 'lukas@gmail.com',SHA2('admin', 256), 1, 3003, 3003 );

INSERT INTO role (nome ) VALUES ('ADMIN' );
INSERT INTO usuario_role (usuario_id, role_id ) VALUES (1, 1);
INSERT INTO usuario_role (usuario_id, role_id ) VALUES (2, 1);

INSERT INTO endereco (bairro, cep, cidade, desc_uf, logradouro, uf) VALUES ('Alto da Rua XV', '80045-385', 'Curitiba', 'Parana', 'Avenida Sete de Setembro', 'PR');
INSERT INTO endereco (bairro, cep, cidade, desc_uf, logradouro, uf) VALUES ('Centro', '80410-270', 'Curitiba', 'Parana', 'Jardinete Capitão Eduardo Albuquerque Torres Pereira', 'PR');
INSERT INTO endereco (bairro, cep, cidade, desc_uf, logradouro, uf) VALUES ('Cidade Industrial', '81460-250', 'Curitiba', 'Parana', 'Rua Romeu Felipe Bacellar', 'PR');
INSERT INTO endereco (bairro, cep, cidade, desc_uf, logradouro, uf) VALUES ('Boqueirão', '81730-050', 'Curitiba', 'Parana', 'das carmelitas', 'PR');
INSERT INTO endereco (bairro, cep, cidade, desc_uf, logradouro, uf) VALUES ('Boqueirão', '81730-250', 'Curitiba', 'Parana', 'Rua João Fain', 'PR');

INSERT INTO adicional ( empresa_tenant_id, descricao, preco) VALUES ('2002', 'bacon', '1');
INSERT INTO adicional ( empresa_tenant_id, descricao, preco) VALUES ('2002', 'catupiry', '1');

INSERT INTO categoria_produto ( empresa_tenant_id, descricao) VALUES ('2002', 'Lanche');
INSERT INTO categoria_produto ( empresa_tenant_id, descricao) VALUES ('2002', 'Pizza');
INSERT INTO movimentacao_estoque ( empresa_tenant_id, data, quantidade, tipo, usuario) VALUES ('2002', '2017-02-15', '-1', 'venda', 'admin');

INSERT INTO unidade_medida (descricao) VALUES ('Unidade');
INSERT INTO unidade_medida (descricao) VALUES ('Kilo');
INSERT INTO unidade_medida (descricao) VALUES ('Grama');

INSERT INTO estoque (empresa_tenant_id, alerta_estoque, estoque_atual, unidade_medida_id) VALUES ('2002', '7', '20', '1');

INSERT INTO produto (empresa_tenant_id, codigo_busca, ativo, categoria_produto_id, estoque_id) VALUES ('2002', '20', B'0','1', '1');
