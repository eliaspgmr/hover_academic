USE `hover_academic` ;
DROP DATABASE `hover_academic`;


-- ---------- usuarios -------------------
desc usuarios;
drop table usuarios;

insert into usuarios
(us_nome, us_login, us_senha, us_cargo)
values
('Elias Ferreira','elias','D+JTNjUUtkyjN40BHSeFrw==','Professor');

select * from usuarios order by us_nome;
select * from usuarios where us_login='root';
delete from usuarios where us_login='root';
-- ---------------------------------------



-- ---------- responsavel -------------------
desc responsavel;

insert into responsavel
(res_nome, res_data_nascimento, res_rg, res_cpf)
values
('Carlos Henrique','1991/03/05','20072149501','05116544303');

select * from responsavel;
select * from responsavel where id_responsavel = 1;
delete from responsavel where id_responsavel= 3;
-- ---------------------------------------



-- ---------- alunos -------------------
desc alunos;
insert into alunos
(usuarios_id_usuario, responsavel_id_responsavel, al_nome, al_data_nascimento, al_rg, al_cpf, al_sexo, al_obs, al_status)
values
('2', null,'Rebeca Ferreira da Silva','2008/05/08','20084584528','15816544303','f',null,'1');

select * from alunos;

select * from alunos join usuarios on usuarios_id_usuario = id_usuario and al_nome like 'marcelo';
select * from alunos left outer join responsavel on responsavel_id_responsavel = id_responsavel;

select * from alunos
join usuarios 
on usuarios_id_usuario = id_usuario
left outer join responsavel
on responsavel_id_responsavel = id_responsavel
where al_nome like 'r%';

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