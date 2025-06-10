create database aluguel_veiculos;
use aluguel_veiculos;

create table veiculos(
	id_veiculo int primary key auto_increment,
    tipo_veiculo enum('Carro', 'Moto', 'Van') not null,
    modelo_veiculo longtext not null,
    marca_veiculo longtext,
    ano_fabricacao_veiculo year not null check (ano_fabricacao_veiculo < 2025),
    status_veiculo enum('Disponível', 'Alugado', 'Manutenção') not null,
    situação_veiculo enum('Ativo', 'Inativo') not null
);

create view `View_todos_veiculos_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and situação_veiculo = 'Ativo';
SELECT * FROM aluguel_veiculos.view_todos_veiculos_disponiveis;

create view `View_todos_veiculos_manutenção` as select * from veiculos where status_veiculo = 'Manutenção' and situação_veiculo = 'Ativo';
SELECT * FROM aluguel_veiculos.View_todos_veiculos_manutenção;

create view `View_todos_veiculos_alugados` as select * from veiculos where status_veiculo = 'Alugado' and situação_veiculo = 'Ativo';
SELECT * FROM aluguel_veiculos.View_todos_veiculos_alugados;

create view `View_todos_veiculos_inativos` as select * from veiculos where situação_veiculo = 'Inativo';
SELECT * FROM aluguel_veiculos.View_todos_veiculos_inativos;

create view `View_todos_carros_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and tipo_veiculo = 'Carro';
SELECT * FROM aluguel_veiculos.View_todos_carros_disponiveis;

create view `View_todas_motos_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and tipo_veiculo = 'Moto';
SELECT * FROM aluguel_veiculos.View_todas_motos_disponiveis;

create view `View_todas_vans_disponiveis` as select * from veiculos where status_veiculo = 'Disponível' and tipo_veiculo = 'Van';
SELECT * FROM aluguel_veiculos.View_todas_vans_disponiveis;