INSERT INTO Perfil(nome) VALUES ('Administrador'), ('Usuario');

INSERT INTO Usuario(login, senha) VALUES
('admin', '$2a$10$9d5ZznmdaoH./5AYw5E/YuaQGAMRsfrCCQeIeI8479pgk0FbL8cUK')
,('comum', '$2a$10$9d5ZznmdaoH./5AYw5E/YuaQGAMRsfrCCQeIeI8479pgk0FbL8cUK')
;

INSERT INTO Usuario_Perfis(USUARIO_ID, PERFIS_ID) VALUES
(1,1)
,(1,2)
,(2,2)
;

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

INSERT INTO Telefone(numero, tipo, cliente_id) values
('1234567890','RESIDENCIAL',1)
,('1234567890','COMERCIAL',2)
,('1234567890','CELULAR',3)
;