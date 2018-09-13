USE `hover_academic` ;


-- ---------- usuarios -------------------
desc usuarios;

insert into usuarios
(nome, login, senha, cargo)
values
('Carlos Henrique','carlos','arkanjo','Professor');

select * from usuarios;

delete from usuarios where login='elias';
-- ---------------------------------------
-- ---------- responsavel -------------------
desc responsavel;

insert into responsavel
(nome, data_nascimento, rg, cpf)
values
('Carlos Henrique','1991/03/05','20072149501','05116544303');

select * from responsavel;

delete from responsavel where id_responsavel= 1;
-- ---------------------------------------
-- ---------- alunos -------------------
desc alunos;
insert into alunos
(usuarios_id_usuario, responsavel_id_responsavel, nome, data_nascimento, rg, cpf, sexo, obs, status)
values
('4','3','marcelo','2005/05/27','20054589621','15975345602','m','','1');

select * from alunos;

delete from alunos where id_aluno = 1;

drop table alunos;
-- ---------------------------------------
-- ---------- financeiro -------------------
desc financeiro;

insert into financeiro
(alunos_id_aluno, num_parcelas, valor, matricula)
values
('1','12','59.99','50.00');

select * from financeiro;

drop table financeiro;
-- ---------------------------------------
-- ---------- cancelamento -------------------
desc cancelamento;

insert into cancelamento
(financeiro_id_financeiro, data, valor)
values
('1','2018/09/12','1050.99');

select * from cancelamento;

drop table cancelamento;
-- ---------------------------------------
-- ---------- parcelas -------------------
desc parcelas;

insert into parcelas
(financeiro_id_financeiro, numero, valor, juros, status)
values
('1','2','60.00','0.00','1');

select * from parcelas;

drop table parcelas;