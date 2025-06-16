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


---------------------------------------------------------------------------------------------------------------------------
-- INSERÇÕES DE DADOS

-- Carros
INSERT INTO veiculos VALUES 
(default, 'Carro', 'Civic', 'Honda', 'HOND1234', 2020, 'Disponível', 'Ativo'),
(default, 'Carro', 'Corolla', 'Toyota', 'TOYO4321', 2023, 'Alugado', 'Ativo'),
(default, 'Carro', 'Gol', 'Volkswagen', 'VWGOL2021', 2018, 'Manutenção', 'Ativo'),
(default, 'Carro', 'HB20', 'Hyundai', 'HYHB2001', 2017, 'Disponível', 'Ativo'),
(default, 'Carro', 'Uno', 'Fiat', '1234ADAT', 2012, 'Disponível', 'Ativo'), 
(default, 'Carro', 'Focus', 'Ford', '1214JFAJ', 2019, 'Manutenção', 'Ativo'), 
(default, 'Carro', 'Fusca', 'Volkswagen', '9821KFAN', 1982, 'Alugado', 'Ativo'); 

-- Motos
INSERT INTO veiculos VALUES 
(default, 'Moto', 'Titan 160', 'Honda', 'MOTO1111', 2021, 'Disponível', 'Ativo'),
(default, 'Moto', 'Ninja 400', 'Kawasaki', 'KAWK400', 2022, 'Alugado', 'Ativo'),
(default, 'Moto', 'Pop 100', 'Honda', 'POP100BR', 2015, 'Manutenção', 'Ativo'),
(default, 'Moto', 'S1000', 'BMW', '2135FGAS', 2022, 'Disponível', 'Ativo'), 
(default, 'Moto', 'CG-125', 'Honda', '9224JFAS', 2016, 'Manutenção', 'Ativo'), 
(default, 'Moto', 'XJ6', 'Yamaha', '9341JASH', 2017, 'Alugado', 'Ativo');

-- Vans
INSERT INTO veiculos VALUES 
(default, 'Van', 'Boxer', 'Peugeot', 'PEUBOX23', 2020, 'Disponível', 'Ativo'),
(default, 'Van', 'Iveco Daily', 'Iveco', 'IVE12345', 2018, 'Alugado', 'Ativo'),
(default, 'Van', 'Kombi', 'Volkswagen', 'KOMBIRET', 2003, 'Manutenção', 'Ativo'),
(default, 'Van', 'Sprinter', 'Mercedes Benz', '9272JMSAJ', 1999, 'Disponível', 'Ativo'), 
(default, 'Van', 'Master', 'Renault', '1234AJKT', 2024, 'Manutenção', 'Ativo'), 
(default, 'Van', 'Ducato', 'Fiat', '5886DATM', 2019, 'Alugado', 'Ativo');

TRUNCATE veiculos;