CREATE TABLE Genero (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL
);

CREATE TABLE Nivel (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL
);

CREATE TABLE Categoria (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL,
    genero_id INT REFERENCES Genero(id) NOT NULL,
    genero_name VARCHAR(255),
    nivel_id INT REFERENCES Nivel(id) NOT NULL,
    nivel_name VARCHAR(255)
);

CREATE TABLE Status (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Torneio (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quantidade_min_duplas INT,
    configuracao_game_set VARCHAR(255),
    status_id INT REFERENCES Status(id)
);


CREATE TABLE Categoria_Torneio (
    id SERIAL PRIMARY KEY,
    categoria_id INT REFERENCES Categoria(id) NOT NULL,
    torneio_id INT REFERENCES Torneio(id) NOT NULL
);


CREATE TABLE Jogador (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255),
    genero INT REFERENCES Genero(id),
    nivel INT REFERENCES Nivel(id)
);

CREATE TABLE Dupla (
    id SERIAL PRIMARY KEY,
    jogadorA INT REFERENCES Jogador(id),
    jogadorB INT REFERENCES Jogador(id)
);

CREATE TABLE Dupla_Torneio (
    id SERIAL PRIMARY KEY,
    categoria_id INT REFERENCES Dupla(id),
    torneio_id INT REFERENCES Torneio(id)
);


------ CRIAÇÃO DE MASSA

-- Dependencia para adicionar um torneio
INSERT INTO Sport (sport_name)
VALUES ('Beach Tennis');
-- Criar o Match
INSERT INTO Match (match_name, sport_id)
VALUES ('PUTA TÊNIS Vila verde', 1);
-- Criar 2 times
INSERT INTO Team (team_name)
VALUES ('BOCOS');
-- Add jogador aos times
INSERT INTO Player (player_name, team_id)
VALUES('Rafael',2);
-- Adicionar time a Match
UPDATE public.torneio
SET team_b = 2
WHERE id = 1;
-- -- Criar as regras do Match
-- -- Configurar Set - Informar a qtde de Set (Id(PK), Match_Id(FK), Time1_Score, Time2_Score, Set_Number, Vencedor)
INSERT INTO public.set(
	match_id, team_a_score, team_b_score, set_order)
	VALUES (1, 0, 0, 1);
-- -- Configurar Game por Set - Informar a quantidade de Game por Set (Id, Set_Id, Time1_Score, Time2_Score, Vencedor)
INSERT INTO public.game(
	set_id, team_a_score, team_b_score)
	VALUES (1, 0, 0);
-- -- Após criar o Match, inicia-se com a contagem inicial. Não tem vencedor, o Set é 1 e o Game é 1.


------ CONSULTAS ÚTEIS
