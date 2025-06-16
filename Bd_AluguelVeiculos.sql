create database aluguel_veiculos;
use aluguel_veiculos;

create table veiculos(
	id_veiculo int primary key auto_increment,
    tipo_veiculo enum('Carro', 'Moto', 'Van') not null,
    modelo_veiculo longtext not null,
    marca_veiculo longtext,
    placa_veiculo varchar(20) not null unique,
    ano_fabricacao_veiculo year not null check (ano_fabricacao_veiculo <= 2025),
    status_veiculo enum('Disponível', 'Alugado', 'Manutenção') not null default 'Disponível',
    situação_veiculo enum('Ativo', 'Inativo') not null default 'Ativo'
);

select * from veiculos;


---------------------------------------------------------------------------------------------------------------------------------------
-- Geral

create view `View_todos_veiculos_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and situação_veiculo = 'Ativo';
SELECT * FROM aluguel_veiculos.view_todos_veiculos_disponiveis;

create view `View_todos_veiculos_manutenção` as select * from veiculos where status_veiculo = 'Manutenção' and situação_veiculo = 'Ativo';
SELECT * FROM aluguel_veiculos.View_todos_veiculos_manutenção;

create view `View_todos_veiculos_alugados` as select * from veiculos where status_veiculo = 'Alugado' and situação_veiculo = 'Ativo';
SELECT * FROM aluguel_veiculos.View_todos_veiculos_alugados;

---------------------------------------------------------------------------------------------------------------------------------------
-- Veículos apagados/excluídos | Após a Remoção ela n some do BD, somente fica inativa

create view `View_todos_veiculos_inativos` as select * from veiculos where situação_veiculo = 'Inativo';
SELECT * FROM aluguel_veiculos.View_todos_veiculos_inativos;


---------------------------------------------------------------------------------------------------------------------------------------
-- Carros

create view `View_todos_carros_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and tipo_veiculo = 'Carro';
SELECT * FROM aluguel_veiculos.View_todos_carros_disponiveis;

create view `View_todos_carros_alugados` as select * from veiculos where status_veiculo = 'Alugado' and tipo_veiculo = 'Carro';
SELECT * FROM aluguel_veiculos.View_todos_carros_alugados;

create view `View_todos_carros_manutenção` as select * from veiculos where status_veiculo = 'Manutenção' and tipo_veiculo = 'Carro';
SELECT * FROM aluguel_veiculos.View_todos_carros_manutenção;


---------------------------------------------------------------------------------------------------------------------------------------
-- Motos

create view `View_todas_motos_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and tipo_veiculo = 'Moto';
SELECT * FROM aluguel_veiculos.View_todas_motos_disponiveis;

create view `View_todas_motos_alugadas` as select * from veiculos where status_veiculo = 'Alugado' and tipo_veiculo = 'Moto';
SELECT * FROM aluguel_veiculos.View_todas_motos_alugadas;

create view `View_todas_motos_manutenção` as select * from veiculos where status_veiculo = 'Manutenção' and tipo_veiculo = 'Moto';
SELECT * FROM aluguel_veiculos.View_todas_motos_manutenção;


---------------------------------------------------------------------------------------------------------------------------------------
-- Vans

create view `View_todas_vans_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and tipo_veiculo = 'Van';
SELECT * FROM aluguel_veiculos.View_todas_vans_disponiveis;

create view `View_todas_vans_alugadas` as select * from veiculos where status_veiculo = 'Alugado' and tipo_veiculo = 'Van';
SELECT * FROM aluguel_veiculos.View_todas_vans_alugadas;

create view `View_todas_vans_manutenção` as select * from veiculos where status_veiculo = 'Manutenção' and tipo_veiculo = 'Van';
SELECT * FROM aluguel_veiculos.View_todas_vans_manutenção;