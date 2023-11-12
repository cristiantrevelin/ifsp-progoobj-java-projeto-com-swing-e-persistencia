DROP DATABASE IF EXISTS imobiliaria_aluga_tudo;
CREATE DATABASE imobiliaria_aluga_tudo;
USE imobiliaria_aluga_tudo;

CREATE TABLE pessoa (
	pe_cpf				CHAR(14) 		NOT NULL, 
	pe_nome				VARCHAR(50) 	NOT NULL,
	pe_email			VARCHAR(150) 	NOT NULL,
	pe_telefone			CHAR(17) 		NOT NULL,
    
    PRIMARY KEY (pe_cpf)
);

CREATE TABLE proprietario (
    pr_cpf				CHAR(14) 		NOT NULL,
    pr_banco 			VARCHAR(50) 	NOT NULL,
    pr_agencia 			INT 			NOT NULL,
    pr_conta 			INT 			NOT NULL,
    
    PRIMARY KEY (pr_cpf),
    FOREIGN KEY (pr_cpf) REFERENCES pessoa (pe_cpf)
);

CREATE TABLE locatario (
	lt_cpf 				CHAR(14) 		NOT NULL,
	lt_limite_aluguel 	DOUBLE 			NOT NULL,
    
    PRIMARY KEY (lt_cpf),
    FOREIGN KEY (lt_cpf) REFERENCES pessoa (pe_cpf)
);

CREATE TABLE imovel (
	im_num 				INT 			NOT NULL,
	im_endereco 		VARCHAR(200) 	NOT NULL,
	im_bairro 			VARCHAR(100) 	NOT NULL,
	im_cidade 			VARCHAR(100) 	NOT NULL,
	im_estado 			VARCHAR(100) 	NOT NULL,
	im_padrao 			CHAR(1) 		NOT NULL,
	im_valor_aluguel 	DOUBLE 			NOT NULL,
	im_situacao 		CHAR(1) 		NOT NULL,
	im_percent_comiss 	DOUBLE 			NOT NULL,
	im_cpf_pr 			CHAR(14) 		NOT NULL,
    
    PRIMARY KEY (im_num),
    FOREIGN KEY (im_cpf_pr) REFERENCES proprietario (pr_cpf)
);

CREATE TABLE locacao (
	lc_num_cont 		INT 			NOT NULL,
	lc_data_cont 		DATE 			NOT NULL,
	lc_prazo_cont 		INT 			NOT NULL,
	lc_valor_aluguel 	DOUBLE 			NOT NULL,
	lc_dia_venc 		INT 			NOT NULL,
	lc_num_im 			INT 			NOT NULL,
	lc_cpf_lt 			CHAR(14) 		NOT NULL,
    
    PRIMARY KEY (lc_num_cont),
    FOREIGN KEY (lc_num_im) REFERENCES imovel (im_num),
    FOREIGN KEY (lc_cpf_lt) REFERENCES locatario (lt_cpf)
);

CREATE TABLE pagamento (
	pa_data_venc 		DATE 			NOT NULL,
	pa_data_pagam 		DATE 			NULL,
	pa_valor_pagar 		DOUBLE 			NOT NULL,
	pa_valor_pago 		DOUBLE 			NOT NULL,
	pa_num_cont_lc 		INT 			NOT NULL,
    
    FOREIGN KEY (pa_num_cont_lc) REFERENCES locacao (lc_num_cont)
);
