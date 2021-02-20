INSERT INTO Perfil(nome) VALUES ('Administrador'), ('Usuario');

INSERT INTO Usuario(login, senha) VALUES
('admin', '123456')
,('comum', '123456')
;

-- INSERT INTO Usuario_Perfis(fk_usuario, fk_perfil) VALUES
-- (1,1)
-- ,(2,2)
-- ;

INSERT INTO Endereco(BAIRRO, CEP, CIDADE, LOGRADOURO, UF) VALUES
('asa norte','7012345','Brasília','SQN 123 BLOCO A AP 101','DF')
,('asa sul','7012233','Brasília','SQS 123 BLOCO A AP 101','DF')
,('sudoeste','7054321','Brasília','SQSW 123 BLOCO A AP 101','DF')
;

INSERT INTO Cliente(cpf, nome, endereco_id) VALUES
('73595595025','Maria', 1)
,('38944079056','João', 2)
,('06457830056','José', 3)
;

INSERT INTO Cliente_Email(cliente_id, email) values
(1,'email@email.com')
,(2,'email2@email.com')
,(3,'email3@email.com')
;

INSERT INTO Cliente_Telefone(cliente_id, telefone) values
(1,'1234567890')
,(2,'1234567890')
,(3,'1234567890')
;